package org.compprog;

import java.io.IOException;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import org.cp.model.DataAccess.Dao;
import org.cp.model.DataAccess.SudokuBoardDaoFactory;
import org.cp.model.Models.SudokuBoard;
import org.cp.model.Solver.BackTrackSudokuSolver;

public class SecondaryController {

    public GridPane sudokuBoardGrid;
    private SudokuBoard sudoku;


    @FXML
    public void fillGrid() {

        for (int col = 0; col < 9; col++) {
            for (int row = 0; row < 9; row++) {
                createTextField(row, col);
            }
        }
        //sudoku.display();

    }
    private void createTextField(int col, int row) {
        TextField textField = new TextField();
        textField.setMinSize(50,50);
        textField.setFont(Font.font(18));
        // restrict input to integers:
        textField.setTextFormatter(new TextFormatter<Integer>(c -> {
            if (c.getControlNewText().matches("\\d?")) {
                return c ;
            } else {
                return null ;
            }
        }));
        if(sudoku.get(row, col) != 0) {
            textField.setText(String.valueOf(sudoku.get(row,col)));
            //textField.setDisable(true);
        }
        sudokuBoardGrid.add(textField, col, row);
    }

    @FXML
    private void initialize() {
        BackTrackSudokuSolver solver = new BackTrackSudokuSolver();
        sudoku = new SudokuBoard(new int[9][9], solver);
        sudoku.solveGame();
        DifficultyLevel lvl = new DifficultyLevel();
        sudoku = lvl.chooseDifficulty(App.getLevel(), sudoku);

        fillGrid();
    }

    public Node getNodeByRowColumnIndex(final int row,final int column,GridPane gridPane) {
        Node result = null;
        ObservableList<Node> childrens = gridPane.getChildren();
        for(Node node : childrens) {
            if(gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == column) {
                result = node;
                break;
            }
        }
        return result;
    }

    @FXML
    private void save() throws Exception {
        Dao<SudokuBoard> d = SudokuBoardDaoFactory.getFileDao("SudokuBoardFile");
        for(int i = 0; i<9; i++) {
            for(int j=0; j<9; j++) {
                String fieldValue = ((TextField) sudokuBoardGrid
                        .getChildren().get(i* 9 + j)).getText();

                if(!fieldValue.equals(String.valueOf(sudoku.get(i, j))) && !fieldValue.equals("")) {
                    sudoku.set(i,j,Integer.parseInt(fieldValue));
                }
            }
        }
        d.write(sudoku);
    }

    @FXML
    private void load() throws Exception {
        Dao<SudokuBoard> d = SudokuBoardDaoFactory.getFileDao("SudokuBoardFile");
        sudoku = d.read();
        sudokuBoardGrid.getChildren().removeAll();
        fillGrid();

    }

}