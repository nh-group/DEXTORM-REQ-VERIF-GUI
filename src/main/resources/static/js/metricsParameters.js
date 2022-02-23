

function addRow(config) {
    $("tbody").append(`<tr class="rows">
        <td>
            <input class="tabledit-input form-control input-sm" 
                    type="text" 
                    name="comment" 
                    value="`+config.comment+`" 
            >
        </td>
        <td>
            <select class="form-control" name="type" value="`+config.type+`">
                <option `+((config.type === "Indivual method") ? "selected" : "")+`>Indivual method</option>
                <option `+((config.type === "Global test plan") ? "selected" : "")+`>Global test plan</option>
            </select>
        </td>
        <td>
            <input class="tabledit-input form-control input-sm fill" 
                    type="number" name="coverage-min" 
                    value="`+config.coverage.min+`" 
            >
        </td>
        <td>
            <input class="tabledit-input form-control input-sm fill" 
                    type="number" name="coverage-max" 
                    value="`+config.coverage.max+`" 
            >
        </td>
        <td>
            <button type="button" class="deleteRow btn btn-danger">
                <i class="fa fa-trash"></i> Delete metric
            </button>
        </td>
    </tr>`);
}


fetch("/metricsConfig.json")
    .then(response => response.json())
    .then(json => {
        console.log(json);
        var configs = json;
        configs.forEach(function(config, index) {
            addRow(config);
        })    
    });

$('button#addRow').click(function() {
    addRow({comment:"", type:"Indivual method", coverage: 0});
});

$(document).on('click', '.deleteRow', function (event) {
    console.log(event.target);
    $(event.target ).parent().parent().remove();
});

$('#saveMetrics').click(function(){
    configs = [];
    $('.rows').each(function( index ) {
        let rowConfig = {};
        rowConfig['comment'] = $(this).find('input[name="comment"]')[0].value;
        rowConfig['type'] = $(this).find('select[name="type"]')[0].value;
        rowConfig['coverage'] = {};
        rowConfig['coverage']['min'] = $(this).find('input[name="coverage-min"]')[0].value;
        rowConfig['coverage']['max'] = $(this).find('input[name="coverage-max"]')[0].value;

        configs.push(rowConfig);
    });

    fetch("/save-metrics",
    {
        method: "POST",
        body: JSON.stringify(configs)
    })
    .then(function(res){  })
});