<section class="grid checkout" style="">
    <!-- TODO: Left Pane -->
    <div class="checkout__leftpane">
        <header class="block__header--left">
            <h3 class="block__heading">Shipping Address</h3>
        </header>
        <form action="" class="form">
            <div class="name-form-entry">
                <input type="text" placeholder="First name" />
                <input type="text" placeholder="Last name" />
            </div>

            <input type="text" placeholder="Name on Card" />
            <input type="text" placeholder="Credit Card Number" />

            <div class="location-form-entry">
                <input type="text" placeholder="Exp Month" />
                <input type="text" placeholder="Exp Year" />
                <input type="text" placeholder="CVV" />
            </div>


            <input type="text" placeholder="Phone" />



            <header class="block__header--left">
                <h3 class="block__heading">Shipping Options</h3>
            </header>

            <div class="shipping-form-entry">
                <label for="shipping">Standard Shipping</label>
                <input type="radio" id="shipping" name="shipping" value="Standard Shipping" />
                <label for="shipping">Priority Shipping</label>
                <input type="radio" id="shipping" name="shipping" value="Priority Shipping" />
            </div>



            <button class="btn">Continue to checkout</button>
            <a href="">Return to Cart</a>
        </form>
    </div>

    <!-- TODO: Right Pane -->

    <div class="checkout__rightpane">
        <div class="checkout__rightpane__products grid grid--cols-2">
            <img src="https://picsum.photos/100/150" alt="Produt" />
            <div class="checkout__rightpane__products__info">
                <p>Book Title</p>
                <p>$49.95</p>
            </div>
            <img src="https://picsum.photos/100/150" alt="Produt" />
            <div class="checkout__rightpane__products__info">
                <p>Book Title</p>
                <p>$49.95</p>
            </div>
            <img src="https://picsum.photos/100/150" alt="Produt" />
            <div class="checkout__rightpane__products__info">
                <p>Book Title</p>
                <p>$49.95</p>
            </div>
        </div>

        <div class="checkout__rightpane__order-summary-one">
            <div class="checkout__rightpane__order-summary__subtotal">
                <p>Subtotal</p>
                <p>$99.98</p>
            </div>
            <div class="checkout__rightpane__order-summary__shipping">
                <p>Shipping</p>
                <p>Calculated at next step</p>
            </div>
        </div>

        <div class="checkout__rightpane__order-summary-two">
            <div class="checkout__rightpane__order-summary__total">
                <p>Total</p>
                <p>$98.98</p>
            </div>
        </div>
    </div>
</section>