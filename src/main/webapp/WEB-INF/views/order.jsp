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
        <div class="container">
            <h1>订单</h1>
        </div>
    </div>
    <div class="container">
        <c:if test="${orders == null || orders.size() == 0}">
            <div class="row">
                <div class="col-md-12">
                    <div class="text-center">
                        <h3 class="spinner-error">还未购买任何商品</h3>
                    </div>
                </div>
            </div>
        </c:if>

        <c:if test="${orders.size() !=0}">
            <div class="row">
                <div class="col-md-12">
                    <div>
                        <table class="table table-striped">
                            <thead>
                            <tr>
                                <td>商品名</td>
                                <td>商品规格</td>
                                <td>购买数量</td>
                                <td>购买价格</td>
                                <td>快递状态</td>
                                <td>操作</td>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${orders}" var="order">
                                <tr>
                                    <td><a href="/product/${order.proid}">${order.proname}</a></td>
                                    <td>${order.size}</td>
                                    <td>${order.buy_num}</td>
                                    <td>${order.price}</td>
                                    <td>
                                        <c:if test="${order.cart_state == 1}">
                                            <span class="bg-danger text-danger">未揽件</span>
                                        </c:if>
                                        <c:if test="${order.cart_state == 2}">
                                            <span class="bg-info text-info">正在运送</span>
                                        </c:if>
                                        <c:if test="${order.cart_state == 3}">
                                            <span class="bg-primary text-primary">正在派件</span>
                                        </c:if>
                                        <c:if test="${order.cart_state == 4}">
                                            <span class="bg-success text-success">订单完成</span>
                                        </c:if>
                                    </td>
                                    <td>
                                        <span class="tran-info" data-toggle="tooltip" data-placement="top" cart-id="${order.cartid}" title="${order.proname} 快递信息">
                                            <i class="fas fa-info" aria-hidden="true" cart-id="${order.cartid}"></i>
                                        </span>
                                        <span>&nbsp;</span>
                                        <c:if test="${order.cart_state == 3}">
                                            <span class="confirm-btn" data-toggle="tooltip" data-placement="top" cart-id="${order.cartid}" title="${order.proname} 确认收货">
                                                <i class="fas fa-check" aria-hidden="true" cart-id="${order.cartid}"></i>
                                            </span>
                                        </c:if>
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
    $('.tran-info').click(function (e) {
        var cartid = $(this).attr('cart-id');
        $.get('/transportation/'+cartid,'',function (data) {
            var body = '';
            if(data == 0){
                body = '<p>暂时查询不到任何快递信息</p>';
            }else{
                data = $.parseJSON(JSON.stringify(data));
                for(var i = 0 ; i < data.length; i++){
                    body+='<p>'+data[i].tranInfoContext+'</p>';
                }
            }
            ezal({
                title: "快递信息",
                body: body,
                button:"确认"
            });
        });
    });

    $(".confirm-btn").click(function () {
        var cartid = $(this).attr('cart-id');
        ezq({
            title: "确认收货",
            body: "确定确认收货?",
            success: function () {
                $.get('/shopcart/confirm/'+cartid, '', function () {
                    $(window).attr('location','/order');
                });
            }
        });
    });
</script>
</body>
</html>
