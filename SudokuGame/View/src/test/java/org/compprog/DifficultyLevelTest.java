package org.compprog;

import org.cp.model.Models.SudokuBoard;
import org.cp.model.Solver.BackTrackSudokuSolver;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DifficultyLevelTest {

    private SudokuBoard sudokuBoard;
    private DifficultyLevel difficultyLevel;
    private BackTrackSudokuSolver solver;

    @Before
    public void setUp() {
        solver = new BackTrackSudokuSolver();
        sudokuBoard = new SudokuBoard(new int[9][9], solver);
        sudokuBoard.solveGame();
        difficultyLevel = new DifficultyLevel();
    }

    @Test
    public void checkLevelEasy() {
        sudokuBoard = difficultyLevel.chooseDifficulty("Easy", sudokuBoard);
        int emptyFields = 0;
        for(int i = 0; i<9; i++) {
            for(int j = 0; j<9; j++) {
                if(sudokuBoard.get(i,j) == 0) {
                    emptyFields++;
                }
            }
        }
        assertEquals(20, emptyFields);
    }

    @Test
    public void checkLevelMedium() {
        sudokuBoard = difficultyLevel.chooseDifficulty("Medium", sudokuBoard);
        int emptyFields = 0;
        for(int i = 0; i<9; i++) {
            for(int j = 0; j<9; j++) {
                if(sudokuBoard.get(i,j) == 0) {
                    emptyFields++;
                }
            }
        }
        assertEquals(40, emptyFields);
    }

    @Test
    public void checkLevelHard() {
        sudokuBoard = difficultyLevel.chooseDifficulty("Hard", sudokuBoard);
        int emptyFields = 0;
        for(int i = 0; i<9; i++) {
            for(int j = 0; j<9; j++) {
                if(sudokuBoard.get(i,j) == 0) {
                    emptyFields++;
                }
            }
        }
        assertEquals(50, emptyFields);
    }

}
