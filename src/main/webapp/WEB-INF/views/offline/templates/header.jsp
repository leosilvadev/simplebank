<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<header class="navbar navbar-static-top" id="top" role="banner">
	<div class="container">
		<div class="navbar-header">
			<button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target=".bs-navbar-collapse">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a href="../" class="navbar-brand">SimpleBank</a>
		</div>
		<nav class="collapse navbar-collapse bs-navbar-collapse">
			<ul class="nav navbar-nav">
				<li><a href="../pricing.jsp">Pricing</a></li>
				<li><a href="../register.jsp">Register</a></li>
				<li><a href="../about-us.jsp">About us</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="active">
					<a href="../components/">
						<span class="glyphicon glyphicon-user"> Login</span>
					</a>
				</li>
			</ul>
		</nav>
	</div>
</header>

<style>
	header.navbar {
		background-image: linear-gradient(to bottom,#A8B4CB 0,#838EAE 100%);
		border-bottom: 1px solid #7F879E;
		margin-bottom: 0px;
	}
	
	header.navbar a{
		color: white;
	}
	
	header.navbar li>a:HOVER{
		background-image: linear-gradient(to bottom,#A8B4CB 0,#838EAE 60%);
	}
	
	header.navbar li.active{
		background-image: linear-gradient(to bottom,#A8B4CB 0,#838EAE 60%);
	}
	
	.navbar-brand{
		font-size: 1.5em;
	}
	
	header.navbar .navbar-nav{
		font-size: 1.1em;
	}
</style>