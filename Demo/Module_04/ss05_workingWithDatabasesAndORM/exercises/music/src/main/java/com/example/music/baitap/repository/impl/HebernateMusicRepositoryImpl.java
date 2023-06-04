package com.example.music.baitap.repository.impl;

import com.example.music.baitap.repository.IMusicRepository;
import com.example.music.model.Music;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class HebernateMusicRepositoryImpl implements IMusicRepository {
    private static SessionFactory sessionFactory;
    @PersistenceContext
    private static EntityManager entityManager;
    @Override
    public List<com.example.music.baitap.model.Music> findAll() {
        String queryStr = "Select c from Music as c";
        TypedQuery<com.example.music.baitap.model.Music> query = entityManager.createQuery(queryStr, com.example.music.baitap.model.Music.class);
        return query.getResultList();
    }

    @Override
    public com.example.music.baitap.model.Music findOne(int id) {
        String queryStr = "SELECT c FROM Music AS c WHERE c.id = :id";
        TypedQuery<com.example.music.baitap.model.Music> query = entityManager.createQuery(queryStr, com.example.music.baitap.model.Music.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public com.example.music.baitap.model.Music save(com.example.music.baitap.model.Music music) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            com.example.music.baitap.model.Music origin = findOne(music.getId());
            origin.setName(music.getName());
            origin.setSinger(music.getSinger());
            origin.setGenre(music.getGenre());
            origin.setUrl(music.getUrl());
            session.saveOrUpdate(origin);
            transaction.commit();
            return origin;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public List<com.example.music.baitap.model.Music> save(List<com.example.music.baitap.model.Music> music) {
        return null;
    }

    @Override
    public boolean exists(int id) {
        return false;
    }

    @Override
    public List<com.example.music.baitap.model.Music> findAll(List<Integer> ids) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void delete(com.example.music.baitap.model.Music music) {

    }

    @Override
    public void delete(List<com.example.music.baitap.model.Music> music) {

    }

    @Override
    public void deleteAll() {

    }
}
