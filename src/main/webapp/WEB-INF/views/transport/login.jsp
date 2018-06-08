<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>快递管理系统</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${requestScope.getContextPath}/css/bootstrap.min.css">
    <link href="${requestScope.getContextPath}/css/fontawesome-all.min.css" rel="stylesheet">
    <link href="${requestScope.getContextPath}/css/base.css" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
</head>
<body>
<div class="jumbotron">
    <div class="container text-center">
        <h1>快递管理系统</h1>
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
            <form method="post" accept-charset="utf-8" id="login_form">
                <div class="form-group">
                    <label>用户名</label>
                    <input type="text" class="form-control input-lg" name="username" id="username">
                </div>
                <div class="form-group">
                    <label>密码</label>
                    <input type="password" class="form-control input-lg" name="password" id="password">
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <button type="submit" class="btn btn-primary pull-right">登录</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="${requestScope.getContextPath}/js/jquery.min.js"></script>
<script src="${requestScope.getContextPath}/js/bootstrap.min.js"></script>
<script src="${requestScope.getContextPath}/js/jquery.md5.js"></script>
<script>
    $("#login_form").submit(function () {
        $("#password").val($.md5($("#password").val()));
        return true;
    });
</script>
</body>
</html>
