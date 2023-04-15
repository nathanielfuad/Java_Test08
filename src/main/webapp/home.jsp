<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <style><%@include file="/WEB-INF/static/style.css"%></style>
</head>

<body>
<nav class="navbar navbar-light bg-light justify-content-between">
    <span class="navbar-brand mb-0 h1"><b class="text-obs-color">OBS</b> University</span>
    <form class="form-inline" id="logout-form"  method="post" action="/logout">
        <button class="btn btn-outline-dark my-2 my-sm-0" type="submit">Logout</button>
    </form>
</nav>
<div class="m-3">
    <h4 class="h5 text-dark font-weight-bold mb-4">
        Welcome ${sessionScope.get("userId")}
    </h4>
    <table id="students-table" class="table table-bordered table-hover">
        <thead class="table-primary">
        <tr>
            <th class="text-center">Department</th>
            <th class="text-center">Student ID</th>
            <th class="text-center">Marks</th>
            <th class="text-center">Pass %</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach  var="department"  items="${departments}" varStatus="departmentLoop">
            <c:forEach  var="student"  items="${department.students}" varStatus="studentLoop">
                <tr>
                    <c:if test="${studentLoop.count==1}"><td rowspan="${department.students.size()}" class="table-center">${department.name}</td></c:if>
                    <td>
                        <a href="#my_modal" data-toggle="modal" data-target="#exampleModal" data-student-name="${student.name}">${student.studentId}</a>
                    </td>
                    <td style="text-align: right">${student.mark}</td>`
                    <c:if test="${studentLoop.count==1}"><td rowspan="${department.students.size()}" class="table-center"><fmt:formatNumber type="number" maxFractionDigits="2" value="${department.pass}"/></td></c:if>
                </tr>
            </c:forEach>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.6.4.js" integrity="sha256-a9jBBRygX1Bh5lt8GZjXDzyOB+bWve9EiO7tROUtj/E=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<script type="text/javascript"><%@include file="WEB-INF/static/js/home.js" %></script>

<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-body font-weight-bold"  id="student-name"></div>
        </div>
    </div>
</div>
</html>


