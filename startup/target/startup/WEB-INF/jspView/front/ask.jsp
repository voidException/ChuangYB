
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
	       <img src="<%=path %>/resources/more/aboutUs.png" style="width:70px;height:70px;margin-left:40%;margin-top:55px;"/>
	    </div>
  </div>
  <div class="row">
	    <div class="col-xs-12" style="height:40px;font-size:16px;margin-top:35px;border-bottom:1px solid #DFDFDF" >
		     <p style="color:#919191;font-family:SimHei;margin-left:14%;margin-bottom:10px;">90创业吧移动学习平台手机客户端</p>	 
	    </div>
  </div>
  <div class="row">
	     <div class="col-xs-3" style="margin-top:3px;">
	       <img src="<%=path %>/resources/more/dot.png" style="width:5px;height:5px;margin-left:22%;margin-top:10px;"/>
	     </div>
	     <div class="col-xs-9" style="margin-top:8px;margin-left:-63px;color:#919191;font-family:SimHei;font-size:16px">
			          关于我们
	     </div>	     
  </div> 
  <div class="row" style="margin-top:10px;">	    
	     <div class="col-xs-12" style="margin-top:8px;margin-left:auto;margin-right:auto;color:#919191;font-family:SimHei;font-size:16px">
	      <p style="line-height:25px;"> 
	        <span style="padding-left:33px;"></span>“90 创业吧”是几个由北大软件与微电子学院研究生开发的软件，旨在用长图、动画、微视频等形式表达出创业过程中需要了解的事儿。  
	        <br/>        
	        <span style="padding-left:33px;"></span> 我们希望在国家大力、鼓励、支持创业的前提下，这款小小的App能起到“推波助澜”的作用，点燃大学生的创业热情，为实现中国梦加油！
	     </p>      
	     </div>	     
  </div> 
   
	        
</div>

</body>
</html>