package com.onethread.cms.model;

import javax.persistence.Column;

public class UserDto {

    private Long id;
    private String fullName;
    private String email;
    private String password;
    private String phone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User getUserFromDto(){
        User user = new User();
        user.setFullName(fullName);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);

        return user;
    }
}
