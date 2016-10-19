<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>wen</title>
</head>
<body>
<div class="container">
<h1>创建order1</h1>
<form action="{baseUrl.merchantBaseUrl}action/order1/create" method="post">
<input type="hidden" name="method" value="create">
<fieldset>
<table cellspacing="0" cellpadding="0" border="0">
	<tr>
		<td>name:</td>
		<td><input type="text" class="text" name="name" value="" /></td>
	</tr>
	<tr>
		<td>create_date:</td>
		<td><input type="text" class="text" name="createDate" value="2016-05-10" /></td>
	</tr>
</table>
<input type="submit" value="保存">
</fieldset>
</form>
</div>

</body>
</html>