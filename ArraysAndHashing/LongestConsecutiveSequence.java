package ArraysAndHashing;

import java.util.*;

/*
Problem:
Find length of longest consecutive sequence.

Approach:
Use HashSet and start counting only from sequence starts.

Time Complexity: O(n)
Space Complexity: O(n)
*/

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        for (int num : set) {

            if (!set.contains(num - 1)) {

                int current = num;
                int streak = 1;

                while (set.contains(current + 1)) {
                    current++;
                    streak++;
                }

                longest = Math.max(longest, streak);
            }
        }

        return longest;
    }
}