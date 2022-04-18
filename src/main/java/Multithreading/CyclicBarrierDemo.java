package Multithreading;

import java.util.*;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierDemo {

    class Worker implements Runnable{

        private final List<List<Integer>> caches;
        private final CyclicBarrier barrier;

        public Worker(List<List<Integer>> caches, CyclicBarrier barrier)
        {
            this.caches= caches;
            this.barrier = barrier;
        }

        @Override
        public void run() {
            System.out.println("Starting Thread: "+Thread.currentThread().getName());
            List<Integer> local = new ArrayList<>();
            Random ran = new Random();
            for (int i = 0; i < 4; i++) {
                local.add(ran.nextInt(4000));
            }
            this.caches.add(local);
            System.out.println("Added by Thread: "+Thread.currentThread().getName() + " cache = "+ Arrays.toString(local.toArray()));
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("Exiting Thread: "+Thread.currentThread().getName());
        }
    }

    class PostWorker implements Runnable{

        private final List<List<Integer>> caches;

        public PostWorker(List<List<Integer>> caches)
        {
            this.caches= caches;
        }
        @Override
        public void run() {
            System.out.println("Starting aggregator Thread: "+Thread.currentThread().getName());
             int totalSum =0;
             for(List<Integer> cache :caches)
             {
                for (Integer data:cache) {
                 totalSum =totalSum+data;
                 }
             }
                System.out.println("TotalSum: "+totalSum);
        }
    }

    public void orchestrate()
    {
        List<List<Integer>> caches = Collections.synchronizedList(new ArrayList<>());
        CyclicBarrier barrier = new CyclicBarrier(4,new PostWorker(caches));
        ExecutorService service = Executors.newFixedThreadPool(4);
        for (int i = 0; i <4 ; i++) {
            service.execute(new Worker(caches,barrier));

        }
        service.shutdown();
    }


    public static void main(String[] args) {
        CyclicBarrierDemo demo = new CyclicBarrierDemo();
        demo.orchestrate();
        System.out.println("Exiting Thread: "+Thread.currentThread().getName());


    }
}
