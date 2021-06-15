package org.cp.model;


import org.cp.model.Solver.BackTrackSudokuSolver;
import org.cp.model.Models.SudokuField;
import org.cp.model.Models.SudokuColumn;
import org.cp.model.Models.SudokuRow;
import org.cp.model.Models.SudokuBoard;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import static org.junit.Assert.*;

public class SudokuRowTest {

    @Test
    public void testSudokuRowClass() {
        ArrayList<SudokuField> fields = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            fields.add(new SudokuField());
            fields.get(i).setValue(i);
        }
        SudokuRow row = new SudokuRow(fields);
        for (int i = 0; i < 9; i++) {
            assertEquals(i, row.getFieldInRow(i));
        }
    }

    @Test
    public void testVerifyInRow() {
        ArrayList<SudokuField> fields = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            fields.add(new SudokuField());
            fields.get(i).setValue(0);
        }
        fields.get(3).setValue(10);
        SudokuRow row = new SudokuRow(fields);
        assertFalse(row.verify(10));
        assertTrue(row.verify(1));
    }

    @Test
    public void testCorrectDigitRows() {
        Set<Integer> digitsInRow = new HashSet<>();
        BackTrackSudokuSolver solver = new BackTrackSudokuSolver();
        SudokuBoard sudoku = new SudokuBoard(new int[9][9], solver);
        sudoku.solveGame();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                digitsInRow.add(sudoku.getRow(i).getFieldInRow(j));
            }
            assertEquals(9, digitsInRow.size());
            digitsInRow.clear();
        }
    }

    @Test
    public void testToStringMethod() {
        ArrayList<SudokuField> fields = new ArrayList<>();
        fields.add(new SudokuField());
        fields.get(0).setValue(10);
        SudokuRow row = new SudokuRow(fields);

        Logger logger = Logger.getLogger(SudokuRowTest.class.getName());
        logger.config(row.toString());
    }

    @Test
    public void testEqualsMethodShouldReturnFalseForNull() {
        SudokuRow sudokuRow = new SudokuRow();
        SudokuRow sudokuRow2 = null;

        assertFalse(sudokuRow.equals(sudokuRow2));
    }

    @Test
    public void testEqualsMethodShouldReturnFalseForDifferentClassObjects() {
        SudokuRow sudokuRow = new SudokuRow();
        SudokuColumn sudokuCol2 = new SudokuColumn();

        assertFalse(sudokuRow.equals(sudokuCol2));
    }

    @Test
    public void testEqualsMethod() {
        SudokuRow sudokuRow = new SudokuRow();
        SudokuRow sudokuRow2 = new SudokuRow();

        assertTrue(sudokuRow.equals(sudokuRow2));
    }

    @Test
    public void testHashCodeMethod() {
        SudokuRow sudokuRow = new SudokuRow();
        SudokuRow sudokuRow2 = new SudokuRow();

        int row1HashCode = sudokuRow.hashCode();
        int row2HashCode = sudokuRow2.hashCode();

        assertEquals(row1HashCode, row2HashCode);
    }

    @Test
    public void testRowClone() throws CloneNotSupportedException {
        SudokuRow sudokuRow = new SudokuRow();
        SudokuRow sudokuRow2 = (SudokuRow) sudokuRow.clone();

        assertEquals(sudokuRow, sudokuRow2);
    }
}
