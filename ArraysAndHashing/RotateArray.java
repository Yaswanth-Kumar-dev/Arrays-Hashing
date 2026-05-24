package ArraysAndHashing;

/*
Problem:
Rotate the array to the right by k steps.

Example:
Input:
nums = [1,2,3,4,5,6,7]
k = 3

Output:
[5,6,7,1,2,3,4]

Approach:
Use reversal algorithm.

Steps:
1. Reverse entire array
2. Reverse first k elements
3. Reverse remaining elements

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class RotateArray {

    public void rotate(int[] nums, int k) {

        // Handle cases where k > array length
        k = k % nums.length;

        // Step 1:
        // Reverse complete array
        reverse(nums, 0, nums.length - 1);

        // Step 2:
        // Reverse first k elements
        reverse(nums, 0, k - 1);

        // Step 3:
        // Reverse remaining elements
        reverse(nums, k, nums.length - 1);
    }

    // Helper method to reverse array
    public void reverse(int[] nums, int left, int right) {

        while (left < right) {

            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }
}