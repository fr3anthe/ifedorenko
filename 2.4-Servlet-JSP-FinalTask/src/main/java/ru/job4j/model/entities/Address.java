package ru.job4j.model.entities;

import java.util.Objects;

/**
 * Address.
 *
 * @author ifedorenko
 * @since 04.09.2018
 */
public class Address extends BaseEntity {
    /**
     * Constructor №1.
     *
     * @param name address's name
     */
    public Address(final String name) {
        this.name = name;
    }

    /**
     * Constructor №2.
     *
     * @param id   id from db
     * @param name address's name
     */
    public Address(final int id, final String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Equals.
     * @param obj obj
     * @return result
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Address)) {
            return false;
        }
        Address address = (Address) obj;

        return address.name.equals(name)
                && address.id == id;
    }

    /**
     * hashCode.
     * @return hash
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
