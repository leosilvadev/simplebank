<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>

<style>
	@IMPORT url("${path}/static/css/user.css");
</style>

<div class="row options">
	<div class="col-sm-12">
		<button class="btn btn-primary" data-toggle="modal" data-target="#modal-form">
			<i class="glyphicon glyphicon-plus"></i> New User
		</button>
	</div>
</div>
<div id="div-table-users">
	<div class="messages"></div>
	<jsp:include page="table.jsp"/>
</div>

<jsp:include page="form.jsp"/>
<jsp:include page="alert-remove.jsp"/>

<script src="${path}/static/js/user.js"></script>