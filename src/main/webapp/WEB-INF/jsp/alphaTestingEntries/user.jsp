<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>


<form action="/user/entrySubmit" method="post" style="display: flex">
    <div style="display: flex; flex-direction: column; justify-content: space-between">
        <label for="email">Email: </label>
        <label for="password">Password: </label>
        <label for="confirmPassword">Confirm Password: </label>
        <label for="firstName">First Name: </label>
        <label for="lastName">Last Name: </label>
        <label for="dateOfBirth">Date of Birth: </label>
        <label for="addressOne">Address: </label>
        <label for="addressTwo">Address: </label>
        <label for="aptNumber">Apt Number: </label>
        <label for="state">State: </label>
        <label for="zipCode">Zip Code: </label>
    </div>

    <div style="display: flex; flex-direction: column">
        <input name="id" id="id" type="hidden"/>
        <input name="email" id="email" type="text"/>
        <c:forEach items='${bindingResult.getFieldErrors("email")}' var="error">
            <div style="color:red;">${error.getDefaultMessage()}</div>
        </c:forEach>
        <input name="password" id="password" type="text"/>
        <input name="confirmPassword" id="confirmPassword" type="text"/>
        <input name="firstName" id="firstName" type="text"/>
        <c:forEach items='${bindingResult.getFieldErrors("firstName")}' var="error">
            <div style="color:red;">${error.getDefaultMessage()}</div>
        </c:forEach>
        <input name="lastName" id="lastName" type="text"/>
        <c:forEach items='${bindingResult.getFieldErrors("lastName")}' var="error">
            <div style="color:red;">${error.getDefaultMessage()}</div>
        </c:forEach>
        <input name="dateOfBirth" id="dateOfBirth" type="text"/>
        <c:forEach items='${bindingResult.getFieldErrors("password")}' var="error">
            <div style="color:red;">${error.getDefaultMessage()}</div>
        </c:forEach>
        <input name="addressOne" id="addressOne" type="text"/>
        <input name="addressTwo" id="addressTwo" type="text"/>
        <input name="aptNumber" id="aptNumber" type="text"/>
        <input name="state" id="state" type="text"/>
        <input name="zipCode" id="zipCode" type="number"/>
    </div>


    <button type="submit">Submit</button>
</form>


Email <input type="text" name="email" id="emailId" value="${form.email}">
<c:forEach items='${bindingResult.getFieldErrors("email")}' var="error">
    <div style="color:red;">${error.getDefaultMessage()}</div>
</c:forEach>
<br>
First Name <input type="text" name="firstName" id="firstNameId" value="${form.firstName}">
<c:forEach items='${bindingResult.getFieldErrors("firstName")}' var="error">
    <div style="color:red;">${error.getDefaultMessage()}</div>
</c:forEach>
<br>
Last Name <input type="text" name="lastName" id="lastNameId" value="${form.lastName}">
<c:forEach items='${bindingResult.getFieldErrors("lastName")}' var="error">
    <div style="color:red;">${error.getDefaultMessage()}</div>
</c:forEach>
<br>
Password <input type="text" name="password" id="passwordId"  value="${form.password}">
<c:forEach items='${bindingResult.getFieldErrors("password")}' var="error">
    <div style="color:red;">${error.getDefaultMessage()}</div>
</c:forEach>
<br>
Confirm Password <input type="text"
                        name="confirmPassword" id="confirmPasswordId"  value="${form.confirmPassword}">
<c:forEach items='${bindingResult.getFieldErrors("confirmPassword")}' var="error">
    <div style="color:red;">${error.getDefaultMessage()}</div>
</c:forEach>
<%--<c:if test="${bindingResult.hasErrors()}">--%>
<%--    <c:forEach items="${bindingResult.getAllErrors()}" var="error">--%>
<%--        <div style="color:red;">${error.getDefaultMessage()}</div>--%>
<%--    </c:forEach>--%>
<%--</c:if>--%>

<jsp:include page="../include/footer.jsp"/>