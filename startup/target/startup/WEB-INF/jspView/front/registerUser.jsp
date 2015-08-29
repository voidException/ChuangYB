
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
<title>快快注册小谷</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="<%=path %>/resources/bootstrap/css/bootstrap.css">
<script	src="<%=path %>/resources/jquery/jquery-1.11.1.js" type="text/javascript"></script>
<script src="<%=path %>/resources/bootstrap/js/bootstrap.js" type="text/javascript"></script>
<script src="<%=path %>/resources/angular/angular.js" type="text/javascript"></script>
<script src="<%=path %>/resources/angular/angular-resource.js" type="text/javascript"></script>
<%-- <script src="<%=path %>/resources/jsMe/loginUser.js" type="text/javascript"></script> --%>
</head>
<body>

<div class="container">
  <div class="row">
	    <div class="col-md-3" style="height:100%"></div>
	    <div class="col-md-6" style="margin-top:5%;border:2px solid #000;height:500px;">
	    
				  <div class="form-group">
				    <label for="InputEmail1">姓名</label>
				    <input type="text" class="form-control" id="username" placeholder="请输入姓名">
				  </div>
				  <div class="form-group">
				    <label for="studentno">学号</label>
				    <input type="text" class="form-control" id="stuno" placeholder="输入你的学号">
				  </div>
				  <div class="form-group">
				    <label for="InputEmail1">邮箱</label>
				    <input type="email" class="form-control" id="email" placeholder="Email">
				  </div>
				  <div class="form-group">
				    <label for="InputPassword1">密码</label>
				    <input type="password" class="form-control" id="passwordone" placeholder="请输入密码">
				  </div>
				  <div class="form-group">
				    <label for="InputPassword2">再次输入密码</label>
				    <input type="password" class="form-control" id="passwordtwo" placeholder="请再次输入密码">
				  </div>
				 
				  <button id="btnregister"style="width:200px;margin-left:150px;margin-top:30px;">注册</button>
						    
	    </div>
	    <div class="col-md-3" style="height:100%"></div>
  </div>
  <script type="text/javascript">
  $(function(){	
		//为登录按钮绑定登录事件
		$("#btnregister").click(function(){
			 //获取学生输入的信息
			var username=$("#username").val();
			var stuno=$("#stuno").val();
			var email=$("#email").val();
			var passwordone=$("#passwordone").val();
			var passwordtwo=$("#passwordtwo").val();
			var data={
					"stuName":username,
					"stuNo":stuno,
					"stuPassword":passwordone,
					"stuPasswordRepeat":passwordtwo,
					"stuEmail":email
				};
		
			
			var djString = JSON.stringify(data);
			var ajx=$.ajax({
				url:'http://localhost:8080/startup/student/register',  // 请求的Restful地址    
	 		    data:djString,    
	 		    type:'POST',    
	 		    cache:false,    
	 		    dataType:'json',
	 		    contentType:'application/json',
	 		  
	 		    success:function(data) {    
	 		        console.log(data);
	 		         if(data.error==9){	 		        	
	 		        	 window.location.href="http://localhost:8080/startup/jsp/article/1/1/20";
	 		        } 
	 		     }    
				
			});		
		});
		
	});
  </script>   	        
</div>
</body>
</html>