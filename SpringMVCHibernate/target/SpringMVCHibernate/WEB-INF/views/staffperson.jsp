<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Staff Page</title>
<style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }
        .tg td, .tg th {
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
            background-color: #f0f0f0;
        }
    </style>
</head>
<body>

<h1>Staff List for Person: ${person.name}</h1>

    <c:if test="${!empty staffList}">
        <table class="tg">
            <thead>
                <tr>
                    <th>Staff ID</th>
                    <th>Staff Name</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${staffList}" var="staffHasPerson">
                    <tr>
                        <td>${staffHasPerson.staff.staff_id}</td>
                        <td>${staffHasPerson.staff.staff_name}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${empty staffList}">
        <p>No staff members associated with this person.</p>
    </c:if>

    <a href="<c:url value='/persons' />">Back to Persons List</a>

</body>
</html>