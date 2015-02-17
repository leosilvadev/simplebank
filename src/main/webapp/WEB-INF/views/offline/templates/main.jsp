<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
	<c:set var="path" value="${pageContext.request.contextPath}"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="${path}/static/libs/jquery-2.1.3.min.js"></script>
	<script src="${path}/static/libs/bootstrap/js/bootstrap.min.js"></script>
	<style type="text/css">
		@IMPORT url("${path}/static/libs/bootstrap/css/bootstrap.min.css");
		@IMPORT url("${path}/static/libs/bootstrap/css/bootstrap-theme.min.css");
	</style>
</head>
<body>
	<header>
		<tiles:insertAttribute name="header" />
	</header>
	<section>
		<tiles:insertAttribute name="content" />
	</section>
	<footer>
		<tiles:insertAttribute name="footer" />
	</footer>
</body>
</html>