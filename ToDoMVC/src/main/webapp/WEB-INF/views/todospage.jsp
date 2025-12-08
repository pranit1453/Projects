<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My To-Do List</title>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/todo.css">
</head>
<body>
	<div class="todo-box container mt-4 p-4 bg-light rounded shadow-sm">

		<h2 class="text-center mb-3">📝 To-Do Dashboard</h2>

		<c:if test="${not empty sessionScope.user}">
			<p class="text-end">
				Welcome, <b>${sessionScope.user.username}</b> | <a
					href="${pageContext.request.contextPath}/login/logout">Logout</a>
			</p>
		</c:if>

		<c:if test="${not empty message}">
			<div class="alert alert-success text-center">${message}</div>
		</c:if>

		<c:if test="${not empty error}">
			<div class="alert alert-danger text-center">${error}</div>
		</c:if>

		<form action="${pageContext.request.contextPath}/todos/add"
			method="post" class="mb-3">
			<div class="input-group">
				<input type="text" name="title" class="form-control"
					placeholder="Enter new task..." required> <input
					type="text" name="description" class="form-control"
					placeholder="Enter description..." required>
				<button class="btn btn-primary">Add</button>
			</div>
		</form>

		<table class="table table-bordered table-striped">
			<thead class="table-dark">
				<tr>
					<th>#</th>
					<th>Task</th>
					<th>Status</th>
					<th width="150px">Actions</th>
					<th>Time</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todos}" var="t" varStatus="vs">
					<tr>
						<td>${vs.index + 1}</td>
						<td>${t.title}</td>
						<td><a
							href="${pageContext.request.contextPath}/todos/toggle/${t.id}"
							style="text-decoration: none;"> <c:choose>
									<c:when test="${t.completed}">
										<span class="badge bg-success">Done</span>
									</c:when>
									<c:otherwise>
										<span class="badge bg-warning">Pending</span>
									</c:otherwise>
								</c:choose></td>
						<td><a
							href="${pageContext.request.contextPath}/todos/edit/${t.id}"
							class="btn btn-sm btn-secondary">Edit</a> <a
							href="${pageContext.request.contextPath}/todos/delete/${t.id}"
							class="btn btn-sm btn-danger"
							onclick="return confirm('Delete this task?');">Delete</a></td>
						<td><c:choose>
								<c:when test="${not empty t.createdAt}">
									<!-- format the timestamp: adjust pattern as you like -->
									<fmt:formatDate value="${t.createdAt}"
										pattern="dd-MMM-yyyy HH:mm" />
								</c:when>
								<c:otherwise>-</c:otherwise>
							</c:choose></td>
					</tr>
				</c:forEach>

				<c:if test="${empty todos}">
					<!-- colspan should match number of columns (5) -->
					<tr>
						<td colspan="5" class="text-center text-muted">No tasks yet.
							Add one above.</td>
					</tr>
				</c:if>
			</tbody>
		</table>
	</div>
</body>
</html>
