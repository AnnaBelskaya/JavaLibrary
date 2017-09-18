package library;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class Visitor implements Runnable{
    private int index;
    private ReentrantLock locker;

    public Visitor(int index, ReentrantLock locker) {
        this.index = index;
        this.locker = locker;
    }

    @Override
    public void run() {
        System.out.println("[" + index + "] подошёл ко входу в библиотеку. ");

        if (Library.inside==Library.maxNumber)
            System.out.println("[" + index + "] ждёт у входа в библиотеку.");

        try {
            Library.semaphore.acquire();
            Library.inside++;

            in();

            System.out.printf("[%d] вошёл в библиотеку.\t(%d/%d)\n", index,
                    Library.inside, Library.maxNumber);
            try {
                int t = randSeconds();
                System.out.printf("[%d] читает книгу %d мс.\n", index, t);
                Thread.sleep(t);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            out();
            Library.inside--;
            System.out.printf("[%d] вышел из бибилиотеки.\t(%d/%d)\n", index,
                    Library.inside, Library.maxNumber);
            Library.semaphore.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void out() throws InterruptedException {
        locker.lock();
        try {
            System.out.println("-------->[" + index + "] подошёл к двери изнутри");
            System.out.println("-------->[" + index + "] проходит через дверь наружу");
            Thread.sleep(500);
            System.out.println("-------->[" + index + "] прошёл через дверь наружу");
        } finally {
            locker.unlock();
        }
    }

    private void in() throws InterruptedException {
        locker.lock();
        try {
            System.out.println("-------->[" + index + "] подошёл к двери снаружи");
            System.out.println("-------->[" + index + "] проходит через дверь внутрь");
            Thread.sleep(500);
            System.out.println("-------->[" + index + "] прошёл через дверь внутрь");
        } finally {
            locker.unlock();
        }
    }

    private int randSeconds(){
        Random r = new Random();
        return (r.nextInt(4) + 1)*1000;
    }
}