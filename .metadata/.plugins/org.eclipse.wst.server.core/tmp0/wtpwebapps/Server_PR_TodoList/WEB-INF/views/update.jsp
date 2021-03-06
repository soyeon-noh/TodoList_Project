<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
			prefix="c"%>
<c:set value="${pageContext.request.contextPath}" 
		var="rootPath"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TODOList 수정하기</title>
<link href="${rootPath}/static/css/home.css?ver5" rel="stylesheet"/>

<script>
	document.addEventListener("DOMContentLoaded", function(){
		document.querySelector("div#btn_update")
		.addEventListener("click", function(ev){
			let className = ev.target.className
			
			if(className == "btn_insert"){
				
				let seq = ev.target.dataset.seq;
				
				document.querySelector("form.v1").submit();
				
			} else if(className == "btn_back"){
				
				document
				.location
				.href = "${rootPath}" ;
			}
			
			
		})
	})
</script>
</head>
<body>
	<%@ include file="/WEB-INF/views/include_nav.jsp" %>
	
	<form class ="v1" method="POST">
    	<div>
    		<label for="date">작성일자</label>
    		<input name="td_date"
    				type="date" value="${TD.td_date}">
    	</div>
    	
    	<div>
    		<label for="time">작성시각</label>
    		<input name="td_time"  
    				type="time" value="${TD.td_time}">
    	</div>
    	
    	<div>
    		<label for="todo">할일</label>
    		<input name="td_todo"
    				type="text" value="${TD.td_todo}">
    	</div>
    	
    	<div>
    		<label for="place">장소</label>
    		<input name="td_place"
    				type="text" value="${TD.td_place}">
    	</div>
    	
    	<div id="btn_update">
   		<button class="btn_back" data-seq="${TD.td_seq}" type="button">뒤로가기</button> 
   		<button class="btn_insert" data-seq="${TD.td_seq}" type="button">수정완료</button>
   		</div>
    </form>
	
	
</body>
</html>