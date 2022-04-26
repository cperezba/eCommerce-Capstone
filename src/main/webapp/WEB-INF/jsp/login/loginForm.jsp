<jsp:include page="../include/header.jsp"/>


<section class="block container sign-in-sign-up">
    <header class="block__header--left">
        <h2 class="block__heading">Customer Login</h2>
    </header>

    <div class="sign-in-sign-up__form-entry">
        <form action="/login/loginSubmit" method="post" class="sign-in-sign-up">
            <label for="username">Email: </label>
            <input id="username" name="username" type="text" />

            <label for="password">Password: </label>
            <input id="password" name="password" type="password" />
            <div class="show-password">
                <input
                        type="checkbox"
                        id="password-toggle"
                        onclick="togglePasswordVisibility()"
                />
                <label for="password-toggle">Show Password</label>
            </div>

            <div class="prompt">
                <button class="btn" type="submit">Submit</button>
                <p>New Customer? <a href="">Sign up</a></p>
            </div>
        </form>
    </div>
</section>


<script>
    function togglePasswordVisibility() {
        var inputElement = document.getElementById("password");
        if (inputElement.type === "password") {
            inputElement.type = "text";
        } else {
            inputElement.type = "password";
        }
    }
</script>

<jsp:include page="../include/footer.jsp"/>