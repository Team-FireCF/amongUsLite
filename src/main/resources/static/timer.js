// Timer function
// Found cool timer tutorial on stackoverflow
// https://stackoverflow.com/questions/31106189/create-a-simple-10-second-countdown

let timeSpan = 15 // This signifies 15 seconds

let timer = setInterval(function() {
    if(timeSpan <= 0) {
        clearInterval(timer);
        document.getElementById("timer").innerHTML = "Finished";

        document.getElementById("placesToGoJs").submit();
        document.getElementById("killingMFers").submit();

    } else {
        document.getElementById("timer").innerHTML = timeSpan + " s";
    }
    timeSpan -= 1;
}, 1000);