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
            <h1>快递管理系统</h1>
        </div>
    </div>

    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div>
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <td>用户名</td>
                            <td>商品名</td>
                            <td>商品类别</td>
                            <td>商品规格</td>
                            <td>购买数量</td>
                            <td>快递状态</td>
                            <td>操作</td>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${transports}" var="transport">
                            <tr>
                                <td><a href="/transport/user/${transport.userid}">${transport.username}</a></td>
                                <td><a href="/product/${transport.proid}">${transport.proname}</a></td>
                                <td>${transport.catagory}</td>
                                <td>${transport.size}</td>
                                <td>${transport.buy_num}</td>
                                <td>
                                    <c:if test="${transport.state == 1}">
                                        <span class="bg-danger text-danger">未揽件</span>
                                    </c:if>
                                    <c:if test="${transport.state == 2}">
                                        <span class="bg-info text-info">正在运送</span>
                                    </c:if>
                                    <c:if test="${transport.state == 3}">
                                        <span class="bg-primary text-primary">正在派件</span>
                                    </c:if>
                                    <c:if test="${transport.state == 4}">
                                        <span class="bg-success text-success">订单完成</span>
                                    </c:if>
                                </td>
                                <td>
                                    <span class="tran-info" data-toggle="tooltip" data-placement="top" cart-id="${transport.cartid}" title="${transport.proname} 快递信息">
                                            <i class="fas fa-info" aria-hidden="true" cart-id="${transport.cartid}"></i>
                                    </span>
                                    <span>&nbsp;</span>
                                    <c:if test="${transport.state == 1}">
                                        <span class="tran-accept" data-toggle="tooltip" data-placement="top" cart-id="${transport.cartid}" title="接收 ${transport.proname}">
                                            <i class="fas fa-check" aria-hidden="true" cart-id="${transport.cartid}"></i>
                                        </span>
                                    </c:if>
                                    <c:if test="${transport.state == 2}">
                                        <span class="plus-btn" data-toggle="tooltip" data-placement="top" cart-id="${transport.cartid}" tran-id="${transport.tranid}" title="添加 ${order.proname} 快递信息">
                                            <i class="fas fa-plus" aria-hidden="true" cart-id="${transport.cartid}" tran-id="${transport.tranid}"></i>
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
    </div>
</main>
<script src="/js/jquery-3.2.1.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/ezq.js"></script>
<script src="/js/utils.js"></script>
<script>
    $('.tran-info').click(function () {
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

    $('.tran-accept').click(function (e) {

        var cartid = $(this).attr('cart-id');
        ezq({
            title: "接收快递",
            body: "确定接收快递?",
            success: function () {
                $.get('/transport/accept/'+cartid, '', function (data) {
                    if (data == 1) {
                        $(window).attr('location','/transport/list');
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

    $(".plus-btn").click(function () {
        var tranid = $(this).attr('tran-id');
        var cartid = $(this).attr('cart-id');
        var body = '<form accept-charset="utf-8" method="post" id="plus_form">' +
            '    <div class="form-group">' +
            '        <label>快递信息</label>' +
            '        <textarea class="form-control" rows="3" name="traninfo" style="height:100px; overflow-y: scroll;"></textarea>' +
            '    </div>' +
            '    <div class="form-group">' +
            '        <label>快递状态</label>' +
            '        <select name="state">' +
            '            <option value="2">正在运送</option>' +
            '            <option value="3">正在派送</option>' +
            '        </select>' +
            '    </div>' +
            '</form>';
            plus({
            title: "添加快递信息",
            body: body,
            success: function () {
                var traninfo = $("#plus_form textarea").val();
                var state = $("#plus_form select option:selected").val();
                console.log("aaa");
                $.post('/transport/add/'+tranid,{'traninfo':traninfo,'state':state,'cartid':cartid},function (data) {
                    $(window).attr('location','/transport/list');
                });

            }
        });
    });
</script>
</body>
</html>