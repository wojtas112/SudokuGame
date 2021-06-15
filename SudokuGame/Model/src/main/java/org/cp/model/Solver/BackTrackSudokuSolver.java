package org.cp.model.Solver;


import java.io.Serializable;
import org.cp.model.Models.SudokuBoard;

import java.util.ArrayList;
import java.util.Random;

public class BackTrackSudokuSolver implements SudokuSolver, Serializable {

    @Override
    public boolean solve(SudokuBoard sudoku, int row, int col) {

        if (col == 9) {
            col = 0;
            row++;

            if (row == 9) {
                return true;
            }
        }

        if (sudoku.get(row, col) != 0) {
            return solve(sudoku, row, col + 1);
        }

        Random gen = new Random();
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for (int i = 1; i < 10; i++) {
            nums.add(i);
        }
        while (!nums.isEmpty()) {
            int num = nums.get(gen.nextInt(nums.size()));
            nums.remove(Integer.valueOf(num));
            if (sudoku.checkBoard(row, col, num)) {
                sudoku.set(row, col, num);
                if (solve(sudoku, row, col + 1)) {
                    return true;
                }
                sudoku.set(row, col, 0);
            }
        }

        return false;
    }
}


