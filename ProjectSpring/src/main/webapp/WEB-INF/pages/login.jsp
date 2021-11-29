<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="/ProjectSpring/resources/css/index.css">
</head>
<body>
	<div class="container d-flex justify-content-center align-items-center">
		<div id="login_container">
			<form:form method = "POST" action = "perform_login" modelAttribute="user">
				<table>	
					<tr>
						<td colspan="2"><h1 id="login_title">LOGIN</h1></td>
					</tr>
					<tr>
						<td width="100px"><label class="form-label">User</label></td>
						<td><input type='text' name='username' class="form-control" value='' autocomplete="off"></td>
					</tr>
					<tr>
						<td width="100px"><label class="form-label">Password</label></td>
						<td><input type='password' class="form-control" name='password' /></td>
					</tr>
				</table>
				<input name="submit" type="submit" class="btn btn-primary mt-3" value="Submit" />
			</form:form>
		</div>
	</div>
</body>
</html>