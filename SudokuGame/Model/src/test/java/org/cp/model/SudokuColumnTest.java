package org.cp.model;


import org.cp.model.Solver.BackTrackSudokuSolver;
import org.cp.model.Models.SudokuBoard;
import org.cp.model.Models.SudokuRow;
import org.cp.model.Models.SudokuField;
import org.cp.model.Models.SudokuColumn;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import static org.junit.Assert.*;

public class SudokuColumnTest {

    @Test
    public void testSudokuColumnClass() {
        ArrayList<SudokuField> fields = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            fields.add(new SudokuField());
            fields.get(i).setValue(i);
        }
        SudokuColumn col = new SudokuColumn(fields);
        for (int i = 0; i < 9; i++) {
            assertEquals(i, col.getFieldInCol(i));
        }
        fields.get(0).setValue(10);
        assertEquals(10, col.getFieldInCol(0));
    }

    @Test
    public void testVerifyInColumn() {
        ArrayList<SudokuField> fields = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            fields.add(new SudokuField());
            fields.get(i).setValue(0);
        }
        fields.get(0).setValue(10);
        SudokuColumn col = new SudokuColumn(fields);
        assertFalse(col.verify(10));
        assertTrue(col.verify(1));
    }

    @Test
    public void testCorrectDigitColumns() {
        Set<Integer> digitsInRow = new HashSet<>();
        BackTrackSudokuSolver solver = new BackTrackSudokuSolver();
        SudokuBoard sudoku = new SudokuBoard(new int[9][9], solver);
        sudoku.solveGame();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                digitsInRow.add(sudoku.getColumn(i).getFieldInCol(j));
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
        SudokuColumn col = new SudokuColumn(fields);

        Logger logger = Logger.getLogger(SudokuColumnTest.class.getName());
        logger.config(col.toString());
    }

    @Test
    public void testEqualsMethodShouldReturnFalseForNull() {
        SudokuColumn sudokuCol = new SudokuColumn();
        SudokuColumn sudokuCol2 = null;

        assertFalse(sudokuCol.equals(sudokuCol2));
    }

    @Test
    public void testEqualsMethodShouldReturnFalseForDifferentClassObjects() {
        SudokuRow sudokuRow = new SudokuRow();
        SudokuColumn sudokuCol2 = new SudokuColumn();

        assertFalse(sudokuCol2.equals(sudokuRow));
    }

    @Test
    public void testEqualsMethod() {
        SudokuColumn sudokuColumn = new SudokuColumn();
        SudokuColumn sudokuCol2 = new SudokuColumn();

        assertTrue(sudokuColumn.equals(sudokuCol2));
    }

    @Test
    public void testHashCodeMethod() {
        SudokuColumn sudokuColumn = new SudokuColumn();
        SudokuColumn sudokuCol2 = new SudokuColumn();

        int col1HashCode = sudokuColumn.hashCode();
        int col2HashCode = sudokuCol2.hashCode();

        assertEquals(col1HashCode, col2HashCode);
    }

    @Test
    public void testColumnClone() throws CloneNotSupportedException {
        SudokuColumn sudokuColumn = new SudokuColumn();
        SudokuColumn sudokuColumn2 = (SudokuColumn) sudokuColumn.clone();
        assertEquals(sudokuColumn, sudokuColumn2);
    }
}
