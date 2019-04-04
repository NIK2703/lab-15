package com.nikita_ogurnoy.lab_15;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Matrix matrix;
        Scanner scr = new Scanner(System.in);
        System.out.println("Введите число строк и столбцов матрицы:");
        int row = 0;
        int column = 0;
        while (true)
            try {
                row = scr.nextInt();
                column = scr.nextInt();
                if(row <= 0)
                {
                    throw new IOException("Число строк должно быть натуральным числом!");
                }
                if(column <= 0)
                {
                    throw new IOException("Число столбцов должно быть натуральным числом!");
                }

                break;
            }
            catch (java.util.InputMismatchException e)
            {
                System.out.println("Ошибка ввода! Повторите ввод:");
            }
            catch (IOException e)
            {
                System.out.println(e + " Повторите ввод:");
            }

        matrix = new MatrixNestList(row,column);			//		<<<<<<<<<<<<<<<<<<<
        //matrix = new MatrixList(row,column);

        matrix.randomize(-10, 10);
        System.out.println("Сгенерированая матрица:\n" + matrix);

        ArrayList<Integer> mainDiog = new ArrayList<Integer>();
        ArrayList<Integer> sideDiog = new ArrayList<Integer>();
        try {
            mainDiog = matrix.getDiogonal(Matrix.diogonalType.main);
            sideDiog = matrix.getDiogonal(Matrix.diogonalType.side);
        }
        catch (MatrixNotSquareException e)
        {
            System.out.println("Ошибка! Матрица не квадратная.");
        }


        try {
            if (!matrix.haveCental()) {
                throw new MatrixNotHaveCentralException();
            }

            MathTools math = new MathTools();
            double mainAv, sideAv;
            mainAv = math.average(mainDiog);
            sideAv = math.average(sideDiog);

            System.out.println("Среднее по главной диогонали:" + mainAv);
            System.out.println("Среднее по побочной диогонали:" + sideAv + "\n");

            double maxAv;
            if(mainAv > sideAv)
            {
                maxAv = mainAv;
            }
            else
            {
                maxAv = sideAv;
            }

            matrix.set(
                    matrix.getRow() / 2,
                    matrix.getColumn() / 2,
                    (int) Math.round(maxAv)
            );
            System.out.println("Матрица после изменения центрального элемента:\n" + matrix);
        }
        catch (MatrixNotHaveCentralException e)
        {
            System.out.println("Матрица не имеет центрального элемента.");
        }


    }
}
