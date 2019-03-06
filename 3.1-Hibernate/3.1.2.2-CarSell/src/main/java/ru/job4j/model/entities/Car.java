package ru.job4j.model.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.persistence.Entity;

/**
 * Class Car.
 *
 * @author ifedorenko
 * @since 19.12.2018
 */
@Entity
@Table(name = "car")
public class Car extends BaseEntity {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "brand_id")
    private Brand brand;
    @Column
    private String model;
    @Column
    private String vin;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "carbody_id")
    private Carbody carbody;
    @Column
    private String color;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "engine_id")
    private Engine engine;
    @Column
    private String power;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "transmission_id")
    private Transmission transmission;
    @OneToOne(mappedBy = "car")
    private Advertisement ad;

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Carbody getCarbody() {
        return carbody;
    }

    public void setCarbody(Carbody carbody) {
        this.carbody = carbody;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Car car = (Car) o;

        return vin != null ? vin.equals(car.vin) : car.vin == null;
    }

    @Override
    public int hashCode() {
        return vin != null ? vin.hashCode() : 0;
    }
}
