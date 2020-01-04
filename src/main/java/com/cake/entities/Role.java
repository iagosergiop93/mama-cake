package com.cake.entities;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "user_roles")
@Entity
public class Role {

    @Id
    @Column(name = "id")
    private int id;

    @Column
    private String title;

    public Role() {

    }

    public Role(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id_user_role=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
