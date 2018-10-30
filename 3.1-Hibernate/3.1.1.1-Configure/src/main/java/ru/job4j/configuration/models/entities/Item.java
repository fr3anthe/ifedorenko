package ru.job4j.configuration.models.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Class item.
 *
 * @author ifedorenko
 * @since 12.10.2018
 */
public class Item implements Serializable {
    private int id;
    private String desc;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Timestamp created;
    private boolean done;

    /**
     * Base constructor
     */
    public Item() {
    }

    /**
     * Getter for id.
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for
     * @param id param
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for desc.
     * @return desc
     */
    public String getDesc() {
        return desc;
    }
    /**
     * Setter for id.
     * @param desc param
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * Getter for created.
     * @return created
     */
    public Timestamp getCreated() {
        return created;
    }
    /**
     * Setter for created.
     * @param created param
     */
    public void setCreated(Timestamp created) {
        this.created = created;
    }

    /**
     * Getter for done.
     * @return done
     */
    public boolean isDone() {
        return done;
    }
    /**
     * Setter for done.
     * @param done param
     */
    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Item other = (Item) o;
        if (id != other.id) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Item{"
                + "id=" + id
                + ", desc='" + desc + '\''
                + ", created=" + created
                + ", done=" + done
                + '}';
    }
}
