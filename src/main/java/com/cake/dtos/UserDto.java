package com.cake.dtos;

public class UserDto {

    private String firstName;
    private String lastName;
    private String email;
    private String passwd;

    public UserDto(String firstName, String lastName, String email, String passwd) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.passwd = passwd;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", passwd='" + passwd + '\'' +
                '}';
    }
}
