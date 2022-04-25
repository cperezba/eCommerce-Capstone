<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>


<h1>Search</h1>

<table class="table">
    <tr>
        <th>User ID</th>
        <th>Payment Type</th>
        <th>Total</th>
    </tr>
    <c:forEach items="${order}" var="order">
        <tr scope="row">
            <td>${order.id}</td>
            <td>${order.paymentType}</td>
            <td>${order.total}</td>
        </tr>
    </c:forEach>

</table>

<jsp:include page="../include/footer.jsp"/>