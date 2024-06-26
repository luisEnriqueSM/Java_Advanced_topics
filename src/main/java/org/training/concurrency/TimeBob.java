package org.training.concurrency;

class CountDown implements Runnable{

    String [] timeStr = { "Zero", "One", "Two", "Three", "Four",
                "Five", "Six", "Seven", "Eight", "Nice"};

    @Override
    public void run() {
        for (int i = 9; i >= 0; i--){
            try {
                System.out.println(timeStr[i]);
                Thread.sleep(1000);
            } catch (InterruptedException ie){
                ie.printStackTrace();
            }
        }
    }
}
public class TimeBob {

    public static void main(String[] args){
        Thread timer = new Thread(new CountDown());
        System.out.println("Starting 10 seconds count down...");
        timer.start();
        try {
            timer.join(); // Wait here until the timer Thread is finished.
        } catch (InterruptedException ex){
            ex.printStackTrace();
        }
        System.out.println("Boom!!");
    }
}
