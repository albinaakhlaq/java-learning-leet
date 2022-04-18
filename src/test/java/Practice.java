import java.util.List;

public class Practice {

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        int start_pointer =0;
        for(int num : sequence)
        {
            while(num != array.get(start_pointer) && start_pointer < array.size())
            {
                start_pointer++;
            }
        }

        return sequence.get(sequence.size())== array.get(start_pointer);
    }

    public static void main(String[] args) {
        int[] nums = {1,0,0};
        int total =1;

        for(int num : nums)
        {

            total = total<<1 | num;
            System.out.println(total);
        }

    }
}
