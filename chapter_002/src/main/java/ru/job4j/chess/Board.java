package ru.job4j.chess;


/**
 *Шахматная доска.
 *@author ifedorenko
 *@since 01.09.2017
 *@version 1
 */
public class Board {
    /**
     * @param board Массив, хранящий ячейки шахматной доски
     */
    private Cell[][] board;
    /**
     * @param figures массив, хранящий шахматные фигуры
     */
    private Figure[] figures;

    /**
     * Массив для хранения шахматных фигур.
     */
    private void createChess() {
        this.figures = new Figure[32];
        int j = 0;
        for (int i = 0; i < 8; i++) {
            this.figures[j++] = new Figure.Pawn(findCellByXY((char) ('A' + i), '2'), "white");
        }
        for (int i = 0; i < 8; i++) {
            this.figures[j++] = new Figure.Pawn(findCellByXY((char) ('A' + i), '7'), "black");
        }
        this.figures[j++] = new Figure.Castle(this.findCellByName("A1"), "white");
        this.figures[j++] = new Figure.Castle(this.findCellByName("A8"), "black");
        this.figures[j++] = new Figure.Castle(this.findCellByName("H1"), "white");
        this.figures[j++] = new Figure.Castle(this.findCellByName("H8"), "black");

        this.figures[j++] = new Figure.Knight(this.findCellByName("B1"), "white");
        this.figures[j++] = new Figure.Knight(this.findCellByName("B8"), "black");
        this.figures[j++] = new Figure.Knight(this.findCellByName("G1"), "white");
        this.figures[j++] = new Figure.Knight(this.findCellByName("G8"), "black");

        this.figures[j++] = new Figure.Bishop(this.findCellByName("C1"), "white");
        this.figures[j++] = new Figure.Bishop(this.findCellByName("C8"), "black");
        this.figures[j++] = new Figure.Bishop(this.findCellByName("F1"), "white");
        this.figures[j++] = new Figure.Bishop(this.findCellByName("F8"), "black");

        this.figures[j++] = new Figure.Queen(this.findCellByName("D1"), "white");
        this.figures[j++] = new Figure.Queen(this.findCellByName("D8"), "black");

        this.figures[j++] = new Figure.King(this.findCellByName("E1"), "white");
        this.figures[j++] = new Figure.King(this.findCellByName("E8"), "black");
    }

    /**
     * Метод инициализирует шахматную доску.
     * @return возвращает заполненную шахматную доску
     */
    private Cell[][] createBoard() {
        this.board = new Cell[8][8];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if ((i + j) % 2 == 0) {
                   board[i][j] = new Cell((char) ('A' + j), (char) ('1' + board.length  - 1 - i), "white");
                } else {
                    board[i][j] = new Cell((char) ('A' + j), (char) ('1' + board.length - 1 - i), "black");
                }
            }
        }
        return board;
    }

    /**
     * Массив создает шахматную доску и заполняет ее шахматными фигурами.
     */
    public void init() {
        this.createBoard();
        this.createChess();
    }

    /**
     * Метод ищет ячейку шахматной доски по имени.
     * @param name имя шахматной доски
     * @return возвращает необходимую ячейку
     */
    public Cell findCellByName(String name) {
        Cell result = null;
        for (Cell[] cell : this.board) {
            for (Cell cl : cell) {
                if (name.equals(cl.getName())) {
                    result = cl;
                }
            }
        }
        return result;
    }

    /**
     * Метод ищет ячейку шахматной доски по координатам x и y.
     * @param x от A до H.
     * @param y от 1 до 8
     * @return возвращает необходимую ячейку
     */
    public Cell findCellByXY(char x, char y) {
        Cell result = null;
        for (Cell[] cell : this.board) {
            for (Cell cl : cell) {
                if (x == cl.getX() && y == cl.getY()) {
                    result = cl;
                }
            }
        }
        return result;
    }

    /**
     * Метод проверяет есть ли на пути движения фиугры другие фигуры.
     * @param cells массив ячеек движения фигуры
     * @return true or false
     */
    public boolean checkWay(Cell[] cells) {
        boolean result = true;
        for (Cell cell : cells) {
            if (cell.getFigure()) {
                result = false;
                break;
            }
        }
        return result;
    }



    /**
     * Основной метод. Проверяет основные параметры для перемещения шахматной фигуры.
     * @param source начальная ячейка шахматной фигуры.
     * @param dist ячейка назначения шахматной фигуры
     * @throws ImpossibleMoveException ошибка возникает, когда фигура не может двигаться по заданной траектории или выбранна ячейка за пределами шахматной доски.
     * @throws OccupiedWayException ошибка возникает, если фигура не может двигаться из-за того, что на клетке находится фигура.
     * @throws FigureNotFoundException ошибка возникает, если фигуры нет на стартовой клетке.
     * @return возвращает результат проверки
     */
    public boolean move(Cell source, Cell dist) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        boolean result = false;
        if (source.getFigure()) {
            if ((dist.getX() >= 'A' && dist.getX() <= 'H') && (dist.getY() >= '1' && dist.getY() <= '8')) {
                if (this.checkWay(source.getFig().way(dist))) {
                    source.getFig().clone(dist);
                    result = true;
                } else {
                    throw new OccupiedWayException("Figure can't move, because on the way have another figure");
                }
            } else {
                throw new ImpossibleMoveException("Figure can't move because the destination cell does not exist");
            }
        } else {
            throw new FigureNotFoundException("Figure not found");
        }
        return result;
    }

}