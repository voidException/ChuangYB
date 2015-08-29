<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
    String contextPath = request.getContextPath();
%>
<!DOCTYPE HTML>
<html ng-app='bookLibraryApp'>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=contextPath%>/resources/js/jquery/1.11.0/jquery-1.8.0.js"></script>
<script type="text/javascript" src="<%=contextPath%>/resources/jquery/angular.js" ></script>
<script src="<%=contextPath %>/resources/jsMe/angulartest.js" type="text/javascript"></script>

</head>
<body>	
	<div class="container" ng-controller="BookLibraryController">
        <h2>Create a Book here</h2>  
        <button ng-click="addBook()">Insert this book</button>   
    </div>
	
	
</body> 
</html>