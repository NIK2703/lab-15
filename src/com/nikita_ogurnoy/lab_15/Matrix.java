package com.nikita_ogurnoy.lab_15;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public interface Matrix {
    enum diogonalType {main, side};

    public void randomize(int minValue, int maxValue);
    public String toString();
    public default ArrayList<Integer> getDiogonal(diogonalType type) throws MatrixNotSquareException
    {
        if(!(getRow() == getColumn())) {
            throw new MatrixNotSquareException();
        }

        ArrayList<Integer> diog = new ArrayList<>(getRow());

        if(type == Matrix.diogonalType.main) {
            for (int i = 0; i < getRow(); i++) {
                diog.add(get(i,i));
            }
        }
        else
        {
            for (int i = 0; i < getRow(); i++) {
                diog.add(get(i, getRow() - i - 1));
            }
        }

        return  diog;
    };
    public int getRow();
    public int getColumn();
    public int get(int row, int column);
    public void set(int row, int column, int val);
    public default boolean haveCental(){
        return (getRow() == getColumn()) && ((getRow() ) % 2 == 1) && ((getColumn() ) % 2 == 1);
    }
}
