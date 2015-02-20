var components = {
	$form: function(){
		return $('form#form-user');
	},
	$divUsers: function(){
		return $('#div-table-users');
	},
	$modalUser: function(){
		return $('#modal-form');
	},
	$modalRemove: function(){
		return $('#modal-remove');
	},
	$btnConfirmRemove: function(){
		return $('#btn-remove');
	},
	$btnsRemove: function(){
		return $('.btn-remove');
	},
	$messages: function(){
		return $('.messages');
	},
	$modalMessages: function(){
		return $('.modal-messages');
	}
};

var listUsers = function(){
	$.get('users/refresh').success(function(view) {
		components.$divUsers().html(view);
		applyListeners();
	});
};

var addModalMessage = function($component, message){
	$component.html('');
	$component.append('<div class="alert alert-warning">' + message + '</div>');
}

var save = function() {
	var data = components.$form().serialize();
	$.post('', data).success(function(){
			listUsers();
			components.$modalUser().modal('hide');
		})
		.fail(function(response) {
			addModalMessage(components.$modalMessages(), response.responseText);
		}).always(cleanModal);
};

var edit = function() {
	var id = $(this).data('id');
	$.get('users/' + id).success(function(user) {
		$('#id').val(user.id);
		$('#username').val(user.username);
		
	}).always(function() {
		components.$modalUser().modal('show');
		
	});
};

var remove = function(){
	var id = $(this).data('id');
	
	$.ajax({
	    url: 'users/'+id,
	    type: 'DELETE',
	    success: listUsers,	
		fail: function(response){
			addModalMessage(components.$messages(), response.responseText);
			
		},complete: function(){
			components.$modalRemove().modal('hide');
		}
	});
};

var confirmRemove = function(){
	var id = $(this).data('id');
	components.$modalRemove().modal('show');
	components.$btnConfirmRemove().data('id', id);
};

var cleanModal = function() {
	components.$form().trigger('reset');
	components.$messages().html('');
};

var applyListeners = function() {
	$('#btn-save').on('click', save);
	$('.btn-edit').on('click', edit);
	components.$btnsRemove().on('click', confirmRemove);
	components.$btnConfirmRemove().on('click', remove);
	components.$modalUser().on('show.bs.modal', cleanModal);
};

$(document).ready(applyListeners);