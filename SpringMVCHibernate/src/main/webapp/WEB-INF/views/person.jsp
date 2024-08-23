<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Person Page</title>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #fff;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #f0f0f0;
}

.tg .tg-4eph {
	background-color: #f9f9f9
}

.person-list {
	display: flex;
	flex-direction: column;
}

.person-header, .person-row {
	display: flex;
}

.person-header>div, .person-row>div {
	width: 80px; /* Adjust widths as needed */
	padding: 8px;
	border: 1px solid #ccc;
}

.person-header>.person-name, .person-row>.person-name, .person-header>.person-country,
	.person-row>.person-country {
	width: 120px; /* Adjust widths as needed */
}

.person-header>.person-edit, .person-row>.person-edit, .person-header>.person-delete,
	.person-row>.person-delete {
	width: 60px; /* Adjust widths as needed */
}
</style>
</head>
<body>
	<h1>Add a Person</h1>
	
	<p id="time"></p>
	<script>
		var date = new Date();
		document.getElementById("time").innerHTML = date;
	</script>

	<c:url var="addAction" value="/person/add"></c:url>

	<form:form action="${addAction}" commandName="person">
		<table>
			<c:if test="${!empty person.name}">
				<tr>
					<td><form:label path="id">
							<spring:message text="ID" />
						</form:label></td>
					<td><form:input path="id" readonly="true" size="8"
							disabled="true" /> <form:hidden path="id" /></td>
				</tr>
			</c:if>
			<tr>
				<td><form:label path="name">
						<spring:message text="Name" />
					</form:label></td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="country">
						<spring:message text="Country" />
					</form:label></td>
				<td><form:input path="country" /></td>
			</tr>
			<tr>
				<td><form:label path="age">
						<spring:message text="Age" />
					</form:label></td>
				<td><form:input path="age" /></td>
			</tr>
			<tr>
				<td colspan="2"><c:if test="${!empty person.name}">
						<input type="submit" value="<spring:message text="Edit Person"/>" />
					</c:if> <c:if test="${empty person.name}">
						<input type="submit" value="<spring:message text="Add Person"/>" />
					</c:if></td>
			</tr>
		</table>
	</form:form>
	<br>
	<h3>Persons List</h3>
	<c:if test="${!empty listPersons}">
		<div class="person-list">
			<div class="person-header">
				<div class="person-id">Person ID</div>
				<div class="person-name">Person Name</div>
				<div class="person-country">Person Country</div>
				<div class="person-age">Person Age</div>
				<div class="person-edit">Edit</div>
				<div class="person-delete">Delete</div>
			</div>
			<c:forEach items="${listPersons}" var="person">
				<div class="person-row">
					<div class="person-id">${person.id}</div>
					<div class="person-name">${person.name}</div>
					<div class="person-country">${person.country}</div>
					<div class="person-age">${person.age}</div>
					<div class="person-edit">
						<a href="<c:url value='/edit/${person.id}' />">Edit</a>
					</div>
					<div class="person-delete">
						<a href="<c:url value='/remove/${person.id}' />">Delete</a>
					</div>
				</div>
			</c:forEach>
		</div>
	</c:if>
</body>
</html>
