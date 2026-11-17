
package com.example.productmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productmanagement.entity.Product;
import com.example.productmanagement.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Add Product
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    // Get All Products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Get Product By ID
    public Product getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    // Update Product
    public Product updateProduct(int id, Product product) {

        Product existingProduct = productRepository.findById(id).orElse(null);

        if (existingProduct != null) {

            existingProduct.setProductName(product.getProductName());
            existingProduct.setProductPrice(product.getProductPrice());
            existingProduct.setProductQuantity(product.getProductQuantity());
            existingProduct.setProductCategory(product.getProductCategory());
            existingProduct.setProductDescription(product.getProductDescription());

            return productRepository.save(existingProduct);
        }

        return null;
    }

    // Delete Product
    public boolean deleteProduct(int id) {

        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }

        return false;
    }
}
