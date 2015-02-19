<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>

<div class="modal fade" id="modal-remove" tabindex="-1" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<form id="form-user" method="post">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">Confirmation</h4>
				</div>
				<div class="modal-body">
					Are you sure you want do remove this User?
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">No, I am no</button>
					<button id="btn-remove" type="button" class="btn btn-primary">Yes, sure!</button>
				</div>
			</form>
		</div>
	</div>
</div>