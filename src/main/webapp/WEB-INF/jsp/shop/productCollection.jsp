<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>


<section class="block product-collections">
    <div class="container">
        <header class="block__header--left">
            <h2 class="block__heading">Product Collection</h2>
        </header>
        <div class="grid grid--cols-2">
            <div class="product-collection__left-pane">
                <h2>Store</h2>
                <p>History</p>
                <p>Art</p>
                <p>Mathematics</p>
                <p>Literature</p>
                <p>Philosophy</p>
                <p>Theology</p>
                <p>Music</p>
                <p>Science</p>
                <p>Educational Goods</p>
            </div>
            <div class="product-collection__right-pane">
                <div class="grid grid--cols-3">
                    <c:forEach items="${products}" var="product">
                    <figure>
                        <a href="/shop/product/${product.id}">
                            <img src="https://picsum.photos/243/363"
                                 alt="Product"
                                 style="height: 363px; width: 243px;"
                            />
                            <figcaption>
                                <h5>${product.title}</h5>
                                <p>$${product.price}</p>
                            </figcaption>
                        </a>
                    </figure>
                    </c:forEach>

                </div>
            </div>
        </div>
    </div>
</section>



<jsp:include page="../include/footer.jsp"/>