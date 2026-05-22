package ArraysAndHashing;

import java.util.*;

/*
Problem:
Return true if any value appears at least twice.

Approach:
Use HashSet.

Time Complexity: O(n)
Space Complexity: O(n)
*/

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {

            if (!set.add(num)) {
                return true;
            }
        }

        return false;
    }
}