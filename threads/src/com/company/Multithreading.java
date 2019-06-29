package com.company;

public class Multithreading {
    public static void main(String[] args) {
        MyThread t1 = new MyThread("t1");
        t1.start();
        MyThread t2 = new MyThread("t2");
        t2.start();
    }
}

class MyThread implements Runnable {

    private  Thread myThread;
    private String str;

    MyThread(String name) {
        str = name;
    }

    @Override
    public void run() {
        System.out.println("Thread running " + str);

        for (int i = 0; i < 4; i++) {
            System.out.println(i);
            System.out.println(str);
            try {
                Thread.sleep(1000);
                System.out.println(myThread.getPriority());
            } catch (InterruptedException e) {
                System.out.println("Thread has been interrupted");
            }
        }
    }

     void start() {
        System.out.println("Thread started");
        if (myThread == null) {
            myThread = new Thread(this, str);
            myThread.start();
        }

    }
}