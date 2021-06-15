package org.cp.model.Models;

import java.io.Serializable;
import java.util.ArrayList;

import org.cp.model.Solver.SudokuSolver;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class SudokuBoard implements Serializable {

    private int rowNumber;
    private int colNumber;
    private SudokuSolver interfa;
    private SudokuField[][] board;
    private final ArrayList<SudokuRow> sudokuRow;
    private final ArrayList<SudokuColumn> sudokuCol;
    private final ArrayList<SudokuBox> sudokuBox;

    public SudokuBoard() {
        rowNumber = 0;
        colNumber = 0;
        board = new SudokuField[9][9];
        sudokuRow = new ArrayList<>();
        sudokuCol = new ArrayList<>();
        sudokuBox = new ArrayList<>();
    }

    public SudokuBoard(int[][] board, SudokuSolver sudokuSolver) {

        this.board = new SudokuField[9][9];
        this.sudokuRow = new ArrayList<>();
        this.sudokuCol = new ArrayList<>();
        this.sudokuBox = new ArrayList<>();
        interfa = sudokuSolver;
        ArrayList<SudokuField> currentRow = new ArrayList<>();
        ArrayList<SudokuField> currentColumn = new ArrayList<>();
        ArrayList<SudokuField> currentBox = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                this.board[i][j] = new SudokuField();
                this.board[i][j].setValue(board[i][j]);
            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                currentRow.add(this.board[i][j]);
                currentColumn.add(this.board[j][i]);
            }
            sudokuRow.add(new SudokuRow(currentRow));
            sudokuCol.add(new SudokuColumn(currentColumn));
            currentRow = new ArrayList<>();
            currentColumn = new ArrayList<>();
        }

        int fieldInBox = 0;
        int rowCounter = 0;
        int colCounter = 0;
        for (int boxNr = 0; boxNr < 9; boxNr++) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    currentBox.add(this.board[i + (3 * rowCounter)][j + (3 * colCounter)]);
                    fieldInBox = fieldInBox + 1;
                }
            }
            fieldInBox = 0;
            colCounter++;
            if (colCounter == 3) {
                colCounter = 0;
                rowCounter++;
            }
            sudokuBox.add(new SudokuBox(currentBox));
            currentBox = new ArrayList<>();
        }
    }

    public int get(int x, int y) {
        return this.board[x][y].getFieldValue();
    }

    public void set(int x, int y, int value) {
        this.colNumber = x;
        this.rowNumber = y;
        this.board[x][y].setValue(value);
    }

    public boolean checkBoard(int x, int y, int number) {
        if (!getRow(x).verify(number)) {
            return false;
        }

        if (!getColumn(y).verify(number)) {
            return false;
        }

        int r = (x / 3);
        int c = (y / 3);

        if (!getBox(c + (3 * r)).verify(number)) {
            return false;
        }

        return true;
    }

    public SudokuRow getRow(int x) {

        return this.sudokuRow.get(x);
    }

    public SudokuColumn getColumn(int y) {
        return this.sudokuCol.get(y);
    }

    public SudokuBox getBox(int x) {
        return this.sudokuBox.get(x);
    }

    public boolean solveGame() {
        return interfa.solve(this, 0, 0);
    }

    public void display() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(" " + board[i][j].getFieldValue());
            }
            System.out.println();
        }
        System.out.println();

    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("board", board)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SudokuBoard that = (SudokuBoard) o;

        return new EqualsBuilder()
                .append(interfa, that.interfa)
                .append(board, that.board)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(interfa)
                .append(board)
                .toHashCode();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        SudokuBoard clonedBoard = new SudokuBoard(new int[9][9], interfa);
        for(int i = 0; i<9; i++)
            for(int j = 0; j<9; j++) {
                clonedBoard.set(i,j, this.get(i,j));
            }
        return clonedBoard;
    }
}

