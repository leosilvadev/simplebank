var save = function() {
	var data = $('form#form-user').serialize();
	$.post('', data).success(function() {
		$('#modal-form').modal('hide');
		$.get('users/refresh').success(function(view) {
			$('#div-table-users').html(view);
			applyListeners();
		});
	}).fail(function(response) {
		$('.modal-messages').append('<div class="alert alert-warning">' + response.responseText + '</div>');
	
	}).always(clean);
};

var edit = function() {
	var id = $(this).data('id');
	$.get('users/' + id).success(function(user) {
		$('#id').val(user.id);
		$('#username').val(user.username);
		
	}).always(function() {
		$('#modal-form').modal('show');
		
	});
};

var remove = function(){
	var id = $(this).data('id');
	
	$.ajax({
	    url: 'users/'+id,
	    type: 'DELETE',
	    success: function(){
			$.get('users/refresh').success(function(view) {
				$('#div-table-users').html(view);
				applyListeners();
			});
			
		},fail: function(){
			$('.messages').append('<div class="alert alert-warning">' + response.responseText + '</div>');
			
		},complete: function(){
			$('#modal-remove').modal('hide');
		}
	});
};

var confirmRemove = function(){
	var id = $(this).data('id');
	$('#modal-remove').modal('show');
	$('#btn-remove').data('id', id);
};

var clean = function() {
	$('form#form-user').trigger('reset');
	$('.messages').html('');
};

var applyListeners = function() {
	$('#btn-save').on('click', save);
	$('.btn-edit').on('click', edit);
	$('.btn-remove').on('click', confirmRemove);
	$('#btn-remove').on('click', remove);
};

$(document).ready(applyListeners);