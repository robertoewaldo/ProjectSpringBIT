<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>

<div class="menu_container col-md-3">
	<ul class="list-group">
		<li class="list-group-item"><a href="/ProjectSpring/home"><fmt:message key="menu.home" /></a></li>
		<li class="list-group-item"><a href="/ProjectSpring/pembelian"><fmt:message key="menu.purchase" /></a></li>
		<li class="list-group-item"><a href="/ProjectSpring/pembayaran"><fmt:message key="menu.payment" /></a></li>
		<li class="list-group-item">
			<a href="#" id="credit_show"><fmt:message key="menu.credit" /></a>
			<ul id="credit_menu">
				<li><a href="/ProjectSpring/transaksi"><fmt:message key="menu.credit.transactions" /></a></li>
				<li><a href="/ProjectSpring/tagihan"><fmt:message key="menu.credit.bill" /></a></li>
			</ul>
		</li>
		<li class="list-group-item">
			<a href="#" id="admin_show"><fmt:message key="menu.admin" /></a>
			<ul id="admin_menu">
				<li><a href="/ProjectSpring/password"><fmt:message key="menu.admin.password" /></a></li>
				<li>
					<a href="#" id="language_show"><fmt:message key="menu.admin.language" /></a>
					<ul id="language_menu">
						<li><a href="#" id="language_en"><fmt:message key="menu.admin.language.english" /></a></li>
						<li><a href="#" id="language_in"><fmt:message key="menu.admin.language.indonesian" /></a></li>
					</ul>
				</li>
			</ul>
		</li>
	</ul>
</div>