package com.cake.dtos;

public class OrderDto {

    private double value;
    private long cakeId;
    private long userId;

    public OrderDto() {

    }

    public OrderDto(double value, long cakeId, long userId) {
        this.value = value;
        this.cakeId = cakeId;
        this.userId = userId;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
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

    @Override
    public String toString() {
        return "OrderDto{" +
                "value=" + value +
                ", cakeId=" + cakeId +
                ", userId=" + userId +
                '}';
    }
}
