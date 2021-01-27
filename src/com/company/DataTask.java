package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class DataTask {
    private int array[];

    public DataTask(String path) {

        File file = new File(path);
        Scanner scanner = null;
        Scanner scanner2 = null;
        try {
            scanner = new Scanner(file);
            scanner2 = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int i = 0;
        while (scanner.hasNextLine()){
            if (tryParseInt(scanner.nextLine())!=null) i++; //кол-во строк в файле
        }
        array = new int[i];     //создание масива необходимого размера

        String line;
        i = 0;
        while (scanner2.hasNextLine()){     //заполнение масива
            line = scanner2.nextLine();
            if (tryParseInt(line)!=null) {
                array[i] = tryParseInt(line);
                i++;
            }
        }

    }

    public int Max() {
        int max = -2147483648;  //мін значення int
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) max = array[i];
        }
        return max;
    }

    public int Min() {
        int min = 2147483647;  //max значення int
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) min = array[i];
        }
        return min;
    }

    public double Median() {
        int [] array2 = array.clone();
        Arrays.sort(array2);
        if (array2.length % 2 == 0)
            return ((double)array2[array2.length/2] + (double)array2[array2.length/2 - 1])/2;
        else
            return (double)array2[array2.length/2];
    }

    public double AVG() {
        long sum = 0;
        for (int i = 0; i < array.length; i++) sum+=array[i];
        return (double)sum/array.length;
    }

    public int Increase() {
        int count = 1;
        int rez = 0;
        int last = 0;
        for (int i = 0; i < array.length-1; i++) {
            if (array[i] < array[i+1]) {
                count++;
                if (rez < count) {rez=count;last = i; }
            }
            else {
                count = 1;
            }
            if (rez < count) {
                last = i;
                rez = count;
            }
        }
        for (int i = (last+1) - (rez-1); i <=last+1; i++) System.out.println(array[i] + " ");
        return rez;

    }

    public int Decreases() {
        int count = 1;
        int rez = 0;
        int last = 0;
        for (int i = 0; i < array.length-1; i++) {
            if (array[i] > array[i+1]) {
                count++;
                if (rez < count) {rez=count;last = i; }
            }
            else {
                count = 1;
            }
            if (rez < count) {
                last = i;
                rez = count;
            }
        }
        for (int i = (last+1) - (rez-1); i <=last+1; i++) System.out.println(array[i] + " ");
        return rez;
    }

    private Integer tryParseInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e ) { return null;}
    }

}
