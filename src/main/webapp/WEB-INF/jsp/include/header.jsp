<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
</head>
<body>

<div class="container">

    <a href="/index">Index</a> |
    <a href="/user/entry">Sign Up</a> |

    <sec:authorize access="hasAuthority('ADMIN')">
    <a href="/user/list">User List</a> |
    <a href="/product/entry">Product Entry</a> |
    </sec:authorize>

    <a href="/product/list">Product List</a> |


    <sec:authorize access="!isAuthenticated()">
    <a href="/login/login">Login</a>
    </sec:authorize>

    <sec:authorize access="isAuthenticated()">
    <a href="/login/logout">Logout</a>
        &nbsp; | &nbsp; <sec:authentication property="principal.username"/>
    </sec:authorize>

    <hr>