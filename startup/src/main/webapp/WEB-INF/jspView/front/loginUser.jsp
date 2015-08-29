
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
<title>小谷登录啦</title>
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
	    <div class="col-md-6" style="margin-top:10%;border:2px solid #000;height:300px;">
	    
				  <div class="form-group">
				    <label for="InputEmail1">邮箱</label>
				    <input type="email" class="form-control" id="email" placeholder="Email">
				  </div>
				  <div class="form-group">
				    <label for="InputPassword1">密码</label>
				    <input type="password" class="form-control" id="password" placeholder="Password">
				  </div>
				  <div class="checkbox">
				    <label>
				      <input type="checkbox"> 记住密码
				    </label>
				    <label>
				      <a href="http://localhost:8080/startup/more/findPassword">忘记密码？</a>
				    </label>
				  </div>
				  <button id="btnlogin"style="width:200px;margin-left:150px;margin-top:30px;">登录</button>
						    
	    </div>
	    <div class="col-md-3" style="height:100%"></div>
  </div>
  <script type="text/javascript">
  $(function(){	
		//为登录按钮绑定登录事件
		$("#btnlogin").click(function(){
			 //获取学生的email和passord
			var email=$("#email").val();
			var password=$("#password").val();
			var dj={
					  "studentEmail":email,
			          "studentPassword":password
			};
		
			
			var djString = JSON.stringify(dj);
			var ajx=$.ajax({
				url:'http://localhost:8080/startup/student/login',  // 请求的Restful地址    
	 		    data:djString,    
	 		    type:'POST',    
	 		    cache:false,    
	 		    dataType:'json',
	 		    contentType:'application/json',
	 		  
	 		    success:function(data) {    
	 		        console.log(data.student.stuid);
	 		        if(data.student.passwords==password){
	 		        	sessionStorage.setItem('studentEmail',data.student.email);
	 		        	sessionStorage.setItem('studentPassword',data.student.passwords);
	 		        	sessionStorage.setItem('stuid',data.student.stuid);
	 		        	console.log(sessionStorage.getItem('stuid'));
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