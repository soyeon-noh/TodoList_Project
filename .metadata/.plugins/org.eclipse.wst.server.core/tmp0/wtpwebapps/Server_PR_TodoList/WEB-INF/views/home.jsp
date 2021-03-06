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
<title>TODOList 메인화면</title>
<link href="${rootPath}/static/css/home.css?ver4" rel="stylesheet"/>

<style>

</style>


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
    		<label for="todo">할 일</label>
    		<input name="td_todo"
    				type="text" value="${TD.td_todo}">
    	</div>
    	
    	<div>
    		<label for="place">장소</label>
    		<input name="td_place"
    				type="text" value="${TD.td_place}">
    	</div>
    	<div>
   			<button class="btn_insert" type="button">추가</button>
		</div>
    </form>
    
    <form class="select" method="GET">
    	<input name="select_date" type="date">
    	<button class="btn_select" type="button">
    		검색
    	</button>
    </form>
    
    <table id="tdlist">
      <tr>
        <th>No.</th>
        <th>할 일</th>
        <th>작성일자</th>
        <th>장소</th>
        <th></th>
      </tr>
      <c:forEach items="${TDLIST}" var="TD" varStatus="i">
        <tr>
          <td>${i.count}</td>
          <td>${TD.td_todo}</td>
          <td>${TD.td_date}</td>
          <td>${TD.td_place}</td>
          <td><button class="btn_update" data-seq="${TD.td_seq}" type="button">
          		수정</button>
          		<button class="btn_delete" data-seq="${TD.td_seq}" type="button">
          		삭제</button></td>
        </tr>
      </c:forEach>
    </table>
  </body>
  
  <script>
  // html 코드가 다 화면에 뜨고 나서 실행하라는 명렁
  // 아래 한 줄의 코드가 있어야 어디든디 script를 넣을 수 있다.
	document.addEventListener("DOMContentLoaded",function(){
		
		document.querySelector("form.v1")
		.addEventListener("click", function(ev){
			let className = ev.target.className
			
			if(className == "btn_insert"){
				let td_todo = document.querySelector("input[name='td_todo']");
				if(td_todo.value == ""){
					alert("할 일은 반드시 입력해야합니다");
					td_todo.focus();
					return false;
				}
				
				document.querySelector("form.v1").submit();
			}
		})
		
		document.querySelector("form.select")
		.addEventListener("click", function(ev){
			let className = ev.target.className
			
			
			if(className == "btn_select"){
				let date = document.querySelector("input[name='select_date']")
				.value;
				
				if(date == ""){
					document
					.location
					.href= "${rootPath}";
					
					return false;
				}

				document
				.location
				.href= "${rootPath}" 
						+ "/UD/select?td_date="
						+ date;
			}
			
		})
		
		document.querySelector("table#tdlist")
		.addEventListener("click", function(ev){
			let className = ev.target.className
			

				
			if(className == "btn_delete"){

				let seq = ev.target.dataset.seq
				alert("삭제가 완료되었습니다." + seq );
					
				document
				.location
				.replace( "${rootPath}" 
						+ "/UD/delete?td_seq="
						+ seq )
			
			} else if(className == "btn_update"){
				
				let seq = ev.target.dataset.seq;
				
				document
				.location
				.href= "${rootPath}" +
						"/UD/update?td_seq="
						+ seq
			}
			
		})
	})
  </script>

</html>