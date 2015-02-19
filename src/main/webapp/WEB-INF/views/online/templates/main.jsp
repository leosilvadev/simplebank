<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
	<c:set var="path" value="${pageContext.request.contextPath}" scope="request"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="${path}/static/libs/jquery-2.1.3.min.js"></script>
	<script src="${path}/static/libs/bootstrap/js/bootstrap.min.js"></script>
	<script src="${path}/static/libs/bootstrap/js/sidebar.js"></script>
	<style type="text/css">
		@IMPORT url("${path}/static/libs/bootstrap/css/bootstrap.min.css");
		@IMPORT url("${path}/static/libs/bootstrap/css/bootstrap-theme.min.css");
		@IMPORT url("${path}/static/libs/bootstrap/css/sidebar.css");
		@IMPORT url("${path}/static/css/online-template.css");
	</style>
</head>
	
<body>
  <header>
	<tiles:insertAttribute name="toolbar" />
  </header>
  
  <section>
		<div class="container-fluid">
			<div class="row">
				<div class="col-xs-5 col-sm-2 col-md-2 sidebar sidebar-left sidebar-animate sidebar-md-show">
					<tiles:insertAttribute name="menu" />
				</div>
				<div class="main col-md-10 col-md-offset-2">
					<tiles:insertAttribute name="content" />
				</div>
			</div>
		</div>
  </section>
</body>
</html>