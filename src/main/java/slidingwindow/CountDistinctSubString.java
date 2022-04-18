package slidingwindow;
import java.util.HashSet;
import java.util.Set;

public class CountDistinctSubString {

    public static int countGoodSubstrings(String s) {
        int ans=0;
        for(int i=0;i<=s.length()-3;i++){
            Set<Character> set=new HashSet<>();
            set.add(s.charAt(i));
            set.add(s.charAt(i+1));
            set.add(s.charAt(i+2));
            if(set.size()==3){
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(CountDistinctSubString.countGoodSubstrings("owuxoelszb"));
    }
}
