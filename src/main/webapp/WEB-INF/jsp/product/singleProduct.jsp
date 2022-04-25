<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>


<div class="card">
    <header class="card__header">
        <img
                style="height: 16vh; width: 10vw;"
                src="${product.image}"
        />
    </header>

    <div class="card__body">
        <span class="card__product-title">${product.title}</span>
        <span class="card__product-price">${product.price}</span>
    </div>
<form action="/cart/addProduct/${product.id}" method="get">
    <button>Add to Cart</button>
</form>
</div>



<jsp:include page="../include/footer.jsp"/>