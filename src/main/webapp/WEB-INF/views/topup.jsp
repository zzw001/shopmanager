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
    <div class="jumbotron">
        <div class="container">
            <h1>充值</h1>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <c:if test="${error!=null}">
                    <div class="alert alert-danger">
                        <button type="button" class="close" data-dismiss="alert"><span>&times;</span></button>
                        <p>${error}</p>
                    </div>
                </c:if>
                <form method="post" accept-charset="utf-8" id="topup_form">
                    <div class="form-group">
                        <label>余额</label>
                        <h3>￥${user.money}</h3>
                    </div>
                    <div class="form-group">
                        <label>金额</label>
                        <input type="number" class="form-control input-lg" name="money" id="money">
                    </div>
                    <div class="form-group">
                        <label>密码</label>
                        <input type="password" class="form-control input-lg" name="password" id="password">
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <button type="submit" class="btn btn-primary pull-right">充值</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</main>
<script src="/js/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/jquery.md5.js"></script>
<script>
    $("#topup_form").submit(function () {
        $("#password").val($.md5($("#password").val()));
        return true;
    });
</script>

</body>
</html>