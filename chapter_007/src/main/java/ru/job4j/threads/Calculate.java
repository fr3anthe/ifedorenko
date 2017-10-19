package ru.job4j.threads;
import java.io.IOException;

/**
 * Class Calculate.
 */
public class Calculate {

    /**
     * Method calc.
     *
     * @param string string for parse
     * @throws IOException exception
     */
    public void calc(String string) throws IOException {
        new Thread(new SpaceCount(string)).start();
        new Thread(new WordCount(string)).start();
    }

    /**
     * method main.
     * @param args args
     * @throws IOException exception
     */
    public static void main(String[] args) throws IOException {
        Calculate calculate = new Calculate();
        String s = "Закрыло пеленой чреду воспоминаний";
        calculate.calc(s);
    }
}
