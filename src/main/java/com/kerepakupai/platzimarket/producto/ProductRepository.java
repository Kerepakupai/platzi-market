package com.kerepakupai.platzimarket.producto;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> getProducts();
    Optional<List<Product>> getProductsByCategory(int categoryId);
    Optional<List<Product>> getScarceProducts(int quantity);
    Optional<Product> getProduct(int productId);
    Product addNewProduct(Product product);
    void deleteProduct(int productId);
}
