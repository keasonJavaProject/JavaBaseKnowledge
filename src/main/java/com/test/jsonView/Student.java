package com.test.jsonView;

import com.fasterxml.jackson.annotation.JsonView;

public class Student {
    public interface WithoutPasswordView {};
    public interface WithPasswordView extends WithoutPasswordView {};

    public Student(Integer id, String name, String account, String password) {
        this.id = id;
        this.name = name;
        this.account = account;
        this.password = password;
    }

    private Integer id;
    private String name;
    private String account;
    private String password;

    @JsonView(WithoutPasswordView.class)
    public String getAccount() {
        return account;
    }

    @JsonView(WithPasswordView.class)
    public String getPassword() {
        return this.password;
    }

    @JsonView(WithoutPasswordView.class)
    public Integer getId() {
        return id;
    }

    @JsonView(WithoutPasswordView.class)
    public String getName() {
        return name;
    }
}
