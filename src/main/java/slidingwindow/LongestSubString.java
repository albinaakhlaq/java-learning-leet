package slidingwindow;

import java.util.HashSet;

public class LongestSubString {

    public int lengthOfLongestSubstring(String s) {
        int max_length =0;
        int acquire = 0 ;
        int release =0;
        HashSet<Character> set = new HashSet<>();
        char[] input = s.toCharArray();
        while(acquire < s.length())
        {
            if(!set.contains( input[acquire]))
            {
                set.add(input[acquire]);
                max_length = Math.max(max_length,acquire-release+1);
                acquire++;
            }
            else
            {
                set.remove(input[release]);
                release++;
            }
        }
        return max_length;
    }
}
