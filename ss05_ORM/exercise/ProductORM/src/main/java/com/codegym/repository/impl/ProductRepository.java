package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
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
    public void create(Product product) throws Exception {
        entityManager.persist(product);
    }

    @Override
    public void update(Product product) throws Exception {
        entityManager.merge(product);
    }

    @Override
    public void delete(int id) throws Exception {
        entityManager.remove(findById(id));
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
