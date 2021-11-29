<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transaksi</title>
<script type="text/javascript" src="/ProjectSpring/resources/js/index.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="/ProjectSpring/resources/css/index.css">
</head>
<body>
	<div class="container row">
		<jsp:include page="../menu/nav.jsp" />
		<div class="content_container col-md-9">
			<h1>Daftar Transaksi</h1>
			<h3>Periode: ${month}</h3>
			
			<table border="1">
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
			<a href="javascript:history.back()"><button type="button">back</button></a>
		</div>
	</div>
</body>
</html>