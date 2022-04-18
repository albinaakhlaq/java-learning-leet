package PriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LexicographicalSort {


    public int findKthNumber(int n, int k) {

        PriorityQueue<String> queue = new PriorityQueue<String>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        for(int i=1 ;i<=n;i++){
            queue.add(i+"");
        }
        int counter =1;
        int value = Integer.MAX_VALUE;
        while(!queue.isEmpty() && counter <=k)
        {
            value =Integer.parseInt(queue.poll());
            counter++;
        }

        return value;

    }


    public static void main(String[] args) {
        LexicographicalSort sort = new LexicographicalSort();
        System.out.println( sort.findKthNumber(13,2));
    }
}

