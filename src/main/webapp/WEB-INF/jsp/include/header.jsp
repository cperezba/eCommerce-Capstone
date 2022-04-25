<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>

    <link href="<c:url value="../../../pub/css/normalize.css
"/>" rel="stylesheet" type="text/css"/>
</head>

<link href="<c:url value="../../../pub/css/styles.css
"/>" rel="stylesheet" type="text/css"/>


</head>
<body>

<nav class="nav">

    <a href="/user/index">Getting Started</a>

    <a href="/shop/collections">Shop</a>

    <a href="/shop/collections">Community</a>

    <a href="/shop/collections">Support</a>

    <a href="/shop/collections">Donate</a>

    <sec:authorize access="hasAuthority('ADMIN')">
        <a href="/user/list">User List</a>
        <a href="/product/entry">Product Entry</a>
    </sec:authorize>

    <sec:authorize access="!isAuthenticated()">
        <a href="/login/login">Login</a>
    </sec:authorize>

    <sec:authorize access="isAuthenticated()">
        <a href="/login/logout">Logout</a>
        <sec:authentication property="principal.username"/>
    </sec:authorize>
</nav>
