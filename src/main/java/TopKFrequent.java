

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequent {

    public static int[] solution(int[] input, int k)
    {
        int [] output = new int[k];
        Map<Integer,Integer> counter = new HashMap<>();
        for (int i : input) {
            counter.put(i, counter.getOrDefault(i, 0)+1);
        }
        Queue<Integer> q = new PriorityQueue<>((a,b) ->counter.get(a)- counter.get(b));
        for (Integer key : counter.keySet()) {
            q.add(key);
            if(q.size() > k) q.poll();
        }
       for (int i = 0; i < output.length; i++) {
         output[i] = q.poll();
       }
        return output;
    }

    public static void main(String[] args) {
        int[] input = new int[] {1,1,1,2,2,4};
        System.out.println(Arrays.toString(solution(input, 2)));


    }
    
}
