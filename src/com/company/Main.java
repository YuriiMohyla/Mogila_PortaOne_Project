package com.company;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.nanoTime();
        String PATH = "C:\\Users\\Yura\\IdeaProjects\\Mogila_PortaOne_Project\\src\\com\\company\\10m_2021.txt";
        DataTask dataTask = new DataTask(PATH);
        System.out.println("Масимальное: " + dataTask.Max());
        System.out.println("Минимальное: " + dataTask.Min());
        System.out.println("Медиана: " + dataTask.Median());
        System.out.println("Среднее: " + dataTask.AVG());
        System.out.println("Наибольшие последовательности идущих подряд чисел, которые увеличиваются: " + dataTask.Increase());
        System.out.println("Наибольшие последовательности идущих подряд чисел, которые уменьшаются: " + dataTask.Decreases());
        long endTime = System.nanoTime();
        long delta = endTime - startTime;
        System.out.println("Время выполнения: "+TimeUnit.NANOSECONDS.toSeconds(delta));
    }
}
