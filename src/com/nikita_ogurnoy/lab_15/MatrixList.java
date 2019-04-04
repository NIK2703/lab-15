package com.nikita_ogurnoy.lab_15;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class MatrixList implements Matrix {
    int row;
    int column;
    int size;
    ArrayList<Integer> matrix;

    MatrixList(int row, int column)
    {
        this.row = row;
        this.column = column;
        size = row * column;
        matrix = new ArrayList<Integer>(size);
        for(int i=0; i< size; i++)
        {
                matrix.add(0);
        }

    }

    public void randomize(int minValue, int maxValue)
    {
        Iterator<Integer> rowIter = matrix.iterator();
        Random rand = new Random();
        matrix.clear();

            for(int i=0; i<size; i++)
            {
                matrix.add(rand.nextInt(maxValue - minValue) + minValue);
            }
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<size; i++)
        {
            sb.append(matrix.get(i) + " ");
            if((i+1) % column == 0)sb.append("\n");
        }
        return sb.toString();
    }


    public int getRow()
    {
        return row;
    }

    public int getColumn()
    {
        return column;
    }

    public int get(int row, int column)
    {
        return matrix.get(getRow() * row + column);
    };

    public void set(int row, int column, int val)
    {
        matrix.set(getRow() * row + column, val);
    }
}
