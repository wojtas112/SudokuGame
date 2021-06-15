package org.cp.model;


import org.cp.model.Solver.BackTrackSudokuSolver;
import org.cp.model.Models.SudokuField;
import org.cp.model.Models.SudokuBoard;
import org.cp.model.Models.SudokuBox;
import org.cp.model.Models.SudokuColumn;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import static org.junit.Assert.*;

//import static org.junit.jupiter.api.Assertions.*;
public class SudokuBoxTest {

    @Test
    public void testSudokuBoxClass() {
        ArrayList<SudokuField> fields = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            fields.add(new SudokuField());
            fields.get(i).setValue(i);
        }
        SudokuBox box = new SudokuBox(fields);
        for (int i = 0; i < 9; i++) {
            assertEquals(i, box.getFieldInBox(i));
        }
        fields.get(0).setValue(10);
        assertEquals(10, box.getFieldInBox(0));
    }

    @Test
    public void testVerifyInBox() {
        ArrayList<SudokuField> fields = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            fields.add(new SudokuField());
            fields.get(i).setValue(0);
        }
        fields.get(3).setValue(10);
        SudokuBox box = new SudokuBox(fields);
        assertFalse(box.verify(10));
        assertTrue(box.verify(1));
    }

    @Test
    public void testCorrectDigitBoxes() {
        Set<Integer> digitsInRow = new HashSet<>();
        BackTrackSudokuSolver solver = new BackTrackSudokuSolver();
        SudokuBoard sudoku = new SudokuBoard(new int[9][9], solver);
        sudoku.solveGame();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                digitsInRow.add(sudoku.getBox(i).getFieldInBox(j));
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
        SudokuBox box = new SudokuBox(fields);

        Logger logger = Logger.getLogger(SudokuBoxTest.class.getName());
        logger.config(box.toString());
    }

    @Test
    public void testEqualsMethodShouldReturnFalseForNull() {
        SudokuBox sudokuBox = new SudokuBox();
        SudokuBox sudokuBox2 = null;

        assertFalse(sudokuBox.equals(sudokuBox2));
    }

    @Test
    public void testEqualsMethodShouldReturnFalseForDifferentClassObjects() {
        SudokuBox sudokuBox = new SudokuBox();
        SudokuColumn sudokuCol2 = new SudokuColumn();

        assertFalse(sudokuBox.equals(sudokuCol2));
    }

    @Test
    public void testEqualsMethod() {
        SudokuBox sudokuBox = new SudokuBox();
        SudokuBox sudokuBox2 = new SudokuBox();

        assertTrue(sudokuBox.equals(sudokuBox2));
    }

    @Test
    public void testHashCodeMethod() {
        SudokuBox sudokuBox = new SudokuBox();
        SudokuBox sudokuBox2 = new SudokuBox();

        int box1HashCode = sudokuBox.hashCode();
        int box2HashCode = sudokuBox2.hashCode();

        assertEquals(box1HashCode, box2HashCode);
    }

    @Test
    public void testBoxClone() throws CloneNotSupportedException {
        SudokuBox sudokuBox = new SudokuBox();
        SudokuBox sudokuBox2 = (SudokuBox) sudokuBox.clone();

        assertEquals(sudokuBox,sudokuBox2);
    }
}