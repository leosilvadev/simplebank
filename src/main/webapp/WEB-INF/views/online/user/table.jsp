<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<table>
	<thead>
		<tr>
			<td style="width: 10%;" class="center">ID</td>
			<td style="width: 30%;">Username</td>
			<td style="width: 40%;">Roles</td>
			<td style="width: 10%;" class="center">Edit</td>
			<td style="width: 10%;" class="center">Delete</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${users}" var="item">
			<tr>
				<td class="center">${item.id}</td>
				<td>${item.username}</td>
				<td>
					<c:forEach var="role" items="${item.roles}">
						${role.name} 
					</c:forEach>
				</td>
				<td class="center">
					<a href="#"><i class="glyphicon glyphicon-pencil"></i></a>
				</td>
				<td class="center">
					<a href="#"><i class="glyphicon glyphicon-trash"></i></a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="5">Registered users: ${users.size()}</td>
		</tr>
	</tfoot>
</table>

<style>
	table{
		width: 100%;
	}
	
	table>thead>tr>td{
		background-image: linear-gradient(to bottom,#3c3c3c 0,#222 100%);
		padding: 5px;
		color: rgba(255, 255, 255, 0.88);
		font-size: 1.2em;
	}
	
	table>thead>tr>td:FIRST-CHILD{
		border-radius: 10px 0px 0px 0px;
	}
	
	table>thead>tr>td:LAST-CHILD{
		border-radius: 0px 10px 0px 0px;
	}
	
	table>tfoot>tr>td{
		background-color: rgba(239, 239, 239, 0.53);
		border-bottom: 1px solid rgba(0, 0, 0, 0.15);
		padding: 5px;
		text-align: right;
		font-size: 1.2em;
	}
	
	table>tbody>tr>td{
		padding: 5px;
		border-bottom: 1px solid rgba(0, 0, 0, 0.05);
	}
	
	table i.glyphicon{
		color: gray;
		font-size: 1.5em;
	}
	
	.center{
		text-align: center;
	}
</style>