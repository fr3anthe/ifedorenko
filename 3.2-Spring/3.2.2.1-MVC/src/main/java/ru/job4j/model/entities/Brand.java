package ru.job4j.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

/**
 * Class Brand
 *
 * @author ifedorenko
 * @since 26.02.2019
 */
@Entity
@Table(name = "brand")
public class Brand extends BaseEntity {
    @Column
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Brand brand = (Brand) o;
        return Objects.equals(name, brand.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
