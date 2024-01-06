import java.util.Arrays;

public class LongestSubstring {
    public static int[] solution(String input)
    {
        int[] output = new int [2];
        int start =0;
        int end =0;
        int running_sum =0;       
        while(end < input.length())
        {
            if(input.charAt(start) == input.charAt(end))
            {
                running_sum =Math.max(running_sum, end-start+1);
                output[0] =start;output[1] =running_sum;
                end++;
            }
            else{
                start =end;
            }
        }
        return output ;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("aaaabbbbbbbbccddddeeeeeeeeeeeee")));
    }
}
