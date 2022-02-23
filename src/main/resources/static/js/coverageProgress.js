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
        decliningRate : 0,
        weakSpots : {
            method1 : 30,
            method3: 20
        }
    };
    let numberOfIssue = $(event.target).attr('id');
    $(".testResult-"+numberOfIssue).empty();

    //coverage of test case
    $(".testResult-"+numberOfIssue).append(getNewProgressBar("Use case coverage", coverageResult.coverage) );
    //declining rate of test case
    $(".testResult-"+numberOfIssue).append(getNewProgressBar("Decline rate", coverageResult.decliningRate) );
    //weak spots
    $(".testResult-"+numberOfIssue).append("<p><strong>Weak spots</strong></p>")
    for (const [key, value] of Object.entries(coverageResult.weakSpots)) {
        $(".testResult-"+numberOfIssue).append(getNewProgressBar(key, value) );
    }

});


$('button#buttonRunAllTest').click(function(event) {
    coverageResult  = {
        global : {
            coverage : 65  
        },      
        issues : [
            {
            coverage : 70,
            decliningRate : 0
            },
            {
            coverage : 60,
            decliningRate : 0
            }
        ]
    }

    $(".globalTestResult").empty();
    $(".globalTestResult").append(getNewProgressBar("Global coverage", coverageResult.global.coverage) );
});