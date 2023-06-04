package com.example.listenmusic.repository.impl;

import com.example.listenmusic.model.Music;
import com.example.listenmusic.repository.IMusicRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
    public List<Music> findAll() {
        String queryStr = "Select c from Music as c";
        TypedQuery<Music> query = entityManager.createQuery(queryStr, Music.class);
        return query.getResultList();
    }

    @Override
    public Music findOne(int id) {
        String queryStr = "SELECT c FROM Music AS c WHERE c.id = :id";
        TypedQuery<Music> query = entityManager.createQuery(queryStr, Music.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public Music save(Music music) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Music origin = findOne(music.getId());
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
    public List<Music> save(List<Music> music) {
        return null;
    }

    @Override
    public boolean exists(int id) {
        return false;
    }

    @Override
    public List<Music> findAll(List<Integer> ids) {
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
    public void delete(Music music) {

    }

    @Override
    public void delete(List<Music> music) {

    }

    @Override
    public void deleteAll() {

    }
}
