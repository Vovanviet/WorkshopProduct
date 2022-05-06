package dao;

import entity.Product;

import java.util.List;

public interface ProductDao {
    List<Product> getAllProduct();
    void createProduct(Product product);
    void searchProduct(String name);
    void deleteProduct(Product product);
    void updateProduct(Product product);
}
