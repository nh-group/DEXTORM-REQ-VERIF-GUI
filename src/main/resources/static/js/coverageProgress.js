var globalMetrics = [];
var userStoriesMetrics = [];

function getNewProgressBar(label, score) {
    return `
    <div class="container">
    <div class="row">
        <div class="col">
            ${label}
        </div>
        <div class="col-10">
            <div class="progress mb-4">
                <div class="progress-bar" role="progressbar" style="width: ${score}%;" aria-valuenow="${score}" aria-valuemin="0" aria-valuemax="100">${score}%</div>
            </div>
        </div>
    </div>
    </div>
    `;
}

function displayCoverageResult(testResultClass, coverageResult, commentsToDisplay) {
    $(testResultClass).append("<h3>Gumtree</h3>");
    $(testResultClass).append(getNewProgressBar("line-based coverage", coverageResult.gumtree.lineCoverage) );
    $(testResultClass).append(`<p><strong>Comment :</strong> ${commentsToDisplay.gumtree.line}</p><hr/>`);
    $(testResultClass).append(getNewProgressBar("methods coverage", coverageResult.gumtree.methodCoverage) );
    $(testResultClass).append(`<p><strong>Comment :</strong> ${commentsToDisplay.gumtree.method}</p><hr/>`);
    $(testResultClass).append("<h3>Git blame</h3>");
    $(testResultClass).append(getNewProgressBar("line-based coverage", coverageResult.gitblame.lineCoverage) );
    $(testResultClass).append(`<p><strong>Comment :</strong> ${commentsToDisplay.gitblame.line}</p><hr/>`);
    $(testResultClass).append(getNewProgressBar("methods coverage", coverageResult.gitblame.methodCoverage) );
    $(testResultClass).append(`<p><strong>Comment :</strong> ${commentsToDisplay.gitblame.method}</p><hr/>`);
}

function getCoverageComments(type) {
    let commentsToDisplay = { gumtree : { line: "none", method :"none" }, gitblame : { line: "none", method :"none" } };
    metrics = []

    if(type === "User story")
        metrics = userStoriesMetrics;
    
    else if(type === "global")
        metrics = globalMetrics;

    metrics.forEach(function(metric) {
        if(isCoverageInMetricInterval(coverageResult.gumtree.lineCoverage, metric) )
            commentsToDisplay.gumtree.line = metric.comment;

        if(isCoverageInMetricInterval(coverageResult.gumtree.methodCoverage, metric) )
            commentsToDisplay.gumtree.method = metric.comment;
    
        if(isCoverageInMetricInterval(coverageResult.gitblame.lineCoverage, metric) )
            commentsToDisplay.gitblame.line = metric.comment;

        if(isCoverageInMetricInterval(coverageResult.gitblame.methodCoverage, metric) )
            commentsToDisplay.gitblame.method = metric.comment;
    });

    return commentsToDisplay;
}

$('button.runTestCase').click(function(event) {
    fetch("http://localhost:3000/coverage/issue/all", {cache: "no-store"})
    .then(response => response.json())
    .then(allCoverageResult => {
        let numberOfIssue = $(event.target).attr('id');
        coverageResult = allCoverageResult.issues[numberOfIssue];
        const testResultClass = ".testResult-"+numberOfIssue;

        //if no coverage result for the issue we display a warning
        if(!coverageResult) {
            $(testResultClass).empty();
            $(testResultClass).append(`<p><strong>No coverage result found for the issue ${numberOfIssue}</strong></p>`);
            return;
        }
        
        $(testResultClass).empty();
        displayCoverageResult(testResultClass, coverageResult, getCoverageComments("User story") );
    });

});


function isCoverageInMetricInterval(coverageScore, metric) {
    return coverageScore >= Number(metric.coverage.min) && coverageScore <= Number(metric.coverage.max);
}

$('button#buttonRunAllTest').click(function(event) {
    fetch("http://localhost:3000/coverage/issue/all", {cache: "no-store"})
    .then(response => response.json())
    .then(allCoverageResult => {
        coverageResult = allCoverageResult.globalCoverage;
        console.log('coverageResult ',coverageResult);
        $(".globalTestResult").empty();
        displayCoverageResult(".globalTestResult", coverageResult, getCoverageComments("global") );
    });
});

//retrieve all metrics when window is loaded
fetch("http://localhost:3000/metrics/all", {cache: "no-store"})
.then(response => response.json())
.then(json => {
    console.log(json);
    var configs = json;
    
    globalMetrics = configs['Global'];
    userStoriesMetrics = configs['User story']; 
});