package controller;


import Services.ProductServices;
import Services.ProductServicesImpl;
import dao.ProductDao;
import dao.ProductDaoImpl;
import entity.Product;

import java.util.List;

public class ProductController {

    public List<Product>getAllProduct(){
        ProductServices productServices=new ProductServicesImpl();
        return productServices.getAllProduct();

    }
    public void createProduct(Product product){
        ProductDao productDao=new ProductDaoImpl();
        productDao.createProduct(product);
    }
    public void deleteProduct(Product product){
        ProductDao productDao=new ProductDaoImpl();
        productDao.deleteProduct(product);
    }
    public void updateProduct(Product product){
        ProductDao productDao=new ProductDaoImpl();
        productDao.updateProduct(product);
    }
    public void searchProduct(String name){
        ProductDao productDao=new ProductDaoImpl();
        productDao.searchProduct(name);
    }
}
