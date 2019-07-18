package ru.job4j.analizy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс для анализа лог файла.
 */
public class Analizy {
    private static final Logger LOGGER = LoggerFactory.getLogger(Analizy.class);
    private static final String SUCCESS = "200";
    private static final String REDIRECTION = "300";
    private static final String CLIENT_ERROR = "400";
    private static final String SERVER_ERROR = "500";


    /**
     * Метод парсит лог файл(source) и записывает(в target) период недоступности сервиса.
     * Для парсинга используется метод parseSource()
     * Для сохранения результатов в файл используется метод saveUnavailable()
     * @param source лог файл
     * @param target файл хранит временной интервал, в котором сервис был недоступен.
     */
    public void unavailable(String source, String target) {
        try {
            List<String> list = this.parseSource(source);
            this.saveUnavailable(list, target);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    /**
     * Парсит файл.
     * @param source файл для парсинга
     * @return список, содержащий периоды недоступоности сервиса.
     * @throws IOException exception
     */
    private List<String> parseSource(String source) throws IOException {
        List<String> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String start = "";
                String end = "";
                if (line.contains(CLIENT_ERROR) || line.contains(SERVER_ERROR)) {
                    start = line.split(" ")[1];
                    while ((line = reader.readLine()) != null) {
                        if (line.contains(SUCCESS) || line.contains(REDIRECTION)) {
                            end = line.split(" ")[1];
                            break;
                        }
                    }
                    if (start != "" && end != "") {
                        result.add(start + ";" + end);
                    }
                }
            }
        }
        return result;
    }

    /**
     * Сохраняет результаты парсинга в файл.
     * @param periods cписок, содержащий периоды недоступоности сервиса
     * @param target файл для сохранения результата
     * @throws FileNotFoundException exception
     */
    private void saveUnavailable(List<String> periods, String target) throws FileNotFoundException {
        try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            periods.forEach(out::println);
        }
    }
}