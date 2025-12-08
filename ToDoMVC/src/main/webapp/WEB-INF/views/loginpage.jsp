<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login - ToDo App</title>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">

<style>
body {
	background: #eef1f7;
	font-family: Arial, sans-serif;
}

.login-box {
	max-width: 400px;
	margin: 100px auto;
	padding: 25px;
	border-radius: 10px;
	background: white;
	box-shadow: 0 0 12px rgba(0, 0, 0, 0.1);
}

.title {
	font-weight: bold;
	margin-bottom: 20px;
}
</style>
</head>
<body>

	<div class="login-box">

		<h3 class="text-center title">🔐 Login</h3>

		<c:if test="${not empty error}">
			<div class="alert alert-danger text-center">${error}</div>
		</c:if>

		<!-- Use contextPath so action works when app is not deployed at root -->
		<form action="${pageContext.request.contextPath}/login/authenticate"
			method="post">

			<div class="mb-3">
				<label class="form-label">Username</label> <input type="text"
					name="username" class="form-control" placeholder="Enter username"
					required>
			</div>

			<div class="mb-3">
				<label class="form-label">Password</label> <input type="password"
					name="password" class="form-control" placeholder="Enter password"
					required>
			</div>

			<div class="d-grid">
				<button class="btn btn-primary">Login</button>
			</div>

			<div class="text-center mt-3">
				<a href="${pageContext.request.contextPath}/register">Create
					Account</a>
			</div>

		</form>

	</div>

</body>
</html>
