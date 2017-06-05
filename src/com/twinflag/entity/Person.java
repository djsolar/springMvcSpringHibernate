package com.twinflag.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by zhouyiran on 2017/6/5.
 */
@Entity
@Table(name = "person")
public class Person {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GenericGenerator(name = "generator", strategy = "uuid")
    @GeneratedValue(generator = "generator")
    private String id;

    @Column(name = "name", nullable = false, length = 32)
    private String name;

    @Column(name = "idCard", nullable = false, length = 32)
    private String idCard;

    @Column(name = "phone", nullable = false, length = 32)
    private String phone;

    @Column(name = "address", nullable = false, length = 32)
    private String address;

    public Person() {
    }

    public Person(String name, String idCard, String phone, String address) {
        this.name = name;
        this.idCard = idCard;
        this.phone = phone;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", idCard='" + idCard + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
