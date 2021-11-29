<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tagihan</title>
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
			<h1>Tagihan</h1>
			<h3>Periode: ${month}</h3>
			
			<table id="bill_table">
				<tr>
					<td>Total Tagihan</td>
					<td>: ${bill.bill_amount}</td>
				</tr>
				<tr>
					<td>Total Sudah Dibayar</td>
					<td>: <span id="paid_amount_val">${paid_amount}</span></td>
				</tr>
				<tr>
					<td><b>Sisa Harus Dibayar</b></td>
					<td>: <span id="remaining_amount_val"><b>${bill.remaining_amount}</b></span></td>
				</tr>
				<tr>
					<td>Minimal Bayar</td>
					<td>: 50000</td>
				</tr>
				<tr>
					<td>Tanggal Jatuh Tempo</td>
					<td>: ${due_date_str}</td>
				</tr>
			</table>
			
			<br>
			
			<table id="transaction_table" border="1">
				<tr>
					<th>Nama Merchant</th>
					<th>Tanggal Transaksi</th>
					<th>Nominal</th>
				</tr>
				<c:forEach items="${transaction_list}" var="transaction">
					<tr>
						<td><c:out value="${transaction.merchant}"/></td>
						<td><c:out value="${transaction.transaction_date}"/></td>
						<td><c:out value="${transaction.amount}"/></td>
					</tr>
		  		</c:forEach>
			</table>
			<br>
			
			<form:form method = "POST" action= "/ProjectSpring/tagihan/bayar" id="bill_form">
				<input type="hidden" name="bill_id" value="${bill.id}">
				Nilai Bayar: 
				<input type="number" name="pay_amount" id="pay_amount_input" min="50000" step="5000" max="${bill.remaining_amount}" value="${bill.remaining_amount}">
				
				<input name="submit" type="submit" value="submit" />
			</form:form>
			<a href="javascript:history.back()"><button type="button">back</button></a>
			
		</div>
	</div>
	
	<script type="text/javascript">
		$(document).ready(function(){			
			if($('#remaining_amount_val').text() == 0){
				$('#paid_amount_val').append(' (LUNAS)');
				$('#bill_form').hide();
			}
			else if($('#remaining_amount_val').text() < 50000){
				$('#pay_amount_input').attr("min", $('#remaining_amount_val').text());
			}
		});
	</script>
</body>
</html>