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
<title>Insert title here</title>
<link href="${rootPath}/static/css/home.css?ver1" rel="stylesheet"/>

<style>


</style>

<script>

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
   		<button class="btn_insert">추가</button>
    </form>
    
    <table id="tdlist">
      <tr>
        <th>No.</th>
        <th>할일</th>
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
          <th><button class="btn_delete">삭제</button></th>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>