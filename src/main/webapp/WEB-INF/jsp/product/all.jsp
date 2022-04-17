<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>


<h1>Search</h1>

<table class="table">
    <tr>
        <th>Title</th>
        <th>Author</th>
    </tr>
    <c:forEach items="${products}" var="product">
        <tr scope="row">
            <td>${product.title}</td>
            <td>${product.author}</td>
            <td>
                <form action="/cart/addItem" method="post">
                    <input type="hidden" name="id" value="${product.id}">
                    <button>Add To Cart</button>
                </form>
            </td>
        </tr>
    </c:forEach>

</table>

<jsp:include page="../include/footer.jsp"/>

