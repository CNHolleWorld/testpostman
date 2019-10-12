package com.makai.model;

import org.springframework.stereotype.Component;

/* * *
 *  @Name: User
 *  @User: 马凯
 *  @Date: 2019/10/9
 *  @Remark:
 * * */
@Component
public class User {

    private int id;
    private String name;
    private String user;
    private String pwad;

    public User() {
    }

    public User(int id, String name, String user, String pwad) {
        this.id = id;
        this.name = name;
        this.user = user;
        this.pwad = pwad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwad() {
        return pwad;
    }

    public void setPwad(String pwad) {
        this.pwad = pwad;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", user='" + user + '\'' +
                ", pwad='" + pwad + '\'' +
                '}';
    }
}
