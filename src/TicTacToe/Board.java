package TicTacToe;

import java.util.ArrayList;
import java.util.List;

public class Board {

    public int size;
    public PlayingSymbol[][] board;

    public Board(int size) {
        this.size = size;
        board = new PlayingSymbol[size][size];
    }

    public boolean addSymbol(int row, int column, PlayingSymbol playingSymbol) {
        if (board[row][column] != null) {
            return false;
        }
        board[row][column] = playingSymbol;
        return true;
    }

    public List<Pair<Integer, Integer>> getFreeCells() {
        List<Pair<Integer, Integer>> freeCells = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == null) {
                    freeCells.add(new Pair<>(i, j));
                }
            }
        }
        return freeCells;
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == null) {
                    System.out.print(" - ");
                } else {
                    System.out.print(" " + board[i][j].symbol + " ");
                }
                if (j < size - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < size - 1) {
                System.out.println("-".repeat(size * 4 - 1)); // Print horizontal separators
            }
        }
    }
}
