package geometry.userinterface;

import geometry.Main;
import geometry.objects.*;

import java.util.Arrays;

public class Multithreading {
    private Multithreading() { }

    public static void multiThread(MyObject[] shapes){
        for (int i = 0; i < shapes.length; i++){
            final int INDEX = i;
            new Thread(()-> shapes[INDEX].action()).start();
        }
    }

    public static void optimalThread(MyObject[] shapes) throws InterruptedException {
        int size = shapes.length;
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println(cores);
        int range = size/cores;

        for (int i = 0; i < cores; i++){
            int from = i*range;
            int to = (i == cores - 1) ? (size) : (from + range);
            singleThread(Arrays.copyOfRange(shapes, from, to));
        }
    }

    public static void singleThread(MyObject[] shapes){
        new Thread(()-> {
            while (Main.isActive) {
                for (int i = 0; i < shapes.length; i++) {
                    shapes[i].move();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
