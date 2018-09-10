package ru.job4j.patterns.creational.builder;

/**
 * BuilderPattern.
 *
 * Для построения сложных объектов.
 *
 * @author ifedorenko
 * @since 31.08.2018
 */
public class BuilderPattern {

    /**
     * Method main.
     * @param args args
     */
    public static void main(String[] args) {
        SportCar sc = new SportCar.Builder("Audi").setColor("red").setMaxSpeed(300).build();
        Account account = Account.initializeRegistration().login("root").password("root").email("root@root.com").createAccount();
        System.out.println(sc.toString());
        System.out.println(account.toString());

    }
}


