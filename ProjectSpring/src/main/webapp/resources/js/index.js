$(document).ready(function() {

//==================NAVBAR===================
	var credit_menu = $('#credit_menu');
	var admin_menu = $('#admin_menu');
	var language_menu = $('#language_menu');

	credit_menu.hide();
	admin_menu.hide();
	language_menu.hide();

	$('#credit_show').on('click', function() {
		if (credit_menu.is(":visible")) {
			credit_menu.hide();
		}
		else {
			credit_menu.show();
		}
	});

	$('#admin_show').on('click', function() {
		if (admin_menu.is(":visible")) {
			admin_menu.hide();
		}
		else {
			admin_menu.show();
		}
	});

	$('#language_show').on('click', function() {
		if (language_menu.is(":visible")) {
			language_menu.hide();
		}
		else {
			language_menu.show();
		}
	});

	var url = new URL(window.location.href);
	$('#language_en').on('click', function() {
		url.searchParams.set('lang', 'en');
		window.location.href = url.href;
	});
	$('#language_in').on('click', function() {
		url.searchParams.set('lang', 'in');
		window.location.href = url.href;
	});
//========================================================
	
	
	

});
