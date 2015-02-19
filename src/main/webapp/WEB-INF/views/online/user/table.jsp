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
					<a href="#" class="btn-edit" data-id="${item.id}"><i class="glyphicon glyphicon-pencil"></i></a>
				</td>
				<td class="center">
					<a href="#" class="btn-remove" data-id="${item.id}"><i class="glyphicon glyphicon-trash"></i></a>
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