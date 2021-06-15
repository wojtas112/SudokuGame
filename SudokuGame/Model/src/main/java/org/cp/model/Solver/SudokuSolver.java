package org.cp.model.Solver;

import org.cp.model.Models.SudokuBoard;

public interface SudokuSolver {

    public boolean solve(SudokuBoard sudoku, int row, int col);
}
