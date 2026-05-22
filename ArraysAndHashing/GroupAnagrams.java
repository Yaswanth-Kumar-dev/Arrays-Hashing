package ArraysAndHashing;

import java.util.*;

/*
Problem:
Group strings that are anagrams together.

Approach:
Sort every string and use sorted string as key.

Time Complexity: O(n * k log k)
Space Complexity: O(n)
*/

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            char[] arr = str.toCharArray();
            Arrays.sort(arr);

            String key = new String(arr);

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}