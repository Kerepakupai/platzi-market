package com.kerepakupai.platzimarket.producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.getProducts();
    }

    public Optional<Product> getProduct(int productId) {
        return productRepository.getProduct(productId);
    }

    public Optional<List<Product>> getProductsByCategory(int categoryId) {
        return productRepository.getProductsByCategory(categoryId);
    }

    public Product addNewProduct(Product product) {
        return productRepository.addNewProduct(product);
    }

    public boolean deleteProduct(int productId) {
        return getProduct(productId).map(product -> {
            productRepository.deleteProduct(productId);
            return true;
        }).orElse(false);

        /* Otra forma de validar
        if (getProduct(productId).isPresent()) {
            productRepository.deleteProduct(productId);
            return true;
        } else {
            return false;
        }*/
    }
}
