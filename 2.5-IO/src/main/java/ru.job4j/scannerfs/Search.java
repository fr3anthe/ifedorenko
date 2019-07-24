package ru.job4j.scannerfs;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Класс Search.
 */
public class Search {
    private LinkedList<File> files = new LinkedList<>();
    private List<String> extension;

    /**
     * Метод для обхода каталога.
     * Осуществляется поиск файлов, соотвестующих заданному расширению.
     * @param parent корень каталога.
     * @param exts расширения для поиска на соотвествие.
     * @return список файлов, удовлетворяющих критерию поиска
     */
    public List<File> searchFiles(String parent, List<String> exts) {
        this.extension = exts;
        List<File> result = new ArrayList<>();
        files.add(new File(parent));
        while (!files.isEmpty()) {
            Arrays.stream(files.remove().listFiles())
                    .filter(this::isNotDirectory)
                    .filter(this::checkExtension)
                    .forEach(result::add);
        }
        return result;
    };

    /**
     * Осуществляется проверка, что файл не является диркеторией.
     * Если файл явл-тся директорией, то он добавляется в очередь для обхода.
     * @param file file
     * @return результат проверки.
     */
    private boolean isNotDirectory(File file) {
        boolean result = true;
        if (file.isDirectory()) {
            files.add(file);
            result = false;
        }
        return result;
    }

    /**
     * Проверяется соотвествие по заданным разрешениям.
     * @param file file
     * @return результат проверки.
     */
    private boolean checkExtension(File file) {
        return extension.contains(file.getName().substring(file.getName().lastIndexOf(".") + 1));
    }
}