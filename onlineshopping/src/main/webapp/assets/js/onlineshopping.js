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
		case 'Manage Products':
			$('#manage-products').addClass('active');
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
	
	// Dismissing alert after 3 seconds
	var $alert = $('.alert');
	if($alert.length) {
		setTimeout(function() {
			$alert.fadeOut('slow');
		}, 3000)
	}
	
	// DataTable for admin all products
	var $adminProductsTable = $('#adminProductsTable');
	if($adminProductsTable.length) {
		//console.log('Inside the table');
		var apiUrl = window.contextRoot + '/rest/admin/all/products';

		$adminProductsTable.DataTable({
			lengthMenu: [[10,30,50,-1], ['10 Records', '30 Records', '50 Records', 'ALL']],
			pageLenth: 30,
			ajax: {
				url: apiUrl,
				dataSrc: ''
			},
			columns: [
				{
					data: 'id'
				},
				{
					data: 'code',
					mRender: function(data, type, row) {
						return '<img src="' + window.contextRoot + '/resources/images/' + data + '.jpg" class="adminDataTableImg" />';
					}
				},
				{
					data: 'name'
				},
				{
					data: 'brand'
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
					data: 'unitPrice',
					mRender: function(data, type, row) {
						return '&#8377;' + data;
					}
				},
				{
					data: 'isActive',
					bSortable: false,
					mRender: function(data, type, row) {
						var str = '';
						str += '<label class="switch">';
						if(data == 'Y') {
							str += '<input type="checkbox" checked="checked" value="' + row.id + '" />';
						}
						else {
							str += '<input type="checkbox" value="' + row.id + '" />';
						}
						str += '<div class="slider"></div></label>';
						
						return str;
					}
				},
				{
					data: 'id',
					bSortable: false,
					mRender: function(data, type, row) {
						var str = '';
						str += '<a href="' + window.contextRoot + '/manage/' + data + '/product" class="btn btn-warning">';
						str += '<span class="glyphicon glyphicon-pencil"></span></a>';
						
						return str;
					}
				}
			],
			initComplete: function() {
				var api = this.api();
				api.$('.switch input[type="checkbox"]').on('change', function() {
					var checkbox = $(this);
					var checked = checkbox.prop('checked');
					var dialogMsg = (checked) ? 'You want to activate the product?' : 'You want to deactivate the product?';
					var value = checkbox.prop('value');
					bootbox.confirm({
						size: 'medium',
						title: 'Product Activation & Deactivation',
						message: dialogMsg,
						callback: function(confirmed) {
							if(confirmed) {
								console.log(value);
								var activationUrl = window.contextRoot + '/manage/product/' + value + '/activation';
								$.post(activationUrl, function(data) {
									bootbox.alert({
										size: 'medium',
										title: 'Information',
										message: data
									});
								});
								
							}
							else {
								checkbox.prop('checked', !checked)
							}
						}
					});
				});
			}
		});
	}
	
	// Category form validation
	var $categoryForm = $('#categoryForm');
	if($categoryForm.length) {
		$categoryForm.validate({
			rules: {
				name: {
					required: true,
					minlength: 2
				},
				description: {
					required: true
				}
			},
			message: {
				name: {
					required: 'Please add the category name!',
					minlength: 'The category name should not be less than 2 characters'
				},
				description: {
					required: 'Please add the category description!',
				}
			},
			errorElement: 'em',
			errorPlacement: function(error, element) {
				error.addClass('help-block');
				error.insertAfter(element);
			}
		});
	}
	
	
});