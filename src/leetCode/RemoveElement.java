package leetCode;

// https://leetcode.com/problems/remove-element/

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == val) {
                for (int j = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                count++;
            }
        }
        return nums.length - count;
    }
}
