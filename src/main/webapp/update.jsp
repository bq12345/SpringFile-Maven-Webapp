<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>用户修改</title>
<style>
input {
	display: block;
}
</style>
</head>
<body>
	<h1>更新用户</h1>
	<form action="updateUser.do" method="post"
		enctype="multipart/form-data">
		<input type="hidden" value="${user.id}" name="id"> <input type="text"
			name="name" placeholder="name" value="${user.name}" /> <input
			type="text" name="age" placeholder="age" value="${user.age}" /> <input
			type="file" name="file" /> <input type="submit" value="Submit" />
	</form>
</body>
</html>
