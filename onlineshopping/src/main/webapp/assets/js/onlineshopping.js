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
			if(menu == "Home") break;
			$('#list-products').addClass('active');
			$('#a_'+menu).addClass('active');
			break;
	}
	
	// Code for jquery datatable
	var $table = $('#productListTable');
	if($table.length) {
		//console.log('Inside the table');
		var apiUrl = '';
		if(window.categoryId == '') {
			apiUrl = window.contextRoot + '/rest/all/products';
		}
		else {
			apiUrl = window.contextRoot + '/rest/category/' + window.categoryId + '/products';
		}
		$table.DataTable({
			lengthMenu: [[5,10,-1], ['5 Records', '10 Records', 'ALL']],
			pageLenth: 5,
			ajax: {
				url: apiUrl,
				dataSrc: ''
			},
			columns: [
				{
					data: 'code',
					mRender: function(data, type, row) {
						return '<img src="' + window.contextRoot + '/resources/images/' + data + '.jpg" class="dataTableImg" />';
					}
				},
				{
					data: 'name'
				},
				{
					data: 'brand'
				},
				{
					data: 'unitPrice',
					mRender: function(data, type, row) {
						return '&#8377;' + data;
					}
				},
				{
					data: 'quantity',
					mRender: function(data, type, row) {
						if(data < 1) {
							return '<span style="color:red">Out of Stock!</span>';
						}
						return data;
					}
				},
				{
					data: 'id',
					bSortable: false,
					mRender: function(data, type, row) {
						var str = '';
						str += '<a href="' + window.contextRoot + '/show/' + data + '/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></a>&#160;';
						if(row.quantity < 1) {
							str += '<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></a>';
						}
						else {
							str += '<a href="' + window.contextRoot + '/cart/add/' + data + '/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></a>';
						}
						return str;
					}
				}
			]
		});
	}
});