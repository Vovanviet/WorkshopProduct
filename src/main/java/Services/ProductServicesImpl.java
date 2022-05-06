package Services;

import dao.ProductDao;
import dao.ProductDaoImpl;
import entity.Product;

import java.util.List;

public class ProductServicesImpl implements ProductServices{
    @Override
    public List<Product> getAllProduct() {
        ProductDao productDao=new ProductDaoImpl();
        return productDao.getAllProduct();
    }

    @Override
    public void createProduct() {

    }

    @Override
    public void searchProduct() {

    }

    @Override
    public void deleteProduct() {

    }

    @Override
    public void updateProduct() {

    }
}
