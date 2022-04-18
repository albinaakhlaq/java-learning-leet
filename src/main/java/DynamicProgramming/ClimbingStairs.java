package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;
class ClimbingStairs {
    public int climbStairs(int n) {
        Map<Integer,Integer> memo = new HashMap<Integer,Integer>();
        memo.put(1,1);
        memo.put(2,2);
        return climbStairs(n,memo);
    }

    public int climbStairs(int n,Map<Integer,Integer> memo) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        else {
            int sum = climbStairs(n - 1,memo) + climbStairs(n - 2,memo);
            memo.put(n, sum);
            return memo.get(n);
        }

    }
}