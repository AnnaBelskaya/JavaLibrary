package library;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class Library {
    public static Scanner sc = new Scanner(System.in);
    public static Semaphore semaphore;
    public static int inside = 0;
    public static int maxNumber;

    public static void main(String[] args) throws InterruptedException, IOException {
        ReentrantLock locker = new ReentrantLock();

        System.out.print("Количество посетителей: ");
        int peopleNumber = sc.nextInt();

        System.out.print("Вместимомсть библиотеки: ");
        maxNumber = sc.nextInt();
        semaphore = new Semaphore(maxNumber);

        for (int i = 0; i < peopleNumber; i++) {
            new Thread(new Visitor(i+1, locker)).start();
            Thread.sleep(200);
        }
    }
}