<%--
  Created by IntelliJ IDEA.
  User: nherbaut
  Date: 17/06/2022
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>sdqf</title>
</head>
<body>
<form method="post" action="/main">
    <p>
        <label for="githubRepoName">githubRepoName</label>
        <input type="text" name="githubRepoName" id="githubRepoName">
    </p>
    <p>
        <label for="githubToken">githubRepoName</label>
        <input type="password" name="githubToken" id="githubToken">
    </p>
    <p>
        <input type="submit">
    </p>
</form>
</body>
</html>
