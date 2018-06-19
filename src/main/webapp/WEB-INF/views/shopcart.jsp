<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>商场商品展示系统</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${requestScope.getContextPath}/css/bootstrap.min.css">
    <link href="/css/fontawesome-all.min.css" rel="stylesheet">
    <link href="/css/base.css" rel="stylesheet">
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
                <li class="active"><a href="/shopcart"><span class="fas fa-cart-plus"></span>购物车</a></li>
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
        <div class="container">
            <h1>购物车</h1>
        </div>
    </div>
    <div class="container">
        <c:if test="${shopcarts == null || shopcarts.size() == 0}">
            <div class="row">
                <div class="col-md-12">
                    <div class="text-center">
                        <h3 class="spinner-error">还未加入任何商品</h3>
                    </div>
                </div>
            </div>
        </c:if>

        <c:if test="${shopcarts.size() !=0}">
        <div class="row">
            <div class="col-md-12">
                <div>
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <td>商品名</td>
                            <td>商品规格</td>
                            <td>商品价格</td>
                            <td>购买数量</td>
                            <td>购买价格</td>
                            <td>操作</td>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${shopcarts}" var="shopcart">
                            <tr>
                                <td><a href="/product/${shopcart.proid}">${shopcart.proname}</a></td>
                                <td>${shopcart.size}</td>
                                <td>${shopcart.price}</td>
                                <td>${shopcart.buy_num}</td>
                                <td>${shopcart.buy_price}</td>
                                <td>
                                    <span class="buy-btn" data-toggle="tooltip" data-placement="top" cart-id="${shopcart.cartid}" title="结算 ${shopcart.proname}">
                                        <i class="fab fa-amazon-pay" aria-hidden="true" cart-id="${shopcart.cartid}"></i>
                                    </span>
                                    <span>&nbsp;</span>
                                    <span class="delete-btn" data-toggle="tooltip" data-placement="top" cart-id="${shopcart.cartid}" title="删除 ${shopcart.proname}">
                                        <i class="fas fa-times" aria-hidden="true" cart-id="${shopcart.cartid}"></i>
                                    </span>
                                </td>
                            </tr>
                        </c:forEach>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        </c:if>


    </div>
</main>
<script src="/js/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/ezq.js"></script>
<script src="/js/utils.js"></script>
<script>

    $('.buy-btn').click(function () {
        var cartid = $(this).attr('cart-id');
        $(window).attr("location",'/shopcart/balance/'+cartid);
    });

    $('.delete-btn').click(function (e) {
        var cartid = $(this).attr('cart-id');
        var td_row = $(this).parent().parent();
        ezq({
            title: "删除购物车记录",
            body: "确定删除购物车记录?",
            success: function () {
                $.get('/shopcart/delete/'+cartid, '', function (data) {
                    if (data == 1) {
                        td_row.remove();
                    }
                    else {
                        ezal({
                            title: "错误",
                            body: "存在错误",
                            button:"确认"
                        });
                    }
                });
            }
        });
    });


</script>
</body>
</html>
