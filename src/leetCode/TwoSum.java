package leetCode;

// https://leetcode.com/problems/two-sum/

import java.util.HashMap;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(nums[i])) {
                if (target == nums[i] * 2)
                    return new int[]{hash.get(nums[i]), i};
            }
            else 
                hash.put(nums[i], i);
            if (hash.containsKey(target - nums[i]) && hash.get(target - nums[i]) != i)
                return new int[]{hash.get(target - nums[i]), hash.get(nums[i])};
        }
        return new int[]{};
    }
}
