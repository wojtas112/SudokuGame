package org.cp.model.Models;

import java.io.Serializable;
import java.util.ArrayList;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class SudokuColumn implements Serializable {

    private ArrayList<SudokuField> column;

    public SudokuColumn() {
        column = new ArrayList<>();
    }

    public SudokuColumn(ArrayList<SudokuField> column) {
        this.column = column;
    }

    public int getFieldInCol(int i) {
        return this.column.get(i).getFieldValue();
    }

    public boolean verify(int value) {
        for (int i = 0; i < column.size(); i++) {
            if (this.column.get(i).getFieldValue() == value) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("column", column)
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

        SudokuColumn that = (SudokuColumn) o;

        return new EqualsBuilder()
                .append(column, that.column)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(column)
                .toHashCode();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        SudokuColumn clonedColumn = new SudokuColumn();
        clonedColumn = this;
        return clonedColumn;
    }
}


