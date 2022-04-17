<jsp:include page="../include/header.jsp"/>

<form action="/product/entrySubmit" method="post">
    <%--    <input type="hidden" name="id">--%>

    <div style="display: flex">
        <div style="display: flex; flex-direction: column; justify-content: space-between">
            <label for="title">Title</label>
            <label for="author">Author</label>
            <label for="description">Description</label>
            <label for="image">Image URL</label>
            <label for="publisher">Publisher</label>
            <label for="isbn10">ISBN-10</label>
            <label for="isbn13">ISBN-13</label>
            <label for="price">Price</label>
            <label for="discount">Discount</label>
            <label for="status">Status</label>
            <label for="quantity">Quantity Available </label>
            <label for="condition">Condition</label>
        </div>

        <div style="display: flex; flex-direction: column">
            <input type="hidden" name="id" value="${form.id}" />
            <input name="title" id="title" type="text" value="${form.title}"/>
            <input name="author" id="author" type="text" value="${form.author}"/>
            <input name="description" id="description" type="text" value="${form.description}"/>
            <input name="image" id="image" type="text" value="${form.image}"/>
            <input name="publisher" id="publisher" type="text" value="${form.publisher}"/>
            <input name="isbn10" id="isbn10" type="number" value="${form.isbn10}"/>
            <input name="isbn13" id="isbn13" type="number" value="${form.isbn13}"/>
            <input name="price" id="price" type="number" value="${form.price}"/>
            <input name="discount" id="discount" type="number" value="${form.discount}"/>
            <input name="status" id="status" type="text" value="${form.status}"/>
            <input name="quantity" id="quantity" type="number" value="${form.quantity}"/>
            <input name="condition" id="condition" type="text" value="${form.itemCondition}">
        </div>
    </div>

    <button class="btn btn-primary">Submit</button>
</form>


<jsp:include page="../include/footer.jsp"/>