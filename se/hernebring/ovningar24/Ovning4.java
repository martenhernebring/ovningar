package se.hernebring.ovningar24;

public class Ovning4 implements Runnable{

    @Override
    public void run() {
        while(true){
            System.out.println("Hello World");
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Ovning4());
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(500);
    }
    
}
