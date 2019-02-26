package com.example.testsqlite.model;

public class FriendData {

    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String description;

    public FriendData(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public FriendData(int id,String firstName,String lastName,String tel,String email,String description){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = tel;
        this.email = email;
        this.description = description;

    }

}
