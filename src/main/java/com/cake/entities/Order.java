package com.cake.entities;

import com.cake.dtos.OrderDto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private double value;

    @Column
    private String status;

    @OneToOne(targetEntity = Cake.class)
    @JoinColumn(name = "cake_id", insertable = false, updatable = false)
    private Cake cake;

    @Column(name = "cake_id", insertable = true, updatable = true)
    private long cakeId;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "_created_at")
    private Date _createdAt;

    @Column(name = "_updated_at")
    private Date _updatedAt;

    public Order() {

    }

    public Order(OrderDto orderDto) {
        this.cakeId = orderDto.getCakeId();
        this.value = orderDto.getValue();
        this.userId = orderDto.getUserId();
        this.status = "PENDING";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Cake getCake() {
        return cake;
    }

    public void setCake(Cake cake) {
        this.cake = cake;
    }

    public long getCakeId() {
        return cakeId;
    }

    public void setCakeId(long cakeId) {
        this.cakeId = cakeId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Date get_createdAt() {
        return _createdAt;
    }

    public void set_createdAt(Date _createdAt) {
        this._createdAt = _createdAt;
    }

    public Date get_updatedAt() {
        return _updatedAt;
    }

    public void set_updatedAt(Date _updatedAt) {
        this._updatedAt = _updatedAt;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", value=" + value +
                ", cakeId=" + cakeId +
                ", userId=" + userId +
                ", _createdAt=" + _createdAt +
                ", _updatedAt=" + _updatedAt +
                '}';
    }
}
