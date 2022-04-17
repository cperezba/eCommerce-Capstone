<jsp:include page="../include/header.jsp"/>


<form action="/login/loginSubmit" method="post" style="display: grid; place-content: center">
    <label for="username">Username: </label>
    <input id="username" name="username">
    <label for="password">Password: </label>
    <input id="password" name="password">

    <button type="submit">Submit</button>
</form>

<jsp:include page="../include/footer.jsp"/>