<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
  System.out.println(path);
  System.out.println(basePath);
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<base href="<%=basePath%>">
	<title>CourseList</title>
	<meta charset="utf-8">
	<!-- <meta http-equiv="X-UA-Compatible" content="IE=edge"> -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=path %>/resources/bootstrap/css/bootstrap.css">
	<script	src="<%=path %>/resources/jquery/jquery-1.11.1.js" type="text/javascript"></script>
	<script src="<%=path %>/resources/bootstrap/js/bootstrap.js" type="text/javascript"></script>
</head>

<body>
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

  <div class="row" style="border-bottom:1px solid #D0D6D9;height: 40px;">
    <div class="col-lg-6" style="font-size:16px;font-weight:700;color: #14191e;">全部课程</div>
    <div class="col-md-1 col-md-offset-4" style="">
      <a href="#"><img src="<%=path %>/resources/image/for_teacher.png"></a>
    </div>
  </div>
  <div class="row" style="border-bottom:1px solid #EDF1F2;height: 50px;line-height: 50px;">
       <div class="col-md-1" style="font-size: 12px;"><a href="#">老师:</a></div>
       <div class="col-md-1" style="font-size: 12px;"><a href="#">全部</a></div>
       <div class="col-md-1" style="font-size: 12px;"><a href="#">王少浪</a></div>
       <div class="col-md-1"style="font-size: 12px;"><a href="#">史敏思</a></div>
       <div class="col-md-1"style="font-size: 12px;"><a href="#">方伟</a></div>
       <div class="col-md-1"style="font-size: 12px;"><a href="#">古典</a></div>
  </div><!-- row -->
  <div class="row" style="border-bottom:1px solid #D0D6D9;height: 100px;">
    <div class="col-md-12" style="height: 8px"></div>
    <div class="col-md-1" ><a href="#">行业:</a></div>
    <div class="col-md-1" ><a href="#">软件开发</a></div>
    <div class="col-md-1" ><a href="#">化工</a></div>
    <div class="col-md-1" ><a href="#">食品加工</a></div>
    <div class="col-md-1" ><a href="#">林业科学</a></div>
    <div class="col-md-1" ><a href="#">会计</a></div>
    <div class="col-md-1" ><a href="#">金融</a></div>
    <div class="col-md-1" ><a href="#">银行</a></div>
    <div class="col-md-1" ><a href="#">服装设计</a></div>
    <div class="col-md-1" ><a href="#">空姐</a></div>
    <div class="col-md-1" ><a href="#">飞机制造</a></div>
    <div class="col-md-1" ><a href="#">微电子</a></div>

    <div class="col-md-12" style="height: 12px"></div>

    <div class="col-md-1 col-md-offset-1" ><a href="#">数字媒体</a></div>
    <div class="col-md-1" ><a href="#">嵌入式</a></div>
    <div class="col-md-1" ><a href="#">产品经理</a></div>
    <div class="col-md-1" ><a href="#">出版</a></div>
    <div class="col-md-1" ><a href="#">印刷</a></div>
    <div class="col-md-1" ><a href="#">养殖</a></div>
    <div class="col-md-1" ><a href="#">石油化工</a></div>
    <div class="col-md-1" ><a href="#">电气</a></div>
    <div class="col-md-1" ><a href="#">家具制造</a></div>
    <div class="col-md-1" ><a href="#">电子商务</a></div>
    <div class="col-md-1" ><a href="#">运输</a></div>

    <div class="col-md-12" style="height: 8px"></div>

    <div class="col-md-1 col-md-offset-1" ><a href="#">前端开发</a></div>
    <div class="col-md-1" ><a href="#">Linux</a></div>
    <div class="col-md-1" ><a href="#">培训</a></div>
    <div class="col-md-1" ><a href="#">餐饮</a></div>
    <div class="col-md-1" ><a href="#">React</a></div>
    <div class="col-md-1" ><a href="#">Swift</a></div>
    <div class="col-md-1" ><a href="#">JavaScript</a></div>
    <div class="col-md-1" ><a href="#">临床医学</a></div>

  </div><!-- row-->

  <div class="row" style="border-bottom: 1px solid #D0D6D9;height: 30px;line-height: 30px; ">
      <div class="col-md-1">课程：</div>
      <div class="col-md-1">生涯规划</div>
      <div class="col-md-1"> 创业指导</div>
      <div class="col-md-1">就业宝</div>
   </div>
<br/>
<div class="row">
	<c:forEach  var="mooc" items="${moocs}">
	 <div class="col-md-3" style="margin-top:25px;background-color:#F8F8F8;">
	   <a href="http://localhost:8080/startup/jsp/getArticleJSP/${mooc.articleid}">
	       <div><img src=${mooc.miniphotourl}></img></div>  
	       <div>${mooc.title }</div>       
	   </a>
	  </div>
</c:forEach>
</div>
<!--  这里实现加载更多的页面功能，只需要点击加载新的数据就可以。将采用AngularJS实现-->
<!-- 更多(点击获取) -->

</div> <!-- container -->
</body>
</html>
