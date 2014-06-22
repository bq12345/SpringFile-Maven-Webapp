<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>新增用户</title>
<style>
input {
	display: block;
}
</style>
</head>
<body>
	<h1>增加用户</h1>
	<form action="addUser.do" method="post" enctype="multipart/form-data">
		<input type="text" name="name" placeholder="name" /> <input
			type="text" name="age" placeholder="age" /> <input type="file"
			name="file" /> <input type="submit" value="Submit" />
	</form>
</body>
</html>
