import java.util.Arrays;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        return intervals;
    }

    public static void main(String[] args) {
        MergeIntervals merge = new MergeIntervals();
        int[][] arr = {{1, 3}, {2, 7}};
        merge.merge(arr);
    }
}