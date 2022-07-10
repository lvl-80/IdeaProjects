package com.lvl80.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Books")
public class Books implements Serializable {
    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    private long Id;

    @Column(name = "Title")
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Clients_id")
    private Clients client;

    public Books() {
    }

    public Books(Clients client, String title) {
        this.title = title;
        this.client = client;
    }

    public Clients getClient() {
        return client;
    }

    public void setClient(Clients client) {
        this.client = client;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Books{" +
                "Id=" + Id +
                ", title='" + title + '\'' +
                ", client=" + client +
                '}';
    }
}
