package org.cp.model;
import org.junit.Test;
import static org.junit.Assert.*;
import org.cp.model.Solver.BackTrackSudokuSolver;
import org.cp.model.Models.SudokuRow;
import org.cp.model.Models.SudokuBoard;

public class SudokuBoardTest {
    public SudokuBoardTest() {
    }

    @Test
    public void testSetAndGetBoardMethods() {
        BackTrackSudokuSolver solver = new BackTrackSudokuSolver();
        SudokuBoard sudoku = new SudokuBoard(new int[9][9], solver);
        sudoku.set(0, 0, 10);
        assertEquals(10, sudoku.get(0, 0));
    }

    @Test
    public void testCheckBoardMethod() {
        BackTrackSudokuSolver solver = new BackTrackSudokuSolver();
        SudokuBoard sudoku = new SudokuBoard(new int[9][9], solver);
        assertTrue(sudoku.checkBoard(0, 0, 5));
        sudoku.set(0, 0, 1);
        assertFalse(sudoku.checkBoard(0, 1, 1));
        assertFalse(sudoku.checkBoard(1, 0, 1));
        assertFalse(sudoku.checkBoard(1, 1, 1));
    }

    @Test
    public void testDifferentBoards() {
        BackTrackSudokuSolver solver = new BackTrackSudokuSolver();
        SudokuBoard sudoku = new SudokuBoard(new int[9][9], solver);
        SudokuBoard sudoku2 = new SudokuBoard(new int[9][9], solver);
        sudoku.solveGame();
        sudoku2.solveGame();

        assertNotEquals(sudoku, sudoku2);

    }

    @Test
    public void testToStringMethod() {
        BackTrackSudokuSolver solver = new BackTrackSudokuSolver();
        SudokuBoard sudoku = new SudokuBoard(new int[9][9], solver);
        sudoku.set(0, 0, 10);
        Integer actual = sudoku.get(0, 0);
        String expected = "10";
        assertEquals(expected, actual.toString());
    }

    @Test
    public void testEqualsMethodShouldReturnFalseForNull() {
        SudokuBoard sudoku = new SudokuBoard();
        SudokuBoard sudoku2 = null;

        assertFalse(sudoku.equals(sudoku2));
    }

    @Test
    public void testEqualsMethodShouldReturnFalseForDifferentClassObjects() {
        SudokuRow sudokuRow = new SudokuRow();
        SudokuBoard sudoku = new SudokuBoard();

        assertFalse(sudoku.equals(sudokuRow));
    }

    @Test
    public void testEqualsMethod() {
        SudokuBoard sudoku = new SudokuBoard();
        SudokuBoard sudoku2 = new SudokuBoard();

        assertTrue(sudoku.equals(sudoku2));
    }

    @Test
    public void testHashCodeMethod() {
        SudokuBoard sudoku = new SudokuBoard();
        SudokuBoard sudoku2 = new SudokuBoard();

        int sudoku1HashCode = sudoku.hashCode();
        int sudoku2HashCode = sudoku2.hashCode();

        assertEquals(sudoku1HashCode, sudoku2HashCode);
    }

    @Test
    public void testBoardClone() throws CloneNotSupportedException {
        BackTrackSudokuSolver solver = new BackTrackSudokuSolver();
        SudokuBoard sudokuBoard = new SudokuBoard(new int[9][9], solver);
        sudokuBoard.solveGame();
        SudokuBoard sudokuBoard2 = (SudokuBoard) sudokuBoard.clone();
        assertEquals(sudokuBoard, sudokuBoard2);
    }
}
