package com.quizzyapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Category {
    @Id
    private int id;
    String name;


    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category() {
        super();
    }


    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return this.name;
    }
}
