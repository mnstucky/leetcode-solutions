package leetCode;

import java.util.Arrays;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array/

public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {

        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
        	if (nums[i] == nums[i + 1]) count++;
        }
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == nums[i + 1]) {
                for (int j = i + 2; j < nums.length; j++) {
                    if (nums[i] != nums[j]) {
                        for (int k = i + 1; k < j; k++) {
                        	nums[k] = nums[j];
                        }
                        break;
                    }
                }
            }
        }
        return nums.length - count;

    }
    
    public static void main(String[] args) {
    	
    	int[] test1 = {1,1,2};
    	System.out.println(removeDuplicates(test1));
    	System.out.println(Arrays.toString(test1));

    	int[] test2 = {0,0,1,1,1,2,2,3,3,4};
    	System.out.println(removeDuplicates(test2));
    	System.out.println(Arrays.toString(test2));

		int[] test3 = {1,1};
		System.out.println(removeDuplicates(test3));
		System.out.println(Arrays.toString(test3));

    }
}
