<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>商品录入系统</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${requestScope.getContextPath}/css/bootstrap.min.css">
    <link href="${requestScope.getContextPath}/css/fontawesome-all.min.css" rel="stylesheet">
    <link href="${requestScope.getContextPath}/css/base.css" rel="stylesheet">
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
                <li><a href="/"><span class="fas fa-home"></span>首页</a></li>
                <li><a href="/shopcart"><span class="fas fa-cart-plus"></span>购物车</a></li>
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
<div class="jumbotron">
    <div class="container text-center">
        <h1>商品</h1>
    </div>
</div>
<div class="container">
    <div class="row">
            <div class="col-md-4">
                    <img src="${product.proImage}" class="thumbnail img-responsive">
            </div>
            <div class="col-md-8">
                <form method="post" accept-charset="utf-8">
                    <h2>${product.proName}</h2>
                    <h3 class="text-danger">价格:￥${product.proPrice}</h3>
                    <div class="form-group">
                        <h4>规格</h4><br>
                        <button class="btn btn-default size" disabled>${product.proSize}</button>
                    </div>
                    <div class="form-group">
                        <label>购买数量</label>
                        <input type="number" name="number" class="number-button"><small>库存:${product.proStack}件</small>
                        <input type="hidden" name="proid" value="${product.proId}">
                    </div>
                    <div class="col-md-offset-1">
                        <button type="submit" class="btn btn-danger center-block">添加到购物车</button>
                    </div>
                </form>
            </div>
        </ul>
    </div>
    <div class="row">
        <div class="col-md-12">
            <h3>商品详情</h3>
            <h4 class="thumbnail desc">${product.proDesc}</h4>
        </div>
    </div>
</div>
</main>
</body>
</html>
