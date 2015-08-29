
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
  System.out.println(path);
  System.out.println(basePath);
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<title>My JSP 'index.jsp' starting page</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="<%=path %>/resources/bootstrap/css/bootstrap.css">
<script	src="<%=path %>/resources/jquery/jquery-1.11.1.js" type="text/javascript"></script>
<script src="<%=path %>/resources/bootstrap/js/bootstrap.js" type="text/javascript"></script>
<script src="<%=path %>/resources/angular/angular.js" type="text/javascript"></script>
<script src="<%=path %>/resources/angular/angular-resource.js" type="text/javascript"></script>
</head>
<body>

<div class="container">
  <div class="row">
	    <div class="col-xs-12">
	       
	    </div>
  </div>
  <div>
     <a ></a>
  </div>
  
  
    	        
</div>
</body>
</html>