package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class MinPathSum {

    public int uniquePaths(int m, int n) {

        Map<String,Integer> cache = new HashMap<String,Integer>();
        return path(m,n,cache);

    }

    public int path(int m, int n, Map<String,Integer> cache)
    {
        if (m ==0 || n ==0) return 0;
        if (m == 1 && n ==1) return 1;
        String key = m+"-"+n;
        if (cache.containsKey(key))
        {
            return cache.get(key);
        }
        else
        {
            int sum = path(m-1,n,cache)+ path(m,n-1,cache);
            cache.put(key,sum);
            return cache.get(key);
        }

    }
}
