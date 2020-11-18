package se.hernebring.ovningar24;

public class HelloWorldThreadLambda implements Runnable{
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for(int i = 0; i < 1000; i++){
                System.out.print("Hello ");
            }
        });
        thread.start();
        for(int i = 0; i < 1000; i++){
            System.out.print(" World");
        }
        if(thread != null){
            thread.join();
        }
        System.out.println("Time to quit.");
    }

    @Override
    public void run() {
        for(int i = 0; i < 1000; i++){
            System.out.print("Hello ");
        }
    }
}
