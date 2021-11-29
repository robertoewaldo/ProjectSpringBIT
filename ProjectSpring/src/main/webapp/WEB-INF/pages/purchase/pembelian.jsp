<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pembelian</title>
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
			<h1>Pembelian Voucher Isi Ulang</h1>
			<form:form method = "POST" action = "/ProjectSpring/pembelian/confirmation">
				<table>
					<tr>
						<td>Provider:</td>
						<td>
							<select id="provider_input" name="provider" required="required">
								<option value="Telkomsel">Telkomsel</option>
								<option value="XL">XL</option>
								<option value="Indosat">Indosat</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>No Telp:</td>
						<td><input type='text' id="phone_input" class="input_number" name="phone_num" pattern="[08]{2}[0-9]{8,10}" required="required" /></td>
					</tr>
					<tr>
						<td>Token:</td>
						<td>
							<input type='text' id="token_random_input" name="token_random" readonly="readonly" required="required"/>
							<input type='text' id="token_phone_input" name="token_phone" readonly="readonly" required="required"/>
						</td>
					</tr>
					<tr>
						<td>Apply2 :</td>
						<td><input type='text' id="appli2_input" class="input_number" name="appli2" required="required"/></td>
					</tr>
				</table>
				
				<input name="submit" id="submit_btn" type="submit" value="submit" />
				<a href="javascript:history.back()"><button type="button">cancel</button></a>
			</form:form>
		</div>
	</div>
	
	<script type="text/javascript">
		
		$(document).ready(function(){
			$('.input_number').on('input', function(){
				this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');
			})
			
			var phoneInput = $('#phone_input');
			var tokenRandomInput = $('#token_random_input');
			var tokenPhoneInput = $('#token_phone_input');
			var pattern = new RegExp('[08]{2}[0-9]{8,10}');
			
			phoneInput.on('change', function(){

				var phoneNum = phoneInput.val();
				
				if(pattern.test(phoneNum)){
					tokenPhoneInput.attr('value', phoneNum.substr(phoneNum.length - 6));
					tokenRandomInput.attr('value', Math.floor(Math.random() * 90 + 10));
				}
				else{
					alert('invalid phone number');
				}
			})
		})
	</script>
</body>
</html>