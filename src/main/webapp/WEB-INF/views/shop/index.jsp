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
            <a class="navbar-brand" href="/shop/">商场商品录入系统</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/shop/"><span class="fas fa-home"></span>添加</a></li>
                <li><a href="/shop/list"><span class="fas fa-cart-plus"></span>商品列表</a></li>
            </ul>

        </div>
    </div>
</nav>
<main>
    <div class="jumbotron">
        <div class="container text-center">
            <h1>商品录入系统</h1>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-md-8 col-md-offset-3">
                <form action="/shop/add" method="post" enctype="multipart/form-data" accept-charset="utf-8">
                    <div class="form-group">
                        <label>商品名称</label>
                        <input type="text" class="form-control input-lg" name="pro_name">
                    </div>
                    <div class="form-group">
                        <label>分类</label>
                        <c:set var="catename" value="${catename}" scope="request"></c:set>
                        <select name="catename" class="visible-md-block">
                            <option value="${catename}">${catename}</option>
                            <c:forEach items="${categorys}" var="category">
                                <option value="${category}" <c:if test="${catename == category}">selected</c:if> >${category}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>商品价格</label>
                        <input type="number" class="form-control input-lg" name="pro_price">
                    </div>
                    <div class="form-group">
                        <label>商品库存</label>
                        <input type="number" class="form-control input-lg" name="pro_stack">
                    </div>
                    <div class="form-group">
                        <label>商品规格</label>
                        <input type="text" class="form-control input-lg" name="pro_size">
                    </div>
                    <div class="form-group">
                        <label>商品详情</label>
                        <textarea class="form-control" rows="10" name="pro_desc" style="height:234px; overflow-y: scroll;"></textarea>
                    </div>
                    <div class="form-group">
                        <label>商品图片</label>
                        <input type="file" name="file" class="visible-md-block">
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <button type="submit" class="btn btn-primary pull-right">添加</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</main>


</body>
</html>
