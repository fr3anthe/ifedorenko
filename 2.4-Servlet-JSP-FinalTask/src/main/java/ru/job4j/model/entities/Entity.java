package ru.job4j.model.entities;

public interface Entity<T> {

    /**
     * Getter for id.
     * @return id
     */
    public int getId();

    /**
     * Setter for id
     * @param id id's value
     */
    public void setId(int id);

    /**
     * Getter for name.
     * @return name
     */
    public String getName();

    /**
     * Setter for name.
     * @param name name's value
     */
    public void setName(String name);
}
