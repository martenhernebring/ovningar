package se.hernebring.ovningar24;

import java.util.concurrent.ConcurrentLinkedQueue;

public class PrimeQueueThread implements Runnable {
    private ConcurrentLinkedQueue<Integer> queue;

    public PrimeQueueThread(ConcurrentLinkedQueue<Integer> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10_000; i++){
            if(isPrime(i)){
                queue.add(i);
            }
        }
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i <= num / 2; ++i) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
