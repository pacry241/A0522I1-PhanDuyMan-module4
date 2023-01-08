package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ProductRepository implements IProductRepository {
    //sessionFactory: session kết nối đến database đọc cấu hình trong hibernate config
    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Product> findAll() {
        String queryStr = "Select s from Product as s";
        TypedQuery<Product> query = entityManager.createQuery(queryStr, Product.class);
        return query.getResultList();
    }

    @Override
    //không thể tự động, cần có transaction, hỗ trợ việc thêm mới,sửa, xóa
    public void create(Product product) throws Exception {
        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(Product product) throws Exception {
        entityManager.merge(product);
    }

    @Override
    public void delete(int id) throws Exception {
        entityManager.getTransaction().begin();
        entityManager.remove(findById(id));
        entityManager.getTransaction().commit();
    }

    @Override
    public Product findById(int id) throws Exception {
        return entityManager.find(Product.class, id);
    }

    @Override
    public List<Product> findByName(String nameSearch) {
        return null;
    }
}
