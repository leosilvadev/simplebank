<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>

<div class="modal fade" id="modal-form" tabindex="-1" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<form id="form-user" method="post">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">User Information</h4>
				</div>
				<div class="modal-body">
					<div class="messages"></div>
					<label for="username">Username: </label>
					<input id="username" name="username" class="form-control">
					
					<label for="password">Password: </label>
					<input type="password" id="password" name="password" class="form-control" required>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button id="btn-save" type="button" class="btn btn-primary">Save</button>
				</div>
			</form>
		</div>
	</div>
</div>

<script>
	var save = function(){
		var data = $('form#form-user').serialize();
		$.post('', data)
			.success(function(){
				$('#modal-form').modal('hide');
				$.get('users/refresh')
					.success(function(view){
						$('#div-table-users').html(view);
					});
			})
			.fail(function(response) {
				$('.messages').append('<div class="alert alert-warning">'+response.responseText+'</div>');
			})
			.always(clean);
	};
	
	var clean = function(){
		$('form#form-user').trigger('reset');
	};

	$(document).ready(function(){
		$('#btn-save').on('click', save);
	});
</script>