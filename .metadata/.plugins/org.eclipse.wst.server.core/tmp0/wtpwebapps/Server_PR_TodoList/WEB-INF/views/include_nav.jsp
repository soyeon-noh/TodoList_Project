<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style>
	* {
		margin: 0;
		padding: 0;
		box-sizing: border-box;
	}
	
    h1.clock {
        color: black;
        text-align: center;
        background-color: rgba(153, 131, 250, 20);
        padding: 2rem;
    }

</style>
<h1>TO DO List</h1>
<h2 class="date"></h2>
<h1 class="clock"></h1>

<script>
	let date = document.querySelector(".date");
	
    function getDate(){
        const time = new Date();
        const year = time.getUTCFullYear();
        const month = time.getUTCMonth();
        const day = time.getUTCDay();
        date.textContent = year + "-" + month + "-" + day;
    }



	let clock = document.querySelector(".clock");
	

	function checkTime(i){
		if(i< 10){
			i = "0" + i;
		}
		return i;
	}
	
	function getTime() {
		
		  const time = new Date();
		  let hour = time.getHours();
		  let minutes = time.getMinutes();
		  let seconds = time.getSeconds();
		  
		  hour = checkTime(hour);
		  minutes = checkTime(minutes);
		  seconds = checkTime(seconds);
		  
		  clock.textContent = hour + ":" + minutes + ":" + seconds;
		
	}
	
	
	
	function init() {
	  setInterval(getTime, 1000);
	}
	
	init();
</script>


