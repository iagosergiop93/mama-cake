package com.cake.entities;

import com.cake.dtos.UserDto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @JsonIgnore
    @Column(name = "passwd")
    private String passwd;

    @Column(name = "points")
    private long points;

    @ManyToOne(targetEntity = Role.class)
    @JoinColumn(name = "role_id", insertable = false, updatable = false)
    private Role role;

    @JsonIgnore
    @Column(name = "role_id", insertable = true, updatable = true)
    private int roleId;

    @Column(name = "_created_at")
    private Timestamp _createdAt;

    @Column(name = "_updated_at")
    private Timestamp _updatedAt;

    public User() {

    }

    public User(String firstName, String lastName, String email, String passwd) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.passwd = passwd;
    }

    public User(UserDto userDto) {
        this(userDto.getFirstName(), userDto.getLastName(), userDto.getEmail(), userDto.getPasswd());
    }

    public User(long id, String firstName, String lastName, String email, String passwd, long points, Role role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.passwd = passwd;
        this.points = points;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public long getPoints() { return points; }

    public void setPoints(long points) { this.points = points; }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public Timestamp get_createdAt() {
        return _createdAt;
    }

    public void set_createdAt(Timestamp _createdAt) {
        this._createdAt = _createdAt;
    }

    public Timestamp get_updatedAt() {
        return _updatedAt;
    }

    public void set_updatedAt(Timestamp _updatedAt) {
        this._updatedAt = _updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(email, user.email) &&
                Objects.equals(passwd, user.passwd) &&
                Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, passwd, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", passwd='" + passwd + '\'' +
                ", role=" + role +
                '}';
    }
}
