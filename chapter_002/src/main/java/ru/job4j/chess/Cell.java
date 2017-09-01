package ru.job4j.chess;

/**
 *Класс Cell. Клетка шахматной доски.
 *@author ifedorenko
 *@since 30.08.2017
 *@version 1
 */
public class Cell {
    /**
     * @param figure возвращает результат в зависимости от того, есть ли в ячейке фигура.
     */
    private boolean figure = false;
    /**
     * @param fig хранит информацию о фигуре, находящейся в данной ячейке.
     */
    private Figure fig;
    /**
     * @param x координата по оси x (принимает значения от A до H)
     */
    private char x;
    /**
     * @param y координата по оси y (принимает значения от 1 до 8)
     */
    private char y;
    /**
     * @param color цвет ячейки
     */
    private String color;
    /**
     * @param name имя ячейки
     */
    private String name;

    /**
     * Конструктор ячейки.
     * @param x координата по оси x
     * @param y координата по оси y
     * @param color цвет ячейки
     */
    public Cell(char x, char y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.name = new StringBuilder().append(this.x).append(this.y).toString();
    }

    /**
     * Метод возвращает переменную x.
     * @return x
     */
    public char getX() {
        return this.x;
    }

    /**
     * Метод возвращает переменную y.
     * @return y
     */
    public char getY() {
        return this.y;
    }

    /**
     * Метод вносит информация о том, что на шахматной ячейке стоит фигура.
     * @param figure true
     */
    public void setFigure(boolean figure) {
        this.figure = figure;
    }

    /**
     * Метод сообщает, находится ли на шахматной ячейке фигура.
     * @return true or false
     */
    public boolean getFigure() {
        return this.figure;
    }

    /**
     * Метод возвращает имя ячейки.
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Метод возвращает информацию о шахматной фигуре, находящейся на данной клетке.
     * @return возвращает информацию.
     */
    public Figure getFig() {
        return this.fig;
    }

    /**
     * Метод добавлят информацию о шахматной фигуре.
     * @param fig информация о шахматной фигуре.
     */
    public void setFig(Figure fig) {
        this.fig = fig;
    }
}
