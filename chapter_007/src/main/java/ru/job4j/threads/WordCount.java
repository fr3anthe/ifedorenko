package ru.job4j.threads;
/**
 * Class WordCount.
 */
public class WordCount extends WordCheck {

    /**
     * Constructor.
     * @param word word for check
     */
    public WordCount(String word) {
        super(word);
    }

    /**
     * Method run.
     */
    @Override
    public void run() {
        int countW = 0;
        int count = 0;
        for (int i = 0; i < this.str.length; i++) {
            if (this.str[i] != ' ') {
                count++;
                if (i == this.str.length - 1) {
                    countW++;
                }
            } else if (this.str[i] == ' ' && count > 0) {
                countW++;
                count = 0;
            }
        }
        System.out.print("Words: " + countW);
    }
}
