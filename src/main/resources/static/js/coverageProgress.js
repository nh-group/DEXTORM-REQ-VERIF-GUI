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
    coverageResult  = {	
        coverage : 70,
        declineRate : 0,
        weakSpots : {
            method1 : 30,
            method3: 20
        }
    };
    let numberOfIssue = $(event.target).attr('id');
    const testResultClass = ".testResult-"+numberOfIssue;
    $(testResultClass).empty();

    //coverage of test case
    $(testResultClass).append(getNewProgressBar("Use case coverage", coverageResult.coverage) );
    //declining rate of test case
    $(testResultClass).append(getNewProgressBar("Decline rate", coverageResult.declineRate) );
    //weak spots
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


function isCoverageInMetricInterval(coverageScore, metric) {
    return coverageScore >= Number(metric.coverage.min) && coverageScore <= Number(metric.coverage.max);
}

$('button#buttonRunAllTest').click(function(event) {
    coverageResult  = {
        global : {
            coverage : 65  
        },      
        issues : [
            {
            coverage : 70,
            declineRate : 0
            },
            {
            coverage : 60,
            declineRate : 0
            }
        ]
    }

    $(".globalTestResult").empty();
    $(".globalTestResult").append(getNewProgressBar("Global coverage", coverageResult.global.coverage) );

    var globalCoverage = Number(coverageResult.global.coverage);
    var commentToDisplay = "none";
    globalMetrics.forEach(function(globalMetric) {
        if(isCoverageInMetricInterval(globalCoverage, globalMetric) )
            commentToDisplay = globalMetric.comment;
    });

    $(".globalTestResult").append(`<p><strong>Comment :</strong> ${commentToDisplay}</p>`);
});

fetch("/metricsConfig.json", {cache: "no-store"})
.then(response => response.json())
.then(json => {
    console.log(json);
    var configs = json;
    
    configs.forEach(function(config, index) {
        if(config.type === 'Global') {
            globalMetrics.push(config);
        } else if(config.type === 'Use case') {
            useCaseMetrics.push(config);
        }
    })    
});