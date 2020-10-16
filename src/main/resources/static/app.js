var stompClient=null;


function setConnected(connected) {
  $("#connect").prop("disabled", connected);
  $("#disconnect").prop("disabled", !connected);
  if (connected) {
      $("#conversation").show();
  }
  else {
      $("#conversation").hide();
  }
  $("#messages").html("");
}

function connect(){

  var socket =  new SockJS('/javaMongUs');
  stompClient = Stomp.over(socket);
  stompClient.connect({}, function(frame){
     setConnected(true);
    console.log("connected " + frame);
    stompClient.subscribe('/game/messages', function(message){
    showMessage(JSON.parse(message.body).content);
    });//TODO:Stretch: Make messages dynamic

  })
};

function disconnect(){
  if(stompClient !== null){
    stompClient.disconnect();
  }
  setConnected(false);
  console.log("Disconnected");
}

function sendMessage(){
  stompClient.send("/app/userTexts", {}, JSON.stringify({'message':$("#hiddenVal").val() + ": " + $("#text").val()}))
}

function showMessage(message) {
    $("#messages").append("<tr><td>" + message + "</td></tr>");
}

$(function () {
  $("form").on('submit', function (e) {
      e.preventDefault();
  });
  $( "#connect" ).click(function() { connect(); });
  $( "#disconnect" ).click(function() { disconnect(); });
  $( "#send" ).click(function() { sendMessage(); });
});


