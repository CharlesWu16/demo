<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0 minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatable" content="ie=edge">
    <title>Document</title>
</head>
<body>

    <h1>用来测试文件上传</h1>
    <%--${pageContext.request.contextPath}表示获取当前项目名uploadFile--%>
    <form action="${pageContext.request.contextPath}/file/upload" method="post" enctype="multipart/form-data">
        <input type="file" name="mFile"> <br>
        <input type="submit" value="上传文件">
    </form>

    <h1>测试下载文件处理</h1>
    <a href="${pageContext.request.contextPath}/file/down?fileName=7.搭建提供者集群.txt">7.搭建提供者集群.txt</a>
    <a href="${pageContext.request.contextPath}/file/down?fileName=8.actuator微服务信息完善.txt">8.actuator微服务信息完善.txt</a>
    <a href="${pageContext.request.contextPath}/file/down?fileName=9.服务发现Discovery.txt">9.服务发现Discovery.txt</a>
</body>
</html>