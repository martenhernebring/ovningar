package se.hernebring.ovningar24;

import java.util.concurrent.ConcurrentLinkedQueue;

public class PrintPrimesWithEight implements Runnable {
    private ConcurrentLinkedQueue<Integer> queue;

    public PrintPrimesWithEight(ConcurrentLinkedQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted() || !queue.isEmpty()){
            Integer prime = queue.poll();
            if (prime != null && (Integer.toString(prime)).indexOf('8') >= 0) {
                System.out.println(prime);
            }
        }
    }
}
