package Multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task implements Runnable{

    private final CountDownLatch latch;
    private final String taskId;
    public Task(CountDownLatch latch,String taskId)
    {
        this.latch =latch;
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("starting task: "+taskId);
        try {
            Thread.sleep(9000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task completed: "+taskId);
        latch.countDown();
    }
}

public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(5);
        CountDownLatch latch1 = new CountDownLatch(1);
        for (int i = 0; i < 5; i++) {
            Task task = new Task(latch1,"1001"+i );
            service.execute(task);
        }

        latch1.await();
        service.shutdown();
        System.out.println("Main thread executed");

    }



}
