<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reset Password</title>
</head>
<body>
    <div class="container">
        <h2>Reset Password</h2>
        <form action="ResetPassword" method="post">
            <input type="hidden" name="email" value="${requestScope.user.email}">
            <div class="form-group">
                <label for="password">New Password:</label>
                <input type="password" id="password" name="password" required>
            </div>
            <div class="form-group">
                <button type="submit">Reset Password</button>
            </div>
        </form>
        <p class="message"><%= request.getAttribute("message") %></p>
        <p class="error"><%= request.getAttribute("error") %></p>
    </div>
</body>
</html>
