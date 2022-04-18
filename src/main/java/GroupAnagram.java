import java.util.*;

public class GroupAnagram {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> cache = new HashMap<String,List<String>>();
        for (String str : strs)
        {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String key = String.valueOf(c);
            if(cache.containsKey(key))
            {
                List temp =cache.get(key);
                temp.add(str);
            }
            else
            {
                List temp = new ArrayList<String>();
                temp.add(str);
                cache.put(key,temp);
            }
        }
        return new ArrayList<>(cache.values());

    }
}
