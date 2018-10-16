$(function() {
	// Solving active menu problem
	switch(menu) {
		case 'About Us':
			$('#about').addClass('active');
			break;
		case 'Contact Us':
			$('#contact').addClass('active');
			break;
		case 'All Products':
			$('#list-products').addClass('active');
			break;
		default:
			$('#list-products').addClass('active');
			$('#a_'+menu).addClass('active');
			break;
	}
});