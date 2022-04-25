<jsp:include page="../include/header.jsp"/>


<section class="block container product-page">
    <div class="breadcrumb">
        <a href="">Home /</a>
        <a href=""> Shop by Category /</a>
        <a href="">${product.title}</a>
    </div>

    <div class="grid grid--cols-2">
        <img
                src="${product.image}"
                class="product-page__product-image"
                alt="Product Image"
                style="width: 400px; height: 600px"
        />

        <article class="product-page__product-summary">
            <header class="block__header--left">
                <h2 class="block__heading">${product.title}</h2>
                <p>${product.publisher}</p>
                <p>${product.isbn10}</p>

                <h3>$${product.price}</h3>
            </header>

            <a href="/cart/addProduct/${product.id}"><button>Add to Cart</button></a>


            <p>
                ${product.description}
            </p>
        </article>
    </div>
</section>


<jsp:include page="../include/footer.jsp"/>