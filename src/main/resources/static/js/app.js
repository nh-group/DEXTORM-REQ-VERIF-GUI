var stompClient = null;



var socket = new SockJS('/gs-guide-websocket');
stompClient = Stomp.over(socket);
stompClient.connect({}, function (frame) {
    console.log('Connected: ' + frame);
    stompClient.subscribe('/topic/greetings', function (greeting) {
        showGreeting(JSON.parse(greeting.body).content);
    });
});


function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    stompClient.send("/app/hello", {}, JSON.stringify({'name': $("#name").val()}));
}

function showGreeting(message) {
	var card = $("#issue"+message);
	card.attr("hits",parseInt(card.attr("hits"))+1)
    updateFire();
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
});

$("button.remover").click( function(){
	$(this).parent().parent().fadeOut();
	var value = $( "h1" ).progressbar( "option", "value" );
	$( "h1" ).progressbar( "option", "value", parseInt(value)+1 );
});

function updateFire(){
$(".card").each(function (){
	
	if($(this).attr("hits")>5){
		$(this).find(".ignitable").addClass("fire");	
		$(this).find("button.remover").css("display","initial")	
	}
	
});
}

