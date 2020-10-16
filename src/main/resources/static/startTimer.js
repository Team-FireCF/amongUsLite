let timeSpan = document.getElementById("hiddenVal").attributes[0].value;
let timeLeft = 60 - timeSpan
console.log(timeSpan);

let timer = setInterval(function() {
    if(timeLeft <= 0) {
        clearInterval(timer);
        document.getElementById("timer").innerHTML = "Finished";

        document.getElementById("startButton").click();

    } else {
        document.getElementById("timer").innerHTML = "The Game will start in " + timeLeft + " seconds!";
    }
    timeLeft -= 1;
}, 1000);