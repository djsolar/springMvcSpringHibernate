package com.twinflag.dao;

import com.twinflag.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhouyiran on 2017/6/5.
 */
@Repository
public class PersonDao {

    @Resource
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public Person getPersonById(String id) {
        return (Person) getSession().createQuery("from Person where id = ?").setParameter(0, id).uniqueResult();
    }

    public void addPerson(Person person) {
        getSession().save(person);
    }

    public void updatePerson(Person person) {
        getSession().update(person);
    }

    public void deletePersonById(String id) {
        getSession().createQuery("delete Person where id = ?").setParameter(0, id).executeUpdate();
    }

    public List<Person> getPersons() {
        return getSession().createCriteria(Person.class).list();
    }
}
