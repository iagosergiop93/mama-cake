package com.cake.entities;

import com.cake.dtos.CakeDto;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "cakes")
public class Cake {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String title;

    @Column
    private double price;

    @Column
    private String description1;

    @Column
    private String description2;

    @Column
    private byte availability;

    @Column
    private String image;

    @Column(name = "_created_at")
    private Date _createdAt;

    @Column(name = "_updated_at")
    private Date _updatedAt;

    public Cake() {

    }

    public Cake(CakeDto cakeDto) {
        this.title = cakeDto.getTitle();
        this.price = cakeDto.getPrice();
        this.description1 = cakeDto.getDescription1();
        this.description2 = cakeDto.getDescription2();
        this.availability = cakeDto.getAvailability();
        this.image = cakeDto.getImage();
    }

    public Cake(long id, String title, double price, String description1, String description2, byte availability, String image, Date _createdAt, Date _updatedAt) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.description1 = description1;
        this.description2 = description2;
        this.availability = availability;
        this.image = image;
        this._createdAt = _createdAt;
        this._updatedAt = _updatedAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    public byte getAvailability() {
        return availability;
    }

    public void setAvailability(byte availability) {
        this.availability = availability;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cake cake = (Cake) o;
        return id == cake.id &&
                Double.compare(cake.price, price) == 0 &&
                availability == cake.availability &&
                Objects.equals(title, cake.title) &&
                Objects.equals(description1, cake.description1) &&
                Objects.equals(description2, cake.description2) &&
                Objects.equals(image, cake.image) &&
                Objects.equals(_createdAt, cake._createdAt) &&
                Objects.equals(_updatedAt, cake._updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, price, description1, description2, availability, image, _createdAt, _updatedAt);
    }

    @Override
    public String toString() {
        return "Cake{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", description1='" + description1 + '\'' +
                ", description2='" + description2 + '\'' +
                ", availability=" + availability +
                ", image='" + image + '\'' +
                ", _createdAt=" + _createdAt +
                ", _updatedAt=" + _updatedAt +
                '}';
    }
}
