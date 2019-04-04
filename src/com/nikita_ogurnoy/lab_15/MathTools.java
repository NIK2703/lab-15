package com.nikita_ogurnoy.lab_15;

import java.util.ArrayList;

public class MathTools {
    double average(ArrayList<Integer> m)
    {
        int len = m.size();
        double sum = 0;
        for(int i=0; i<len; i++)
        {
            sum += m.get(i);
        }
        return sum/len;
    }
}
