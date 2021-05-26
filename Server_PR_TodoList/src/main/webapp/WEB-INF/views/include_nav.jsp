<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style>
	* {
		margin: 0;
		padding: 0;
		box-sizing: border-box;
	}
	
	
	div#date{
		background-color: rgba(153, 131, 250, 20);
		text-align: center;
	}
	
	
    h1.clock {
    	display: inline-block;
    	
        color: black;
        text-align: center;
        padding: 1rem;
		
    }
    
    h1.date {
    	display: inline-block;
    	
     	color: black;
        text-align: center;
		padding: 1rem;
    }

</style>
<h1>TO DO List</h1>
<div id="date">
	<h1 class="date"></h1>
	<h1 class="clock"></h1>
</div>
<script>
	function checkTime(i){
		if(i< 10){
			i = "0" + i;
		}
		return i;
	}

	let date = document.querySelector(".date");
	
    function getDate(){
        const time = new Date();
        let year = time.getUTCFullYear();
        let month = time.getUTCMonth() + 1;
        let day = time.getUTCDate();
        
        
        year = checkTime(year);
        month = checkTime(month);
        today = checkTime(day);
        
        date.textContent = year + "-" + month + "-" + day;
    }



	let clock = document.querySelector(".clock");
	
	
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
	  setInterval(getDate, 1000);
	}
	
	init();
</script>


