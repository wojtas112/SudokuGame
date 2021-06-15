package org.cp.model.DataAccess;

import org.cp.model.Models.SudokuBoard;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileSudokuBoardDao implements Dao<SudokuBoard> {

    private static final ResourceBundle bundle = ResourceBundle.getBundle("logMessages");
    private static final Logger logger = Logger.getLogger(FileSudokuBoardDao.class.getName());

    private String fileName;
    private Path filePath;
    private BufferedReader reader;

    public String getLogMessage(String key) {
        return bundle.getString(key);
    }

    public FileSudokuBoardDao(String fileName) throws DaoException{
        if(fileName == null) {
            throw new DaoException(DaoException.NULL_NAME);
        }
        this.fileName = fileName;
        this.filePath = Paths.get(fileName);
    }

    @Override
    public void write(SudokuBoard obj) throws DaoException{
        try {
            //reader = Files.newBufferedReader(filePath);
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(obj);
            objectOut.close();
            logger.log(Level.SEVERE, getLogMessage("write.message"));

        } catch (Exception ex) {
            throw new DaoException(DaoException.WRITE_ERROR, ex);
        }
    }

    @Override
    public SudokuBoard read() throws DaoException {
        try {
            //reader = Files.newBufferedReader(filePath);
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            Object obj = objectIn.readObject();

            logger.log(Level.SEVERE, getLogMessage("read.message"));
            objectIn.close();
            return (SudokuBoard) obj;

        } catch (Exception ex) {
            throw new DaoException(DaoException.READ_ERROR, ex);
        }
    }

    @Override
    public void close() throws IOException {
        if(reader != null) {
            reader.close();
        }
    }
}