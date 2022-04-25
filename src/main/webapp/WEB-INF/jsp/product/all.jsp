<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>


<h1>Search</h1>

<section class="grid grid--cols-3">
<c:forEach items="${products}" var="product">
<a href="/product/${product.id}">
    <div class="card">
        <header class="card__header">
            <img
                    src="${product.image}"
            />
        </header>

        <div class="card__body">
            <span class="card__product-title">${product.title}</span>
            <span class="card__product-price">${product.price}</span>
        </div>
    </div>
</a>
</c:forEach>
</section>

<%--        <tr scope="row">--%>
<%--            <td>${product.title}</td>--%>
<%--            <td>${product.author}</td>--%>
<%--            <td>--%>
<%--                <form action="/cart/addItem" method="post">--%>
<%--                    <input type="hidden" name="id" value="${product.id}">--%>
<%--                    <button>Add To Cart</button>--%>
<%--                </form>--%>
<%--            </td>--%>
<%--        </tr>--%>


<jsp:include page="../include/footer.jsp"/>

