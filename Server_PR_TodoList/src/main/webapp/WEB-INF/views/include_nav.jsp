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
		
	}



	let clock = document.querySelector(".clock");
	
	function getTime() {
	  const time = new Date();
	  const hour = time.getHours();
	  const minutes = time.getMinutes();
	  const seconds = time.getSeconds();
	  clock.textContent = hour + ":" + minutes + ":" + seconds;
	

	}
	
	function init() {
	  setInterval(getTime, 1000);
	}
	
	init();
</script>


