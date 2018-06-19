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
<main>
    <div class="jumbotron">
        <div class="container text-center">
            <h1>用户收货地址</h1>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <div class="form-group">
                    <label>手机号码</label>
                    <input type="text" class="form-control input-lg" name="phone" id="phone" value="${user.phone}" disabled>
                </div>
                <div class="form-group">
                    <label>邮编</label>
                    <input type="text" class="form-control input-lg" name="code" id="code" value="${user.code}" disabled>
                </div>
                <div class="form-group">
                    <label>地址</label>
                    <input type="text" class="form-control input-lg" name="address" id="address" value="${user.address}" disabled>
                </div>
            </div>
        </div>
    </div>

</main>
</body>
</html>