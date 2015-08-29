
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

</head>
<body>

<div class="container">
  <div class="row">
	    <div class="col-xs-12" style="" >
	       <img src="<%=path %>/resources/more/advise.png" style="width:70px;height:70px;margin-left:40%;margin-top:35px;"/>
	    </div>
  </div>
  <div class="row">
	    <div class="col-xs-12" style="font-size:16px;margin-top:35px;" >
		     <p style="color:#919191;font-family:SimHei;margin-left:4%;">如果您有好的建议，欢迎提供给创业吧，您可以通过以下方式联系我们:</p>	 
	    </div>
  </div>
  <div class="row">
	     <div class="col-xs-3" style="margin-top:3px;">
	       <img src="<%=path %>/resources/more/adviseCircle.png" style="width:30px;height:30px;margin-left:22%;margin-top:5px;"/>
	     </div>
	     <div class="col-xs-9" style="margin-top:8px;margin-left:-30px;color:#919191;font-family:SimHei;font-size:16px">
	          QQ群：459080766
	     </div>	     
  </div> 
  <div class="row" style="margin-top:10px;">
	     <div class="col-xs-3" style="">
	       <img src="<%=path %>/resources/more/advisePhone.png" style="width:30px;height:30px;margin-left:22%;margin-top:5px;"/>
	     </div>
	     <div class="col-xs-9" style="margin-top:8px;margin-left:-30px;color:#919191;font-family:SimHei;font-size:16px">
	                           电话：010-58404132
	     </div>	     
  </div> 
  <div class="row" style="margin-top:10px;">
	     <div class="col-xs-3" style="">
	       <img src="<%=path %>/resources/more/adviseMail.png" style="width:30px;height:30px;margin-left:22%;margin-top:5px;"/>
	     </div>
	     <div class="col-xs-9" style="margin-top:8px;margin-left:-30px;color:#919191;font-family:SimHei;font-size:16px">
	                        邮箱：qhzyedu@126.com
	     </div>	     
  </div> 
	        
  
  
  
  
	    
</div>

</body>
</html>