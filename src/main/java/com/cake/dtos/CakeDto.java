package com.cake.dtos;

public class CakeDto {

    private String title;
    private String description1;
    private String description2;
    private Double price;
    private Byte availability;
    private String image;

    public CakeDto() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription1() {
        return description1;
    }

    public void setDescription1(String description1) {
        this.description1 = description1;
    }

    public String getDescription2() {
        return description2;
    }

    public void setDescription2(String description2) {
        this.description2 = description2;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Byte getAvailability() {
        return availability;
    }

    public void setAvailability(Byte availability) {
        this.availability = availability;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "CakeDto{" +
                "title='" + title + '\'' +
                ", description1='" + description1 + '\'' +
                ", description2='" + description2 + '\'' +
                ", price=" + price +
                ", availability=" + availability +
                ", image='" + image + '\'' +
                '}';
    }
}
