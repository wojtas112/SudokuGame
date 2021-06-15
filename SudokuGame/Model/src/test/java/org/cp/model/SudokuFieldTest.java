package org.cp.model;


import org.cp.model.Models.SudokuColumn;
import org.cp.model.Models.SudokuField;
import org.junit.Test;
import static org.junit.Assert.*;

public class SudokuFieldTest {

    @Test
    public void testSudokuFieldGetAndSetMethods() {
        SudokuField f = new SudokuField();
        f.setValue(33);
        assertEquals(33, f.getFieldValue());
    }

    @Test
    public void testToStringMethod() {
        SudokuField f = new SudokuField();
        f.setValue(33);
        Integer actual = f.getFieldValue();
        String expected = "33";
        assertEquals(expected, actual.toString());
    }

    @Test
    public void testEqualsMethodShouldReturnFalseForNull() {
        SudokuField f = new SudokuField();
        SudokuField f2 = null;

        assertFalse(f.equals(f2));
    }

    @Test
    public void testEqualsMethodShouldReturnFalseForDifferentClassObjects() {
        SudokuField f = new SudokuField();
        SudokuColumn sudokuCol2 = new SudokuColumn();

        assertFalse(f.equals(sudokuCol2));
    }

    @Test
    public void testEqualsMethod() {
        SudokuField f = new SudokuField();
        SudokuField f2 = new SudokuField();

        assertTrue(f.equals(f2));
    }

    @Test
    public void testHashCodeMethod() {
        SudokuField f1 = new SudokuField();
        SudokuField f2 = new SudokuField();

        int f1HashCode = f1.hashCode();
        int f2HashCode = f2.hashCode();

        assertEquals(f1HashCode, f2HashCode);
    }

    @Test
    public void testFieldCompareTo() {
        SudokuField f1 = new SudokuField();
        SudokuField f2 = new SudokuField();
        f1.setValue(2);
        f2.setValue(2);
        assertEquals(0, f1.compareTo(f2));

        f2.setValue(3);
        assertEquals(-1, f1.compareTo(f2));

        f2.setValue(1);
        assertEquals(1, f1.compareTo(f2));
    }

    @Test
    public void cloneFieldTest() throws CloneNotSupportedException {
        SudokuField f1 = new SudokuField();
        f1.setValue(1);
        SudokuField f2 = (SudokuField) f1.clone();
        assertEquals(f1, f2);
    }
}
