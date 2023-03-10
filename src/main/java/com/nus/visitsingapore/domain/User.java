package com.nus.visitsingapore.domain;

public class User {
    private int uid;
    private String username;
    private String password;
    private String email;
    private String telephone;
    private String birthday;
    private String gender;
    private String status;  // activation status
    private String code;  // activation code

    public User() {
    }

    public User(int uid, String username, String password, String email, String birthday, String gender, String status, String code) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.email = email;
        this.birthday = birthday;
        this.gender = gender;
        this.status = status;
        this.code = code;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
