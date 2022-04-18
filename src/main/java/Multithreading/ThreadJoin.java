package Multithreading;

public class ThreadJoin implements Runnable {


    public synchronized void  execute()
    {
        int count =0;
        while(count <=10)
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("In Thread: " +Thread.currentThread().getName());
            System.out.println("count: "+count);
            count++;
        }
    }
    @Override
    public void run() {
        execute();

 }

    public static void main(String[] args) throws InterruptedException {
        Runnable r1 = new ThreadJoin();
        Thread t1 = new Thread(r1,"Thread 1");
        t1.start();
        Runnable r2 = new ThreadJoin();
        Thread t2 = new Thread(r1,"Thread 2");
        t2.start();
        t1.join();
        t2.join();
        System.out.println("In main...");

    }
}

