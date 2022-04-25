<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>


<h1>Search</h1>

<table class="table">
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
    </tr>
    <c:forEach items="${orderDetails}" var="orderDetails">
        <tr scope="row">
            <td>${orderDetails.userId}</td>
            <td>${orderDetails.productId}</td>
            <td>${orderDetails.quantity}</td>
        </tr>
    </c:forEach>

</table>

<jsp:include page="../include/footer.jsp"/>