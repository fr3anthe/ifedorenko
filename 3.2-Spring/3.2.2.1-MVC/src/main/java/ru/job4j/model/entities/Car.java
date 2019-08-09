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
@Getter
@Setter
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
