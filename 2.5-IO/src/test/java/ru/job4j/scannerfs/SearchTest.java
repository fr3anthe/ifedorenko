package ru.job4j.scannerfs;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * class SerachTest.
 */
public class SearchTest {
    private final String folder = System.getProperty("java.io.tmpdir") + "javaSearch";

    /**
     * Test №1
     * В дереве находится 12 файлов с расширением txt.
     */
    @Test
    public void findExtensionTxt() {
        Search search = new Search();
        List<File> list = search.searchFiles(folder, Arrays.asList("txt"));
        assertThat(list.size(), is(12));
    }

    /**
     * Test №2
     * В дереве находится 9 файлов с расширением xlsx.
     */
    @Test
    public void findExtensionXlsx() {
        Search search = new Search();
        List<File> list = search.searchFiles(folder, Arrays.asList("xlsx"));
        assertThat(list.size(), is(9));
    }

    /**
     * Test №3
     * В дереве находится 21 файл с расширением txt и xlsx.
     */
    @Test
    public void findExtensionTxtAndXlsx() {
        Search search = new Search();
        List<File> list = search.searchFiles(folder, Arrays.asList("txt", "xlsx"));
        assertThat(list.size(), is(21));
    }

    /**
     * Test №4
     */
    @Test
    public void checkEmptyFolder() {
        Search search = new Search();
        List<File> list = search.searchFiles(folder + "\\empty", Arrays.asList("txt"));
        assertThat(list.size(), is(0));
    }
}