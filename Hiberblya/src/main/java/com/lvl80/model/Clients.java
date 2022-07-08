package com.lvl80.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NamedEntityGraphs(
        @NamedEntityGraph(
                name = "Clients",
                attributeNodes = {
                        @NamedAttributeNode(value = "booksList")
                }
        )
)
@Entity
@Table(name = "Clients")
public class Clients implements Serializable {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Age")
    private int age;

    @OneToMany(mappedBy = "client",
                cascade = CascadeType.PERSIST)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Books> booksList = new ArrayList<>();

    public Clients() {
    }

    public List<Books> getBooksList() {
        return booksList;
    }

    public void setBooksList(List<Books> booksList) {
        this.booksList = booksList;
    }

    public Clients(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
