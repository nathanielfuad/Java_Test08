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
<div class="vh-100 vw-100 d-flex flex-column justify-content-center">
    <div class="row justify-content-center">
        <div class="my-5">
            <div class="card-body p-0">
                <div class="row text-center">
                    <div class="p-5">
                        <div class="text-center">
                            <h4 class="h4 text-dark font-weight-bold mb-4">Welcome to <span
                                    class="h4 text-obs-color font-weight-bold">OBS University</span></h4>
                        </div>
                        <form id="login-form" method="post" action="/login">
                            <div class="form-group">
                                <input id="userId" name="userId" type="text"
                                       class="form-control form-control-user"
                                       placeholder="Enter Your User ID"
                                       autocomplete="none">
                            </div>
                            <div class="form-group">
                                <input id="password" name="password" type="password"
                                       class="form-control form-control-user"
                                       placeholder="Enter Your Password">
                            </div>
                            <p id="error-message" class="text-danger" >${error}</p>
                            <button id="login-btn" type="submit"
                                    class="btn btn-primary btn-user btn-block font-weight-bold">
                                Login
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
<script src="https://code.jquery.com/jquery-3.6.4.js" integrity="sha256-a9jBBRygX1Bh5lt8GZjXDzyOB+bWve9EiO7tROUtj/E=" crossorigin="anonymous"></script>
<script type="text/javascript"><%@include file="WEB-INF/static/js/login.js" %></script>
</html>
