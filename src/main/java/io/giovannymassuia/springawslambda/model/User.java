package io.giovannymassuia.springawslambda.model;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {

    private String id;
    private String name;
    private boolean admin;

    public User() {
    }

    public User(String id, String name, boolean admin) {
        this.id = id;
        this.name = name;
        this.admin = admin;
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

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
