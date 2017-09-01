package ru.job4j.chess;

/**
 *Абстрактный класс Figure.
 *@author ifedorenko
 *@since 30.08.2017
 *@version 1
 */
public abstract class Figure {
    /**
     * @param текущая позиция шахматной фигуры
     */
    private final Cell position;
    /**
     * @param цвет шахматной фигуры.
     */
    private String color;
    /**
     * @param board шахматная доска
     */
    private Board board;
    /**
     * Констркутор шахматной фигуры.
     * @param position указываем текущую позицию фигуры
     * @param color указываем цвет фигуры.
     */
    public Figure(Cell position, String color) {
        this.position = position;
        this.color = color;
        this.position.setFigure(true);
        this.position.setFig(this);
    }

    /**
     * Метод возвращает цвет фигуры.
     * @return color
     */
    public String getColor() {
        return  this.color;
    }
    /**
     * Абстрактный метод. Алгоритм движения шахматных фигур.
     * @param dist Куда должна переместиться фигура
     * @throws ImpossibleMoveException ошибка возникает, когда фигура не может двигаться по заданной траектории.
     * @return Может ли фигура переместиться в заданную клетку.
     */
    abstract Cell[] way(Cell dist) throws ImpossibleMoveException;

    /**
     * Метод перемещает фигуру из одной клетки в другую.
     * @param dist новая клетка, в которой будет находиться фигура
     */
    public void clone(Cell dist) {
        dist.setFig(this.position.getFig());
         dist.setFigure(this.position.getFigure());
         this.position.setFig(null);
         this.position.setFigure(false);
    }

    /**
     *Шахматная фигура cлон.
     *@author ifedorenko
     *@since 31.08.2017
     *@version 1
     */
    static class Bishop extends Figure {
        /**
         * Констркутор шахматной фигуры слон.
         * @param position указываем текущую позицию фигуры
         * @param color указываем цвет фигуры.
         */
        Bishop(Cell position, String color) {
            super(position, color);
        }
        /**
         * Алгоритм движения шахматной фигуры слон.
         * @param dist Куда должна переместиться фигура
         * @throws ImpossibleMoveException ошибка возникает, когда фигура не может двигаться по заданной траектории или выбранна ячейка за пределами шахматной доски.
         * @return Может ли фигура переместиться в заданную клетку.
         */
        public Cell[] way(Cell dist) throws ImpossibleMoveException {
            int steps = dist.getX() - super.position.getX();
            Cell[] cells = new Cell[steps];
            int count = 0;
            if (dist.getX() == super.position.getX() + steps && dist.getY() == super.position.getY() + steps) {
               for (int i = 0; i < steps; i++) {
                    cells[count++] = super.board.findCellByXY((char) (dist.getX() - i), (char) (dist.getY() - i));
               }
            } else if (dist.getX() == super.position.getX() + steps && dist.getY() == super.position.getY() - steps) {
                for (int i = 0; i < steps; i++) {
                    cells[count++] = super.board.findCellByXY((char) (dist.getX() - i), (char) (dist.getY() + i));
                }
            } else if (dist.getX() == super.position.getX() - steps && dist.getY() == super.position.getY() - steps) {
                for (int i = 0; i < steps; i++) {
                    cells[count++] = super.board.findCellByXY((char) (dist.getX() + i), (char) (dist.getY() + i));
                }
            } else if (dist.getX() == super.position.getX() - steps && dist.getY() == super.position.getY() + steps) {
                for (int i = 0; i < steps; i++) {
                    cells[count++] = super.board.findCellByXY((char) (dist.getX() + i), (char) (dist.getY() - i));
                }
            }
            if (!cells[0].equals(null)) {
                return cells;
            } else {
                throw new ImpossibleMoveException("Bishop can't move to this cell");
            }
        }
    }
    /**
     *Шахматная фигура король.
     *@author ifedorenko
     *@since 31.08.2017
     *@version 1
     */
    static class King extends Figure {
        /**
         * Констркутор шахматной король.
         * @param position указываем текущую позицию фигуры
         * @param color указываем цвет фигуры.
         */
        King(Cell position, String color) {
            super(position, color);
        }
        /**
         * Алгоритм движения шахматной фигуры король.
         * @param dist Куда должна переместиться фигура
         * @throws ImpossibleMoveException ошибка возникает, когда фигура не может двигаться по заданной траектории или выбранна ячейка за пределами шахматной доски.
         * @return Может ли фигура переместиться в заданную клетку.
         */
        public Cell[] way(Cell dist) throws ImpossibleMoveException {
            Cell[] cells = new Cell[1];
            if ((dist.getX() == super.position.getX() && dist.getY() == super.position.getY() + 1)
                    || (dist.getX() == super.position.getX() + 1 && dist.getY() == super.position.getY() + 1)
                    || (dist.getX() == super.position.getX() + 1 && dist.getY() == super.position.getY())
                    || (dist.getX() == super.position.getX() + 1 && dist.getY() == super.position.getY() - 1)
                    || (dist.getX() == super.position.getX() && dist.getY() == super.position.getY() - 1)
                    || (dist.getX() == super.position.getX() - 1 && dist.getY() == super.position.getY() - 1)
                    || (dist.getX() == super.position.getX() - 1 && dist.getY() == super.position.getY())
                    || (dist.getX() == super.position.getX() - 1 && dist.getY() == super.position.getY() + 1)) {
                cells[0] = dist;
            }
            if (!cells[0].equals(null)) {
                return cells;
            } else {
                throw new ImpossibleMoveException("King can't move to this cell");
            }
        }
    }
    /**
     *Шахматная фигура ладья.
     *@author ifedorenko
     *@since 31.08.2017
     *@version 1
     */
    static class Castle extends Figure {
        /**
         * Констркутор шахматной ладья.
         * @param position указываем текущую позицию фигуры
         * @throws ImpossibleMoveException ошибка возникает, когда фигура не может двигаться по заданной траектории или выбранна ячейка за пределами шахматной доски.
         * @param color указываем цвет фигуры.
         */
        Castle(Cell position, String color) {
            super(position, color);
        }
        /**
         * Алгоритм движения шахматной фигуры ладья.
         * @param dist Куда должна переместиться фигура
         * @throws ImpossibleMoveException ошибка возникает, когда фигура не может двигаться по заданной траектории или выбранна ячейка за пределами шахматной доски.
         * @return Может ли фигура переместиться в заданную клетку.
         */
        public Cell[] way(Cell dist) throws ImpossibleMoveException {
            int steps = dist.getX() - super.position.getX();
            Cell[] cells = new Cell[steps];
            int count = 0;
            if (dist.getX() == super.position.getX() && dist.getY() == super.position.getY() + steps) {
                for (int i = 0; i < steps; i++) {
                    cells[count++] = super.board.findCellByXY((dist.getX()), (char) (dist.getY() - i));
                }
            } else if (dist.getX() == super.position.getX() + steps && dist.getY() == super.position.getY()) {
                for (int i = 0; i < steps; i++) {
                    cells[count++] = super.board.findCellByXY((char) (dist.getX() - steps), (dist.getY()));
                }
            } else if (dist.getX() == super.position.getX() && dist.getY() == super.position.getY() - steps) {
                for (int i = 0; i < steps; i++) {
                    cells[count++] = super.board.findCellByXY((dist.getX()), (char) (dist.getY() + i));
                }
            } else if (dist.getX() == super.position.getX() - steps && dist.getY() == super.position.getY()) {
                for (int i = 0; i < steps; i++) {
                    cells[count++] = super.board.findCellByXY((char) (dist.getX() + steps), (dist.getY()));
                }
            }
            if (!cells[0].equals(null)) {
                return cells;
            } else {
                throw new ImpossibleMoveException("Castle can't move to this cell");
            }
        }
    }
    /**
     *Шахматная фигура конь.
     *@author ifedorenko
     *@since 31.08.2017
     *@version 1
     */
    static class Knight extends Figure {
        /**
         * Констркутор шахматной фигуры конь.
         * @param position указываем текущую позицию фигуры
         * @param color указываем цвет фигуры.
         */
        Knight(Cell position, String color) {
            super(position, color);
        }
        /**
         * Алгоритм движения шахматной фигуры конь.
         * @param dist Куда должна переместиться фигура
         * @throws ImpossibleMoveException ошибка возникает, когда фигура не может двигаться по заданной траектории или выбранна ячейка за пределами шахматной доски.
         * @return Может ли фигура переместиться в заданную клетку.
         */
        public Cell[] way(Cell dist) throws ImpossibleMoveException {
            Cell[] cells = new Cell[1];

            if ((dist.getX() == super.position.getX() + 1 && dist.getY() == super.position.getY() + 2)
                    || (dist.getX() == super.position.getX() - 1 && dist.getY() == super.position.getY() + 2)
                    || (dist.getX() == super.position.getX() + 1 && dist.getY() == super.position.getY() + 2)
                    || (dist.getX() == super.position.getX() - 1 && dist.getY() == super.position.getY() - 2)) {
                cells[0] = dist;
            }
            if (!cells[0].equals(null)) {
                return cells;
            } else {
                throw new ImpossibleMoveException("Knight can't move to this cell");
            }
        }
    }
    /**
     *Шахматная фигура пешка.
     *@author ifedorenko
     *@since 31.08.2017
     *@version 1
     */
    static class Pawn extends Figure {
        /**
         * Констркутор шахматной фигуры пешка.
         * @param position указываем текущую позицию фигуры
         * @throws ImpossibleMoveException ошибка возникает, когда фигура не может двигаться по заданной траектории или выбранна ячейка за пределами шахматной доски.
         * @param color указываем цвет фигуры.
         */
        Pawn(Cell position, String color) {
            super(position, color);
        }
        /**
         * Алгоритм движения шахматной фигуры пешка.
         * @param dist Куда должна переместиться фигура
         * @throws ImpossibleMoveException ошибка возникает, когда фигура не может двигаться по заданной траектории или выбранна ячейка за пределами шахматной доски.
         * @return Может ли фигура переместиться в заданную клетку.
         */
        public Cell[] way(Cell dist) throws ImpossibleMoveException {
            Cell[] cells = new Cell[1];
            if (super.color.equals("white")) {
                if (dist.getY() == super.position.getY() + 1) {
                    cells[0] = dist;
                }
            } else {
                if (dist.getY() == super.position.getY() - 1) {
                    cells[0] = dist;
                }
            }
            if (!cells[0].equals(null)) {
                return cells;
            } else {
                throw new ImpossibleMoveException("Pawn can't move to this cell");
            }
        }
    }
    /**
     *Шахматная фигура королева.
     *@author ifedorenko
     *@since 31.08.2017
     *@version 1
     */
    static class Queen extends Figure {
        /**
         * Констркутор шахматной фигуры королева.
         * @param position указываем текущую позицию фигуры
         * @throws ImpossibleMoveException ошибка возникает, когда фигура не может двигаться по заданной траектории или выбранна ячейка за пределами шахматной доски.
         * @param color указываем цвет фигуры.
         */
        Queen(Cell position, String color) {
            super(position, color);
        }
        /**
         * Алгоритм движения шахматной фигуры королева.
         * @param dist Куда должна переместиться фигура
         * @throws ImpossibleMoveException ошибка возникает, когда фигура не может двигаться по заданной траектории или выбранна ячейка за пределами шахматной доски.
         * @return Может ли фигура переместиться в заданную клетку.
         */
        public Cell[] way(Cell dist) throws ImpossibleMoveException {
            int steps = dist.getX() - super.position.getX();
            Cell[] cells = new Cell[steps];
            int index = 0;
            if (dist.getX() == super.position.getX() && dist.getY() == super.position.getY() + steps) {
                for (int i = 0; i < steps; i++) {
                    cells[index++] = super.board.findCellByXY((dist.getX()), (char) (dist.getY() - i));
                }
            } else if (dist.getX() == super.position.getX() + steps && dist.getY() == super.position.getY() + steps) {
                for (int i = 0; i < steps; i++) {
                    cells[index++] = super.board.findCellByXY((char) (dist.getX() - i), (char) (dist.getY() + i));
                }
            } else if (dist.getX() == super.position.getX() + steps && dist.getY() == super.position.getY()) {
                for (int i = 0; i < steps; i++) {
                    cells[index++] = super.board.findCellByXY((char) (dist.getX() - i), (dist.getY()));
                }
            } else if (dist.getX() == super.position.getX() + steps && dist.getY() == super.position.getY() - steps) {
                for (int i = 0; i < steps; i++) {
                    cells[index++] = super.board.findCellByXY((char) (dist.getX() - i), (char) (dist.getY() + i));
                }
            } else if (dist.getX() == super.position.getX() && dist.getY() == super.position.getY() - steps) {
                for (int i = 0; i < steps; i++) {
                    cells[index++] = super.board.findCellByXY((dist.getX()), (char) (dist.getY() + i));
                }
            } else if (dist.getX() == super.position.getX() - steps && dist.getY() == super.position.getY() - steps) {
                for (int i = 0; i < steps; i++) {
                    cells[index++] = super.board.findCellByXY((char) (dist.getX() - i), (char) (dist.getY() + i));
                }
            } else if (dist.getX() == super.position.getX() - steps && dist.getY() == super.position.getY()) {
                for (int i = 0; i < steps; i++) {
                    cells[index++] = super.board.findCellByXY((char) (dist.getX() + i), (dist.getY()));
                }
            } else if (dist.getX() == super.position.getX() - steps && dist.getY() == super.position.getY() + steps) {
                for (int i = 0; i < steps; i++) {
                    cells[index++] = super.board.findCellByXY((char) (dist.getX() + i), (char) (dist.getY() - i));
                }
            }
            if (!cells[0].equals(null)) {
                return cells;
            } else {
                throw new ImpossibleMoveException("Queen can't move to this cell");
            }
        }
    }
}
