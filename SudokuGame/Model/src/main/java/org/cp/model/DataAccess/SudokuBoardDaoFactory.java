package org.cp.model.DataAccess;

public class SudokuBoardDaoFactory {

    public static Dao getFileDao(String fileName) throws DaoException {
        return new FileSudokuBoardDao(fileName);
    }
}
