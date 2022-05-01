

function addRow(config) {
    $("tbody").append(`<tr class="rows">
        <td>
            <input class="tabledit-input form-control input-sm" 
                    type="text" 
                    name="comment" 
                    value="${config.comment}" 
            >
        </td>
        <td>
            <select class="form-control" name="type" value="${config.type}">
                <option ${((config.type === "User story") ? "selected" : "")}>User story</option>
                <option ${((config.type === "Global") ? "selected" : "")}>Global</option>
            </select>
        </td>
        <td>
            <input class="tabledit-input form-control input-sm fill" 
                    type="number" name="coverage-min" 
                    value="${config.coverage.min}" 
            >
        </td>
        <td>
            <input class="tabledit-input form-control input-sm fill" 
                    type="number" name="coverage-max" 
                    value="${config.coverage.max}" 
            >
        </td>
        <td>
            <button type="button" class="deleteRow btn btn-danger">
                <i class="fa fa-trash"></i> Delete metric
            </button>
        </td>
    </tr>`);
}


fetch("http://localhost:3000/metrics/all", {cache: "no-store"})
    .then(response => response.json())
    .then(json => {
        console.log(json);
        var configs = json;

        configs["User story"].forEach(function(config, index) {
            addRow(config);
        })   
        
        configs["Global"].forEach(function(config, index) {
            addRow(config);
        })  
    });

$('button#addRow').click(function() {
    addRow({comment:"", type:"User story", coverage: {min: 0, max: 0}});
});

$(document).on('click', '.deleteRow', function (event) {
    console.log(event.target);
    $(event.target ).parent().parent().remove();
});

$('#saveMetrics').click(function(){
    configs = { "Global": [], "User story": [] };
    $('.rows').each(function( index ) {
        let type =  $(this).find('select[name="type"]')[0].value;

        let rowConfig = {};
        rowConfig['comment'] = $(this).find('input[name="comment"]')[0].value;
        rowConfig['type'] = type;
        rowConfig['coverage'] = {};
        rowConfig['coverage']['min'] = $(this).find('input[name="coverage-min"]')[0].value;
        rowConfig['coverage']['max'] = $(this).find('input[name="coverage-max"]')[0].value;


        configs[type].push(rowConfig);
    });

    fetch("http://localhost:3000/metrics/all",
    {
        method: "POST",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(configs)
    })
    .then(function(res){  })
});