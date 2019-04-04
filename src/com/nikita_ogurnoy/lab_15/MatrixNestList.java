package com.nikita_ogurnoy.lab_15;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class MatrixNestList implements Matrix {
    int row;
    int column;
    ArrayList<ArrayList<Integer>> matrix;

    MatrixNestList(int row, int column)
    {
        this.row = row;
        this.column = column;
        matrix = new ArrayList<ArrayList<Integer>>(row);
        for(int i=0; i<row; i++)
        {
            matrix.add(new ArrayList<Integer>(column));
            for(int j=0; j<column; j++)
            {
                matrix.get(i).add(0);
            }
        }

    }

    public void randomize(int minValue, int maxValue)
    {
        Iterator<ArrayList<Integer>> rowIter = matrix.iterator();
        Random rand = new Random();

        while(rowIter.hasNext())
        {
            ArrayList<Integer> rowElement = rowIter.next();
            for(int i=0; i<row; i++)
            {
                matrix.get(i).clear();
                for(int j=0; j<column; j++)
                {
                    matrix.get(i).add(rand.nextInt(maxValue - minValue) + minValue);
                }
            }
        }
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for(ArrayList<Integer> row : matrix)
        {
            for(Integer el : row)
            {
                sb.append(el + " ");
            }
            sb.append("\n");
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
        return matrix.get(row).get(column);
    }

    public void set(int row, int column, int val)
    {
        matrix.get(row).set(column, val);
    }
}
