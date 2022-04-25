<jsp:include page="../include/header.jsp"/>

<form action="/order/entrySubmit" method="post" style="display: flex">
    <div style="display: flex; flex-direction: column; justify-content: space-between">
        <label for="subTotal">Sub-Total: </label>
        <label for="total">Total: </label>
        <label for="paymentType">Payment Type: </label>
        <label for="cardName">Card Name: </label>
        <label for="cardNumber">Card Number: </label>
        <label for="cardExpirationDate">Expiration Date: </label>
        <label for="cvsCode">CVS Code: </label>
    </div>

    <div style="display: flex; flex-direction: column">
        <input name="id" id="id" type="hidden">
        <input name="subTotal" id="subTotal" type="text"/>
        <input name="total" id="total" type="text"/>
        <input name="paymentType" id="paymentType" type="text"/>
        <input name="cardName" id="cardName" type="text"/>
        <input name="cardNumber" id="cardNumber" type="text"/>
        <input name="cardExpirationDate" id="cardExpirationDate" type="text"/>
        <input name="cvsCode" id="cvsCode" type="text"/>
    </div>

    <button type="submit">Submit</button>
</form>

<jsp:include page="../include/footer.jsp"/>