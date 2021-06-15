package org.cp.model.Models;

import java.io.Serializable;
import java.util.ArrayList;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class SudokuBox implements Serializable {

    private ArrayList<SudokuField> box;

    public SudokuBox() {
        box = new ArrayList<>();
    }

    public SudokuBox(ArrayList<SudokuField> box) {
        this.box = box;
    }

    public int getFieldInBox(int i) {
        return this.box.get(i).getFieldValue();
    }

    public boolean verify(int value) {
        for (int i = 0; i < 9; i++) {
            if (this.box.get(i).getFieldValue() == value) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("box", box)
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

        SudokuBox sudokuBox = (SudokuBox) o;

        return new EqualsBuilder()
                .append(box, sudokuBox.box)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(box)
                .toHashCode();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        SudokuBox clonedBox= new SudokuBox();
        clonedBox = this;
        return clonedBox;
    }
}


