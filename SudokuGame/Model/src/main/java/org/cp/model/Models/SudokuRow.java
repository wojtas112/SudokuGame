package org.cp.model.Models;

import java.io.Serializable;
import java.util.ArrayList;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class SudokuRow implements Serializable {

    private final ArrayList<SudokuField> row;

    public SudokuRow() {
        row = new ArrayList<>();
    }

    public SudokuRow(ArrayList<SudokuField> row) {
        this.row = row;

    }

    public int getFieldInRow(int i) {
        return this.row.get(i).getFieldValue();
    }

    public boolean verify(int value) {

        for (int i = 0; i < this.row.size(); i++) {

            if (this.row.get(i).getFieldValue() == value) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("row", row)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SudokuRow sudokuRow = (SudokuRow) o;

        return new EqualsBuilder()
                .append(row, sudokuRow.row)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(row)
                .toHashCode();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        SudokuRow clonedRow = new SudokuRow();
        clonedRow = this;
        return clonedRow;
    }
}

