package org.compprog;

import org.cp.model.Models.SudokuBoard;

import java.util.Random;

public class DifficultyLevel {
    public SudokuBoard removeNumbers(int size, SudokuBoard sudoku) {
        Random random = new Random();
        int i = 0;
        while(i != size) {
            int x = random.nextInt(9);
            int y = random.nextInt(9);
            if(sudoku.get(x,y) != 0) {
                sudoku.set(x,y,0);
                i++;

            }
        }
        return sudoku;
    }

    public SudokuBoard chooseDifficulty(String difficulty, SudokuBoard sudoku) {
        switch(difficulty) {
            case "Easy": {
                sudoku = removeNumbers(20, sudoku);
                break;
            }
            case "Medium": {
                sudoku = removeNumbers(40, sudoku);
                break;
            }
            case "Hard": {
                sudoku = removeNumbers(50, sudoku);
                break;
            }
        }
        return sudoku;
    }
}
