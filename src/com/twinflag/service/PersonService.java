package com.twinflag.service;

import com.twinflag.dao.PersonDao;
import com.twinflag.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by zhouyiran on 2017/6/5.
 */
@Service
@Transactional
public class PersonService {

    @Autowired
    private PersonDao personDao;

    public Person getPersonById(String id) {
        return personDao.getPersonById(id);
    }

    public void addPerson(Person person) {
        personDao.addPerson(person);
    }

    public void updatePerson(Person person) {
        personDao.updatePerson(person);
    }

    public void deletePersonById(String id) {
        personDao.deletePersonById(id);
    }

    public List<Person> getPersons() {
        return personDao.getPersons();
    }
}
