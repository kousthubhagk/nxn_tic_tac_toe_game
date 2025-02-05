import java.util.Arrays;
import java.lang.System;
public class Board {
    private char[][] grid;
    private int size;

    public Board(int size) {
        this.size = size;
        grid = new char[size][size];
        for (char[] row : grid) {
            Arrays.fill(row, '-');
        }
    }

    public boolean placeMove(int row, int col, char symbol) {
        if (row < 0 || row >= size || col < 0 || col >= size || grid[row][col] != '-') {
            return false;
        }
        grid[row][col] = symbol;
        return true;
    }

    public char getCell(int row, int col) {
        return grid[row][col];
    }

    public int getSize() {
        return size;
    }

    public boolean isFull() {
        for (char[] row : grid) {
            for (char cell : row) {
                if (cell == '-') return false;
            }
        }
        return true;
    }

    public void printBoard() {
        for (char[] row : grid) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
