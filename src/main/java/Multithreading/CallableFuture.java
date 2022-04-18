package Multithreading;



import java.util.Random;
import java.util.concurrent.*;

public class CallableFuture implements Callable<Integer> {

    private final String name;

    public CallableFuture(String name)
    {
        this.name = name;
    }

    @Override
    public Integer call() throws Exception {
        Random ran = new Random();
        int duration =ran.nextInt(3000);
        System.out.println("Starting "+ this.name);
        Thread.sleep(duration);
        System.out.println("Finished "+ this.name);
        return duration;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 4; i++) {
            Future<Integer> fut =service.submit(new CallableFuture("Task: " + 1000+i));
            try {
                System.out.println("Duration: "+fut.get());
            }catch (ExecutionException | InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        service.shutdown();
        System.out.println("In main");


    }


}