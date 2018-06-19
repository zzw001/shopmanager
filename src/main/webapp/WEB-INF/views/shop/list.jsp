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
            <a class="navbar-brand" href="/shop/">商场商品管理系统</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="/shop/"><span class="fas fa-home"></span>添加</a></li>
                <li class="active"><a href="/shop/list"><span class="fas fa-cart-plus"></span>商品列表</a></li>
            </ul>

        </div>
    </div>
</nav>
<main>
    <div class="jumbotron">
        <div class="container">
            <h1>商品列表</h1>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div>
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <td>商品名</td>
                            <td>商品分类</td>
                            <td>商品价格</td>
                            <td>商品规格</td>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${products}" var="product">
                            <tr>
                                <td>${product.proname}</td>
                                <td>${product.catagory}</td>
                                <td>${product.price}</td>
                                <td>${product.size}</td>
                            </tr>
                        </c:forEach>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</main>

</body>
</html>
