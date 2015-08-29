<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
  System.out.println(path);
  System.out.println(basePath);
%>
<!DOCTYPE html>
<!-- <html ng-app="listcomment"lang="zh-CN"> -->
<html xmlns:ng="http://angularjs.org" id="ng-app" class="login-alone" ng-app="listcomment" ng-controller="ListCommentController">
<head>
	<base href="<%=basePath%>">
	<title id="title">${article.title}</title>
	<meta charset="utf-8">
	<!-- <meta http-equiv="X-UA-Compatible" content="IE=edge"> -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/bootstrap/css/bootstrap.css">
	<script	src="<%=path %>/resources/jquery/jquery-1.11.1.js" type="text/javascript"></script>
	<script src="<%=path %>/resources/bootstrap/js/bootstrap.js" type="text/javascript"></script>
	<script src="<%=path%>/resources/jquery/angular.js"  type="text/javascript"></script>
	<script src="<%=path %>/resources/jsMe/article.js" type="text/javascript"></script>
	<script src="<%=path %>/resources/jsMe/article_angular.js" type="text/javascript"></script>
</head>

<body ng-controller="ListCommentController">
<nav class="navbar navbar-default" role="navigation" style="border-bottom-color: #FF2525;border-top-color: #B9EB6E;" >
  <div class="container" >

    <div class="navbar-header" style="font-weight:bolder;margin-top:-14px;">
      <a class="navbar-brand" href="#"><img src="<%=path %>/resources/image/xiaogu.png" style="height: 40px;width: 40px;padding-top: 5px;"></a>
    </div>
    <div class="navbar-header" style="font-weight:bolder;margin-left: 10px;">
      <a class="navbar-brand" href="#"><span class="glyphicon glyphicon-home"></span>小谷</a>
    </div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav" style="font-weight:bolder; font-size: 18px;">
        <li class="active"  style="margin-left:10px;"><a href="#"><span class="glyphicon glyphicon-leaf"></span>慕课</a></li>

        <li class="dropdown" style="margin-left:10px;">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-volume-up"></span>问答</a>
        </li>
      </ul>
      <form class="navbar-form navbar-left" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="检索你感兴趣的内容" style="width:200px;">
          <div class="btn-group">
          </div>
        </div>
        <button type="submit" class="btn btn-default">检索</button>
      </form>
      <ul class="nav navbar-nav " style="font-weight: bolder;margin-left: 10px;">
        <li style="margin-left:10px;"><a href="#"><span class="glyphicon glyphicon-camera"></span>职业测评</a></li>

        <li class="dropdown" style="margin-left: 10px;">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-bell"></span>关于我们</a>
        </li>
        <li class="dropdown" style="margin-left:10px;">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-eye-open"></span>注册</a>
        </li>

        <li class="dropdown" style="margin-left: 20px;">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span>登录</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
<div class="container">
   <div class="row">
        <div class="col-md-2" style="background-color: #CCD3E5;height: 1800px;"></div><!-- 左侧的空白 -->
        <div class="col-md-7">
          
	        <div class="col-md-12" style="text-align: center;margin:0 auto;font-size:16px;margin-bottom:10px;">${article.title}</div>
	        <div class="col-md-12" style="text-align: center;margin:0 auto">${article.content}</div>                
		    <div class="col-md-12" style="margin-bottom:5px;"> 
		        	<img src="${article.miniphotourl}"></img>
		    </div>
         
           <hr style="filter: alpha(opacity=100,finishopacity=0,style=3) width:100% color:#987cb9 size:3/">        
           <div class="row " style="height:35px;"><!--分享到微信、微博  需要水平排列的就class=row-->
           		<div class="col-md-2" style="margin-left:5px;margin-top:-5px;">分享到：</div>
           		<div class="col-md-2"><img src="<%=path %>/resources/image/share01.png" style="height:35px;margin-top:-15px;"></div>
           		<div class="col-md-2"><img src="<%=path %>/resources/image/share02.png" style="height:35px;margin-top:-15px;"></div>
           		<div class="col-md-2"><img src="<%=path %>/resources/image/share03.png" style="height:35px;margin-top:-15px;"></div>
           </div>
           
           
           <div class="row">             
               <div class="col-md-2" id="com" style="margin-left:5px;">评论(${article.comments })</div>
               <div class="col-md-2" id="ok" >赞(${article.love})</div>                 
                <div class="col-md-6">时间：${article.publishtime}</div>
           </div>
          <!--  评论输入框-->
            <p style="margin-left:69%;margin-top:5px;margin-bottom:0px;">最多可以输入140字</p>    
          	<textarea id="textarea" rows="4" cols="80" placeholder="输入你的评论吧"></textarea>
            <input class="btn" id="subbtn" style="margin-left: 82%" type="submit" value="提交">         
          
            <!-- 评论列表 -->
            <div ng-controller="ListCommentController" style="margin-top:5px;">  
       			<!-- 这个div 仅仅是用来迫使后台加载页面就获取数据的 -->
		        <div data-ng-init="listcomm(${article.articleid})" ></div>               
                <div ng-repeat="item in items" style="border-top:solid 1px #d9d9d9">
            	   <img src="{{item.userPhotoPath}}" style="height:40px;width:40px;"></img>
            	   <span style="margin-left:10px"><a href="">{{item.comments.username}}:</a></span>
            	   <span>{{item.comments.content}}</span>
            	   <br/>
            	   <span style="margin-left:50px;margin-bottom:5px">{{item.timeString}}</span>            	    
            	</div>
            	<!--  这里应该写入“更多评论”的东西，基于双向数据绑定，只要我点击的时候改变more的值，这里应该就会显示，more初始为0-->
                <div ng-repeat="mr in more">
                    <img src="{{mr.userPhotoPath}}" style="height:40px;width:40px;"></img>
            	   <span style="margin-left:10px"><a href="">{{mr.comments.username}}:</a></span>
            	   <span>{{mr.comments.content}}</span>
            	   <br/>
            	   <span style="margin-left:50px;margin-bottom:5px">{{mr.timeString}}</span> 
                </div>
                <!-- 点击加载更多结束 -->
                   <div class="col-md-12 col-md-offset-5" style="margin-top:5px;margin-bottom:20px;">
                          <div  ng-click="loadmoreclick()"> 更多评论</div> 
                   </div>
            </div>
            
           
           
             
                   
          
        </div><!--col-md-7中间展示文章的地方  -->
        <div class="col-md-3" style="background-color: #CCD3E5;height:1800px;"></div><!-- 右侧的空白 -->
    </div>
</div><!-- container -->

<script type="text/javascript">
   
    
</script>

</body>
</html>