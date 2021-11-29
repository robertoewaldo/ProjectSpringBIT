<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ganti Password</title>
<script
  src="https://code.jquery.com/jquery-3.6.0.js"
  integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
  crossorigin="anonymous">
</script>
<script type="text/javascript" src="/ProjectSpring/resources/js/index.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="/ProjectSpring/resources/css/index.css">
</head>
<body>
	<div class="container row">
		<jsp:include page="../menu/nav.jsp" />
		<div class="content_container col-md-9">
			<form:form method = "POST" action = "/ProjectSpring/password/change">
				<table>
					<tr>
						<td>Password Lama:</td>
						<td><input type='password' name='old_password' required="required"/></td>
					</tr>
					<tr>
						<td>Password Baru:</td>
						<td><input type='password' name='new_password' id="new_password_input" required="required"/></td>
					</tr>
					<tr>
						<td>Konfirmasi Password:</td>
						<td><input type='password' name='new_password_confirm' id="new_password_confirm_input" required="required"/></td>
					</tr>	
				</table>
				
				<input name="submit" id="submit_btn" type="submit" value="submit" />
				<a href="javascript:history.back()"><button type="button">cancel</button></a>
				<span class="error_msg">${error_msg}</span>	
			</form:form>
		</div>
	</div>
	
	<script type="text/javascript">
		$(document).ready(function(){
			$('#submit_btn').on('click', function(e){
				if($('#new_password_input').val() != "" && $('#new_password_confirm_input').val() != ""){
					if($('#new_password_confirm_input').val() != $('#new_password_input').val()){
						e.preventDefault();
						$('.error_msg').text("Password dan Konfirmasi Password tidak match!")
				
					}
				}	
			})
		});
	</script>
</body>
</html>