<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>

<div class="row options">
	<div class="col-sm-12">
		<button class="btn btn-primary" data-toggle="modal" data-target="#modal-form">
			<i class="glyphicon glyphicon-plus"></i> New User
		</button>
	</div>
</div>
<div id="div-table-users">
	<jsp:include page="table.jsp"/>
</div>

<jsp:include page="form.jsp"/>

<style>
	.options{
		margin-top: 5px;
		margin-bottom: 5px;
		text-align: right;
	}
	
	.modal-header{
		color: white;
		background-image: linear-gradient(to bottom,#3c3c3c 0,#222 100%);
	}
</style>