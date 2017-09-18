package geometry.userinterface;

import geometry.Main;
import geometry.objects.*;

public class Multithreading {
    private Multithreading() { }

    public static void multiThread(MyObject[] shapes){
        for (int i = 0; i < shapes.length; i++){
            final int INDEX = i;
            new Thread(()-> shapes[INDEX].action()).start();
        }
    }

    public static void optimalThread(MyObject[] shapes){
        for (int i = 0; i < shapes.length/2; i++){
            final int INDEX = i;
            new Thread(()-> shapes[INDEX].action()).start();
        }
        for (int i = shapes.length/2; i < shapes.length; i++){
            final int INDEX = i;
            new Thread(()-> shapes[INDEX].action()).start();
        }
    }

    public static void singleThread(MyObject[] shapes){
        new Thread(()-> {
            while (Main.isActive) {
                for (int i = 0; i < shapes.length; i++) {
                    shapes[i].move();
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
