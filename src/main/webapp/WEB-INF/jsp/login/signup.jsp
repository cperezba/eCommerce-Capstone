<jsp:include page="../include/header.jsp" />

<section class="block container sign-in-sign-up">
    <header class="block__header--left">
        <h2 class="block__heading">Create Account</h2>
    </header>

    <div class="sign-in-sign-up__form-entry">
        <form action="/login/loginSubmit" method="post" class="sign-in-sign-up">
            <label for="email">Email: </label>
            <input id="email" name="email" type="email"/>
            <label for="firstName">First Name: </label>
            <input id="firstName" name="firstName" type="text">
            <label for="lastName">Last Name: </label>
            <input id="lastName" name="lastName" type="text"/>
            <label for="password">Password: </label>
            <input id="password" name="password" type="password"/>
            <label for="confirmPassword">Confirm Password: </label>
            <input id="confirmPassword" name="confirmPassword" type="password" />

            <div class="prompt">
                <button class="btn" type="submit">Submit</button>
                <p>Returning Customer? <a href="/login/login">Sign in</a></p>
            </div>
        </form>
    </div>
</section>



<jsp:include page="../include/footer.jsp" />