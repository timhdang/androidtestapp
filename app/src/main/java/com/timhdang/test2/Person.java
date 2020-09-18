package com.timhdang.test2;

public class Person {
    private String firstname;
    private String lastname;
    private String email;
    private String phone;  // avoiding errors for now
    public Person()
    {
        this.firstname = "firstname";
        this.lastname = "lastname";
        this.email = "email";
        this.phone = "phone";
    }
    public Person(String firstname, String lastname, String email, String phone) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
    }
    public String getFirstname() {return firstname;}
    public String getLastname() {return lastname;}
    public String getEmail() {return email;}
    public String getPhone() {return phone;}
}
