package com.example.blogweb.repository.impl;

import com.example.blogweb.model.Blog;
import com.example.blogweb.model.Category;
import com.example.blogweb.repository.ICategoryRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
@Transactional
@Repository
public class CategoryRepositoryImpl implements ICategoryRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Category> findAll() {
        String querrry = "SELECT c from Category as c";
        TypedQuery<Category> query=entityManager.createQuery(querrry, Category.class);
        return query.getResultList();
    }

    @Override
    public void save(Category category) {
        entityManager.persist(category);
    }

    @Override
    public Category findById(int id) {
        return entityManager.find(Category.class,id);
    }

    @Override
    public void update(Category category) {
        entityManager.merge(category);
    }

    @Override
    public void delete(Category category) {
        entityManager.remove(entityManager.find(Category.class,category.getId()));
    }
}
