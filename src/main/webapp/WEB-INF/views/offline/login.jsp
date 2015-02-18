<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<section id="sec-login">
	<form action="authenticate" method="post">
		<label for="username">Username:</label>
		<input id="username" name="username" required class="form-control">
		
		<label for="password">Password:</label>
		<input id="password" name="password" type="password" required class="form-control">
		
		<button type="submit" class="btn btn-primary">LogIn</button>
	</form>
</section>

<style>
	#sec-login{
		width: 400px;
		margin-left: auto;
		margin-right: auto;
		padding: 50px;
	}
	
	#sec-login>form>input{
		margin-bottom: 10px;
	}
	
	#sec-login>form>button[type=submit]{
		width: 100%;
	}
</style>