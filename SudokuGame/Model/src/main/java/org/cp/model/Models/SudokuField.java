package org.cp.model.Models;

import java.io.Serializable;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class SudokuField implements Serializable, Cloneable, Comparable<SudokuField> {

    private int value;

    public SudokuField() {

        value = 0;
    }

    public int getFieldValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("value", value)
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

        SudokuField sudokuField = (SudokuField) o;

        return new EqualsBuilder()
                .append(value, sudokuField.value)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(value)
                .toHashCode();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        SudokuField clonedField = new SudokuField();
        clonedField.value = this.value;
        return clonedField;
    }


    @Override
    public int compareTo(SudokuField sudokuField) {
        return this.getFieldValue() - sudokuField.getFieldValue();
    }
}

