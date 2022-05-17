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
    $(testResultClass).append(`
        <ul>
            <li> ${getNewProgressBar("Line-based", coverageResult.gumtree.lineCoverage)} 
                comment : ${commentsToDisplay.gumtree.line}
            </li>
            <br/>
            <li> ${getNewProgressBar("Method-based", coverageResult.gumtree.methodCoverage)} 
                comment : ${commentsToDisplay.gumtree.method}
            </li>
        </ul>
    `);
    $(testResultClass).append("<h3>Git blame</h3>");
    $(testResultClass).append(`
        <ul>
            <li> ${getNewProgressBar("Line-based", coverageResult.gitblame.lineCoverage)} 
                comment : ${commentsToDisplay.gitblame.line}
            </li>
            <br/>
            <li> ${getNewProgressBar("Method-based", coverageResult.gitblame.methodCoverage)} 
                comment : ${commentsToDisplay.gitblame.method}
            </li>
        </ul>
    `);

    //display delta rate if defined
    if(coverageResult.deltaCoverage.gumtree && coverageResult.deltaCoverage.gitblame) {
        $(testResultClass).append(`<h3>Delta rates</h3>`);
        $(testResultClass).append(`
            <ul>
                <li>Gumtree line-based approach : ${coverageResult.deltaCoverage.gumtree.lineCoverage}</li>
                <li>Gumtree method-based approach : ${coverageResult.deltaCoverage.gumtree.methodCoverage}</li>
                <li>Git blame line-based approach : ${coverageResult.deltaCoverage.gitblame.lineCoverage}</li>
                <li>Git blame method-based approach : ${coverageResult.deltaCoverage.gitblame.methodCoverage}</li>
            </ul>
        `);
    }
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
        coverageResult['deltaCoverage'] = allCoverageResult.deltaCoverage;
        $(".globalTestResult").empty();
        displayCoverageResult(".globalTestResult", coverageResult, getCoverageComments("global") );
    });
});

//retrieve all metrics when window is loaded
fetch("http://localhost:3000/metrics/all", {cache: "no-store"})
.then(response => response.json())
.then(json => {
    let configs = json;
    
    globalMetrics = configs['Global'];
    userStoriesMetrics = configs['User story']; 
});