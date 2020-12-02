package se.hernebring.ovningar24;

import java.util.concurrent.ConcurrentLinkedQueue;

public class PrimeMain {
    public static void main(String[] args) {
        var queue = new ConcurrentLinkedQueue<Integer>();
        var adder = new PrimeQueueThread(queue);
        var printer = new PrintPrimesWithEight(queue);
        Thread addThread = new Thread(adder);
        addThread.start();
        Thread printThread = new Thread(printer);
        printThread.start();
        try {
            addThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        printThread.interrupt();
        try {
            printThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
