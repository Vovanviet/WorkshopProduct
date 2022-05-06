package dao;

import entity.Product;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ProductDaoImpl implements ProductDao{
    @Override
    public List<Product> getAllProduct() {
        Session session= HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            List<Product>list=session.createQuery("from Product ").getResultList();
            session.getTransaction().commit();
            System.out.println(list);
            return list;
        } catch (Exception e) {

            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return null;

    }

    @Override
    public void createProduct(Product product) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
            System.out.println("Create Product to database success!");
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    @Override
    public void searchProduct(String name) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query<Product> products=session.createQuery("from Product where proName=:p_name");
            products.setParameter("p_name",name);
            List<Product> products1=products.getResultList();
            System.out.println(products1);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    @Override
    public void deleteProduct(Product product) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(product);
            session.getTransaction().commit();
            System.out.println("Delete success");
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    @Override
    public void updateProduct(Product product) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(product);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
}
