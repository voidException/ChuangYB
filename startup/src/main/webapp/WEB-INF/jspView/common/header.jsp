
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="<%=path %>/resources/bootstrap/css/bootstrap.css">
<script	src="<%=path %>/resources/jquery/jquery-1.11.1.js" type="text/javascript"></script>
<script src="<%=path %>/resources/bootstrap/js/bootstrap.js" type="text/javascript"></script>
<script src="<%=path %>/resources/bootstrap/js/angular.js" type="text/javascript"></script>
</head>
<body>

</body>
</html>