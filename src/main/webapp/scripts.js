document.addEventListener('DOMContentLoaded', () => {
    loadFeaturedProducts();
    loadAllProducts();
    loadCartItems();
});

function loadFeaturedProducts() {
    const featuredProducts = [
        { id: 1, name: 'Pizza', price: 10.99 },
        { id: 2, name: 'Burger', price: 7.99 },
        { id: 3, name: 'Pasta', price: 8.99 }
    ];
    const featuredSection = document.getElementById('featured-products');
    featuredProducts.forEach(product => {
        const productDiv = document.createElement('div');
        productDiv.className = 'product';
        productDiv.innerHTML = `<h3>${product.name}</h3><p>$${product.price.toFixed(2)}</p><button onclick="addToCart(${product.id}, '${product.name}', ${product.price})">Add to Cart</button>`;
        featuredSection.appendChild(productDiv);
    });
}



function loadAllProducts() {
    fetch('http://localhost:8080/home/product/get')
        .then(response => {
           
            return response.json();
        })
        .then(products => {
            const allProductsSection = document.getElementById('all-products');
            allProductsSection.innerHTML = ''; // Clear existing content
            products.forEach(product => {
                const productDiv = document.createElement('div');
                productDiv.className = 'product';
                allProductsSection.innerHTML = "<h3>${product.productName}</h3>";
                
            });
        })
        ;
}


function addToCart(id, name, price) {
    const cart = JSON.parse(localStorage.getItem('cart')) || [];
    const existingItem = cart.find(item => item.id === id);
    if (existingItem) {
        existingItem.quantity += 1;
    } else {
        cart.push({ id, name, price, quantity: 1 });
    }
    localStorage.setItem('cart', JSON.stringify(cart));
    alert(`${name} added to cart`);
    loadCartItems();
}

function loadCartItems() {
    const cart = JSON.parse(localStorage.getItem('cart')) || [];
    const cartList = document.getElementById('cart-list');
    cartList.innerHTML = '';
    let total = 0;
    cart.forEach(item => {
        total += item.price * item.quantity;
        const cartItemDiv = document.createElement('div');
        cartItemDiv.className = 'cart-item';
        cartItemDiv.innerHTML = `<h3>${item.name}</h3><p>Quantity: ${item.quantity}</p><p>Price: $${(item.price * item.quantity).toFixed(2)}</p>`;
        cartList.appendChild(cartItemDiv);
    });
    document.getElementById('cart-total').textContent = total.toFixed(2);
}

function proceedToCheckout() {
    window.location.href = 'checkout.html';
}

function submitOrder(event) {
    event.preventDefault();
    const form = event.target;
    const order = {
        name: form.name.value,
        address: form.address.value,
        city: form.city.value,
        state: form.state.value,
        zip: form.zip.value,
        cart: JSON.parse(localStorage.getItem('cart')) || []
    };
    console.log('Order submitted:', order);
    localStorage.removeItem('cart');
    alert('Order submitted successfully!');
    window.location.href = 'index.html';
}
