<%--
  Created by IntelliJ IDEA.
  User: Chi Can Em
  Date: 28-02-2018
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>reCAPTCHA demo: Simple page</title>
    <%--thêm thư viện js của google để sài--%>
    <script src="https://www.google.com/recaptcha/api.js" async defer></script>
</head>
<body>
<form action="/checkCaptcha" method="POST">
    <%-- 6Lfxd0kUAAAAAGixuocsXslR9SVxx là một đoạn mã công khai, sẽ có 1 đoạn mã khác để giải mã
     đoạn mã này dùng để mã hóa và gửi lên server, server sẽ dùng key bí mật để giải mã--%>
    <div class="g-recaptcha" data-sitekey="6Lfxd0kUAAAAAGixuocsXslR9SVxx-ZO3nKTNnt4"></div>
    <br/>
    <input type="submit" value="Submit">
</form>
</body>
</html>
