<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/1
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script src="js/jquery-3.3.1.js"></script>
    <script>
//         $(function(){
// // 绑定点击事件
//             $("#btn").click(function(){
//                 var Test = '{username:"aa",password:"100"}'

//             });
//         });

$(document).ready(function() {
    ajaxRequest();
});

function ajaxRequest() {
    var Test = '{username:"aa",password:"100"}'
    $.ajax({
        url: "user/testJson",
        contentType: "application/json;charset=UTF-8",
        data: Test,
        dataType: "json",
        type: "post",
        success: function (data) {
            alert(data.username)
        }, error: function () {
            alert("错误")
        }
    })
}
    </script>

</head>
<body>

<a href="user/testString">点击</a>
<a href="user/testVoid">点击测试void</a>
<br>

<button id="btn">点击测试ajax</button>

<form action="user/testBody" method="post">
    姓名：<input name="username" type="text">
    密码：<input name="password" type="text">
    <input type="submit" value="提交">
</form>
</body>
</html>
