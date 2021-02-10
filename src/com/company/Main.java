package com.company;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        long startTime = System.nanoTime();

        String PATH = "src/com/company/10m_2021.txt";
        DataTask dataTask = new DataTask(PATH);

        System.out.println("Медиана: " + dataTask.Median());
        dataTask.doTask();
        long endTime = System.nanoTime();
        long delta = endTime - startTime;
        System.out.println("Время выполнения: "+TimeUnit.NANOSECONDS.toSeconds(delta));
    }
}
