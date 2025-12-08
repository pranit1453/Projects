<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Welcome to ToDo App</title>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">

<style>
body {
	background: #f6f7fb;
	font-family: Arial, sans-serif;
}

.center-box {
	margin-top: 120px;
}

.quote-box {
	margin-top: 40px;
	font-style: italic;
	color: #555;
}
</style>
</head>
<body>

	<div class="container text-center center-box">

		<h1 class="mb-4">📝 Welcome to ToDo Manager</h1>

		<a href="/ToDoMVC/login/loginuser"
			class="btn btn-primary btn-lg"> Enter ToDo App → </a>

		<div class="quote-box">
			<p>"Small steps every day lead to big results."</p>
			<p>"Your future is created by what you do today, not tomorrow."</p>
			<p>"A little progress each day adds up to big success."</p>
		</div>

	</div>

</body>
</html>
