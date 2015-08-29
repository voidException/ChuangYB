$(function(){
//这个是用来实现点赞的
    	$("#ok").click(function(){
    		    var dt={
    		    		 "token":"992500110@qq.com",
    		    		 "iD":5,
    		    		 "articleiD":3

    		    		};
    		    
    		    var jsonobj = JSON.stringify(dt);
   		    
	    		var ajx = $.ajax({    
		    		    url:'http://localhost:8080/startup/learn/article/addLove',  // 请求的Restful地址    
		    		    data:jsonobj,    
		    		    type:'POST',    
		    		    cache:false,    
		    		    dataType:'json',
		    		    contentType:'application/json',
		    		  
		    		    success:function(data) {    
		    		        console.log(data);
		    		     }    
	    		  });//ajax  
	    		});//click
 
//这个是用来实现提交评论的。
    	$("#subbtn").click(function(){
    				var textContent=$("#textarea").val();//获取文本输入框的值
    		        var articleid=$("#title").val();
    		        var userid=sessionStorage.getItem("stuid");
    		        //var username=sessionStorage.getItem("userName");//登陆的时候还没存储
    		       // var timecurrent="2006-01-02";
    		        var dtcomment={
    		                 "articleId":3,
    		                 "userId":461,
    		                 "commentTime":"2006-01-02",
    		                 "userName":"zachary",
    		                 "content":textContent
    		        };
    		        var dtcomStr=JSON.stringify(dtcomment);
    		        var comajax=$.ajax({
    		        	url:'http://localhost:8080/startup/learn/article/comment',  // 请求的Restful地址    
		    		    data:dtcomStr,    
		    		    type:'POST',    
		    		    cache:false,    
		    		    dataType:'json',
		    		    contentType:'application/json',
		    		  
		    		    success:function(data) {    
		    		        console.log(data);
		    		     }    
    		        });
    		        
    			});//click
  	
     }); //jquery.ready()

















