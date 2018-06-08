<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/27
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>商场商品展示系统</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${requestScope.getContextPath}/css/bootstrap.min.css">
    <link href="css/fontawesome-all.min.css" rel="stylesheet">
    <link href="css/base.css" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
</head>
<body>

<nav class="navbar navbar-static-top navbar-default">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">商场商品展示系统</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/"><span class="fas fa-home"></span>首页</a></li>
                <li><a href="#"><span class="fas fa-cart-plus"></span>购物车</a></li>
            </ul>
            <c:if test="${username!=null}">
                <ul class="nav navbar-nav pull-right">
                    <li><a href="/profile"><span class="fas fa-user"></span>欢迎${username}</a></li>
                    <li><a href="/logout"><span class="fas fa-registered"></span>退出</a></li>
                </ul>
            </c:if>
            <c:if test="${username==null}">
                <ul class="nav navbar-nav pull-right">
                    <li><a href="/login"><span class="fas fa-user"></span>登录</a></li>
                    <li><a href="/register"><span class="fas fa-registered"></span>注册</a></li>
                </ul>
            </c:if>

        </div>
    </div>
</nav>
<main>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <input class="search col-md-10" type="text" name="search" id="search"/>
                <button class="btn btn-primary fas fa-search"></button>
            </div>
        </div>
        <div class="row category">
            <div class="col-md-2">
                <ul class="list-group">
                    <c:forEach items="${catagories}" var="catagory">
                        <li class="list-group-item" cataid="${catagory.cataId}" >${catagory.cataName}</li>
                    </c:forEach>

                </ul>
            </div>
            <div class="col-md-10" id="subcatabody">
            </div>
        </div>
        <div class="row content">
            <div class="category-challenges tab-pane col-md-12">
                <div class="col-md-3 d-inline-block">
                    <button class="btn btn-light challenge-button w-100 text-truncate pt-3 pb-3 mb-2">
                        <img src="/img/ctfd.svg" />
                        <p>aaaa</p>
                        <span>aaaaa</span>
                    </button>
                </div>
            </div>
        </div>
    </div>

</main>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script>
    $(".list-group-item").each(function () {
        $(this).bind('click',function () {
            var cataid = $(this).attr("cataid");
            $.get('subcata/'+cataid,'',function (data) {
                var subcatas = $.parseJSON(JSON.stringify(data));
                var subcatabody = $("#subcatabody").empty();
                for(var i=0 ;i<subcatas.length;i++){
                    var li = '<div class="col-md-3 d-inline-block" subcataid="'+subcatas[i].subId+'">'+subcatas[i].subName+'</div>';
                    subcatabody.append(li);
                }
            });
        });
    });
</script>
</body>
</html>