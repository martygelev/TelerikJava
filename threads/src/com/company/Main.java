package com.company;
public class Main implements Runnable {

    public static void main(String[] args) {

        Thread myThread = new Thread(" thread 1 ");
        Thread myThread2 = new Thread( "thread 2 ");

        myThread.start();
        myThread2.start();

        System.out.println(myThread.getName() + "name");
        System.out.println(myThread.getPriority() + "priority");

        System.out.println(myThread2.getPriority() + "priority 2 ");

        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        myThread.setPriority(1);
        System.out.println(myThread.getPriority() + " priority changed");

    }

    @Override
    public void run() {

    }
}
