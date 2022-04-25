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
        <input name="password" id="password" type="text"/>
        <input name="confirmPassword" id="confirmPassword" type="text"/>
        <input name="firstName" id="firstName" type="text"/>
        <input name="lastName" id="lastName" type="text"/>
        <input name="dateOfBirth" id="dateOfBirth" type="text"/>
        <input name="addressOne" id="addressOne" type="text"/>
        <input name="addressTwo" id="addressTwo" type="text"/>
        <input name="aptNumber" id="aptNumber" type="text"/>
        <input name="state" id="state" type="text"/>
        <input name="zipCode" id="zipCode" type="number"/>
    </div>


    <button type="submit">Submit</button>
</form>


<jsp:include page="../include/footer.jsp"/>