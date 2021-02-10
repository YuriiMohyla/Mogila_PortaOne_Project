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

    public double Median() {
        int [] array2 = array.clone();
        Arrays.sort(array2);
        if (array2.length % 2 == 0)
            return ((double)array2[array2.length/2] + (double)array2[array2.length/2 - 1])/2;
        else
            return (double)array2[array2.length/2];
    }

    private Integer tryParseInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e ) { return null;}
    }

    public void doTask() {
        long sum = 0;                 //сумма елементов масива
        int min = Integer.MAX_VALUE;  //max значення int
        int max =  Integer.MIN_VALUE;  //мін значення int
        int count = 1;                //временная переменная
        int count2 = 1;               //временная переменная
        int rez = 0;                  //переменная хранит кол-во возрастающих
        int rez2 = 0;                 //переменная хранит кол-во спадающих
        int last = 0;                 //переменная хранит индекс последнего елемента из возрастающих
        int last2 = 0;                //переменная хранит индекс последнего елемента из спадающих
        for (int i = 0; i < array.length-1; i++) {
            sum+=array[i];                          //подсчет сумы

            if (array[i] > max) max = array[i];     //поиск максимального
            if (array[i] < min) min = array[i];     //поиск минемального

            /* поиск возростающих последовательностей    */
            if (array[i] < array[i+1]) {
                count++;
                if (rez < count) {
                    rez=count;
                    last = i;
                }
            }
            else {
                count = 1;
            }
            if (rez < count) {
                last = i;
                rez = count;
            }
            /* поиск спадающих последовательностей    */
            if (array[i] > array[i+1]) {
                count2++;
                if (rez2 < count2) {
                    rez2=count2;
                    last2 = i;
                }
            }
            else {
                count2 = 1;
            }
            if (rez2 < count2) {
                last2 = i;
                rez2 = count2;
            }
        }

        if (array[array.length-1] > max) max = array[array.length-1]; // цыкл не обходит последний елемент проверяем отдельно
        if (array[array.length-1] < min) min = array[array.length-1];
        sum+=array[array.length-1];   // цыкл не обходит последний елемент доавляэм его в сумму отдельно

        System.out.println("вывод возростающих");
        for (int i = (last+1) - (rez-1); i <=last+1; i++) {
            System.out.println(array[i] + " ");                     //вывод возростающих
        }
        System.out.println("вывод спадающих");
        for (int i = (last2+1) - (rez2-1); i <=last2+1; i++) {
            System.out.println(array[i] + " ");                     //вывод спадающих
        }

        System.out.println("Масимальное: " + max);
        System.out.println("Минимальное: " + min);
        System.out.println("Среднее: " + (double)sum/array.length);
        System.out.println("Наибольшие последовательности идущих подряд чисел, которые увеличиваются: " + rez);
        System.out.println("Наибольшие последовательности идущих подряд чисел, которые уменьшаются: " + rez2);
    }

}
