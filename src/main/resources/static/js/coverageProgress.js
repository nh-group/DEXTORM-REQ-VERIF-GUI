var globalMetrics = [];
var useCaseMetrics = [];

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
        //display coverage results
        $(testResultClass).append(getNewProgressBar("Use case coverage", coverageResult.coverage) );
        $(testResultClass).append(getNewProgressBar("Decline rate", coverageResult.declineRate) );
        $(testResultClass).append("<p><strong>Weak spots</strong></p>")
        for (const [key, value] of Object.entries(coverageResult.weakSpots)) {
            $(testResultClass).append(getNewProgressBar(key, value) );
        }

        var useCaseCoverage = Number(coverageResult.coverage);
        var commentToDisplay = "none";
        useCaseMetrics.forEach(function(useCaseMetric) {
            if(isCoverageInMetricInterval(useCaseCoverage, useCaseMetric) )
                commentToDisplay = useCaseMetric.comment;
        });

        $(testResultClass).append(`<p><strong>Comment :</strong> ${commentToDisplay}</p>`);
    });

});


function isCoverageInMetricInterval(coverageScore, metric) {
    return coverageScore >= Number(metric.coverage.min) && coverageScore <= Number(metric.coverage.max);
}

$('button#buttonRunAllTest').click(function(event) {
    fetch("http://localhost:3000/coverage/issue/all", {cache: "no-store"})
    .then(response => response.json())
    .then(coverageResult => {
        console.log('coverageResult ',coverageResult);
        $(".globalTestResult").empty();
        $(".globalTestResult").append(getNewProgressBar("Global coverage", coverageResult.globalCoverage) );

        var globalCoverage = Number(coverageResult.globalCoverage);
        var commentToDisplay = "none";
        globalMetrics.forEach(function(globalMetric) {
            if(isCoverageInMetricInterval(globalCoverage, globalMetric) )
                commentToDisplay = globalMetric.comment;
        });

        $(".globalTestResult").append(`<p><strong>Comment :</strong> ${commentToDisplay}</p>`);
    });
});

//retrieve all metrics when window is loaded
fetch("http://localhost:3000/metrics/all", {cache: "no-store"})
.then(response => response.json())
.then(json => {
    console.log(json);
    var configs = json;
    
    globalMetrics = configs['Global'];
    useCaseMetrics = configs['Use case']; 
});