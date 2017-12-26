<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
test:
	<div class="container">
		<h1>创建</h1>
		<form action="test" method="post">
			<input type="hidden" name="method" value="create">
			<fieldset>
				姓名:<input type="text" name="name" value="111" /><br /> 
				描述:<input type="text" name="pwd" value="" /><br />
				date:<input type="text" name="date123" value="2017-08-21" /><br />
				<input type="submit">
			</fieldset>
		</form>
	</div>
</body>
</html>