package org.cp.model;

import org.cp.model.DataAccess.Dao;
import org.cp.model.DataAccess.SudokuBoardDaoFactory;
import org.cp.model.Models.SudokuBoard;
import org.cp.model.Solver.BackTrackSudokuSolver;

public class Main {
    public static void main(String[] args) throws Exception {
        BackTrackSudokuSolver solver = new BackTrackSudokuSolver();
        SudokuBoard sudoku = new SudokuBoard(new int[9][9], solver);
        if (sudoku.solveGame()) {
            System.out.println("Sudoku Grid solved");
            sudoku.display();
        } else {
            System.out.println("Unsolvable");
        }

        Dao<SudokuBoard> d = SudokuBoardDaoFactory.getFileDao("SudokuBoardFile");
        d.write(sudoku);
        SudokuBoard sudokuBoard = d.read();
        System.out.println();
        sudokuBoard.display();
        sudokuBoard.display();
    }
}
