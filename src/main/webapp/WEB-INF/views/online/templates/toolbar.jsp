<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<div class="navbar navbar-static navbar-default navbar-fixed-top navbar-inverse">
	<div class="container-fluid">
		<div>
			<button type="button" class="navbar-toggle toggle-left hidden-md hidden-lg"
				data-toggle="sidebar" data-target=".sidebar-left">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">SimpleBank</a>
			<ul class="nav navbar-nav navbar-right">
				<li>
		          <a href="#" class="tool-button">
		          	<i class="glyphicon glyphicon-inbox"></i>
		          </a>
		        </li>
		         <li>
		          <a href="../app/logout" class="tool-button">
		          	<i class="glyphicon glyphicon-log-out"></i>
		          </a>
		        </li>
		     </ul>
		</div>
	</div>
</div>
