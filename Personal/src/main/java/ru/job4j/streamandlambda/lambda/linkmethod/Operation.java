package ru.job4j.lambdas.linkmethod;

/**
 * В Java методы могут возвращать lambda-выражения
 */
public interface Operation {
    int getResult(int value1, int value2);
}

class OperationTest {
    public static void main(String[] args) {
        System.out.println(getOperation('*').getResult(10, 5));
        System.out.println(getOperation('/').getResult(10, 5));
        System.out.println(getOperation('+').getResult(10, 5));
        System.out.println(getOperation('-').getResult(10, 5));
    }

    private static Operation getOperation(char symbol) {
        switch (symbol) {
            case '*':
                return ((value1, value2) -> value1 * value2);
            case '/':
                return ((value1, value2) -> value1 / value2);
            case '+':
                return ((value1, value2) -> value1 + value2);
            case '-':
                return ((value1, value2) -> value1 - value2);
            default:
                return ((value1, value2) -> 0);
        }
    }
}