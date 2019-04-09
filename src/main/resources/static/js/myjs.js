function loadlink(){
    $('#req').load(function () {
        $(this).unwrap();
    });
}

loadlink(); // This will run on page load
setInterval(function(){
    loadlink();// this will run after every 5 seconds
   // window.alert("hello mohammed");
}, 10000);


function display_live(){
    var x = document.getElementById("req");
    var y = document.getElementById("features");

    x.style.display = "block";
    y.style.display = "block";


}

function display_issues(){
    var x = document.getElementById("req");
    var y = document.getElementById("features");

    x.style.display = "none";
    y.style.display = "none";
}


function display_flow(){
    var x = document.getElementById("progress");
    var y = document.getElementById("badges");

    x.style.display = "block";
    y.style.display = "none";

}

function display_badges(){
    var x = document.getElementById("progress");
    var y = document.getElementById("badges");

    x.style.display = "none";
    y.style.display = "block";
}

function disy(){
    var x = document.getElementById("features");
    if (x.style.display === "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
}

$(function () {
    getMorris('line', 'line_chart');
    getMorris('bar', 'bar_chart');
    getMorris('area', 'area_chart');
    getMorris('donut', 'donut_chart');
});
s