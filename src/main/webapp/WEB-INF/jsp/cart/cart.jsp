<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>


<section class="block container">
    <header class="block__header--left">
        <h2 class="block__heading">Cart</h2>
    </header>


    <div class="grid grid--cols-2 cart">
        <section class="cart__products-pane">
            <header class="block__header--left">
                <h3 class="block__heading">Products</h3>
            </header>


            <div class="cart__product grid grid--cols-2">
                <c:forEach items="${cartProducts}" var="cartProducts">
                    <img class="product__image" loading="lazy" src="https://picsum.photos/200/300">
                    <article class="product__details">
                        <h4>${cartProducts.title}</h4>
                        <p>${cartProducts.price}</p>
                        <p>${cartProducts.quantity}</p>
                        <p>${cartProducts.total}</p>
                    </article>
                </c:forEach>
                <img class="product__image" loading="lazy" src="https://picsum.photos/200/300">
                <article class="product__details">
                    <h4>Book title</h4>
                    <p>Individual Product Price</p>
                    <p>Quantity</p>
                    <p>Remove</p>
                </article>
                <img class="product__image" loading="lazy" src="https://picsum.photos/200/300">
                <article class="product__details">
                    <h4>Book title</h4>
                    <p>Individual Product Price</p>
                    <p>Quantity</p>
                    <p>Remove</p>
                </article>

            </div>
        </section>

        <section class="cart__order-summary-pane" style="background-color: bisque;">
            <header class="block__header--left">
                <h3 class="block__heading">Order Summary</h3>
            </header>
            <p>Sub Total:</p>
            <p>Shipping:</p>
            <p>Tax:</p>
            <p>Total Price:</p>

            <a href="/checkout/info"><button class="btn">Proceed to Checkout</button></a>

        </section>
    </div>
</section>


<jsp:include page="../include/footer.jsp"/>
