package ru.job4j.model.dao;

import org.junit.Test;
import ru.job4j.model.entities.Brand;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DBrandTest {
    private final DBrand brands = DBrand.getInstance();

    /**
     * Test add.
     */
    @Test
    public void testAdd() {
        Brand brand = new Brand();
        brand.setName("Toyota");
        int id = brands.add(brand);
        assertThat(this.brands.getById(brand.getId()).getId(), is(id));
    }

    /**
     * Test update.
     */
    @Test
    public void testUpdate() {
        Brand brand = new Brand();
        String name = "BMW";
        brand.setName("Mersedes");
        int id = brands.add(brand);
        brand.setName(name);
        brands.update(brand);
        assertThat(this.brands.getById(id).getName(), is(name));
    }

    /**
     * Test delete.
     */
    @Test
    public void testDelete() {
        Brand brand = new Brand();
        brand.setName("Kia");
        int id = brands.add(brand);
        int deleteId = brands.delete(brand);
        assertThat(id, is(deleteId));
    }

    /**
     * Test getById.
     */
    @Test
    public void testGetById() {
        Brand brand = new Brand();
        brand.setName("Suzuki");
        int id = brands.add(brand);
        assertThat(brands.getById(id).getName(), is(brand.getName()));
    }

    /**
     * Test getAll.
     */
    @Test
    public void testGetAll() {
        Brand brand1 = new Brand();
        Brand brand2 = new Brand();
        brand1.setName("Porshe");
        brand2.setName("Jaguar");
        brands.add(brand1);
        brands.add(brand2);
        List<Brand> list = brands.getAll();
        assertTrue(list.contains(brand1));
    }
}