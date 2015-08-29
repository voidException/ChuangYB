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
	 		            window.location.href="http://localhost:8080/startup/jsp/article/1/1/20";
	 		        }
	 		     }    
				
			});		
		});
		
	});