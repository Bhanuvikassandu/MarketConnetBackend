document.addEventListener("DOMContentLoaded", function() {
    fetch('http://localhost:8080/home/product/get')
        .then(response => response.json())
        .then(data => {
            const productList = document.getElementById('product-list');
            data.forEach(product => {
                const productDiv = document.createElement('div');
                productDiv.className = 'product';

                const productName = document.createElement('h2');
                productName.textContent = product.productName; // Assuming the product object has a name property
                productDiv.appendChild(productName);

                const productPrice = document.createElement('p');
                productPrice.textContent = `Price: $${product.price}`; // Assuming the product object has a price property
                productDiv.appendChild(productPrice);

                // Add more product details as needed
                // Example: description, image, etc.
                if (product.description) {
                    const productDescription = document.createElement('p');
                    productDescription.textContent = `Description: ${product.description}`;
                    productDiv.appendChild(productDescription);
                }

                productList.appendChild(productDiv);
            });
        })
        .catch(error => console.error('Error fetching products:', error));
});
