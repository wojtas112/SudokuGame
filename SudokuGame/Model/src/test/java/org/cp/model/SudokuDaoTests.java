package org.cp.model;

import org.cp.model.DataAccess.Dao;
import org.cp.model.DataAccess.DaoException;
import org.cp.model.DataAccess.SudokuBoardDaoFactory;
import org.cp.model.Solver.BackTrackSudokuSolver;
import org.cp.model.DataAccess.FileSudokuBoardDao;
import org.cp.model.Models.SudokuBoard;
import org.junit.Test;
import static org.junit.Assert.*;

public class SudokuDaoTests {

    private BackTrackSudokuSolver solver;
    private SudokuBoard sudoku;
    private String name = "TestFile";

    public SudokuDaoTests() {

        solver = new BackTrackSudokuSolver();
        sudoku = new SudokuBoard(new int[9][9], solver);
        sudoku.solveGame();
    }

    @Test
    public void testOpenWithNull() {
        try {
            FileSudokuBoardDao dao = new FileSudokuBoardDao(null);
            fail();
        } catch(DaoException dex) {
            System.out.println("Dao exception was thrown correctly");
        }
    }

    @Test
    public void testReadWithWrongFile() throws DaoException {
        FileSudokuBoardDao dao = new FileSudokuBoardDao("WrongFile");
        try {
            dao.read();
            fail();
        } catch(DaoException dex) {
            System.out.println("Dao exception was thrown correctly");
        }
    }


    @Test
    public void ShouldReadProperSudokuBoardFromFile() throws DaoException {

        SudokuBoardDaoFactory daoF = new SudokuBoardDaoFactory();
        Dao<SudokuBoard> dataAccess = daoF.getFileDao(name);
        dataAccess.write(sudoku);
        SudokuBoard expectedSudokuBoard = dataAccess.read();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                assertEquals(expectedSudokuBoard.get(i, j), sudoku.get(i, j));
            }
        }
    }

}
