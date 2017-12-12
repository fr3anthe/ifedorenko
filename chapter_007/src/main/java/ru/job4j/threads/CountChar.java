package ru.job4j.threads;

import java.util.TimerTask;

public class CountChar extends WordCheck {

    /**
     * Constructor.
     *
     * @param word word for check
     */
    public CountChar(String word) {
        super(word);
    }

    /**
     * Method run.
     */
    @Override
    public void run() {
        int countS = 0;
        try {
            for (int i = 0; i < this.str.length; i++) {
                if (!Thread.currentThread().isInterrupted()) {
                    if (this.str[i] != ' ') {
                        countS++;
                    }
                } else {
                    throw new InterruptedException();
                }
            }
            System.out.println("Chars: " + countS);
        } catch (InterruptedException e) {
            System.out.println("Выполнение программы остановлено");
        }

    }
}
