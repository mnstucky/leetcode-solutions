// https://leetcode.com/problems/house-robber-ii/submissions/

// Runtime: 0 ms, faster than 100.00% of Java online submissions for House Robber II.
// Memory Usage: 38.6 MB, less than 6.23% of Java online submissions for House Robber II.

class HouseRobber2 {

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        // You can either choose to rob the first or the second house
        return Math.max(robSequence(nums, 0, nums.length - 2), robSequence(nums, 1, nums.length - 1));
    }

    public int robSequence(int[] nums, int firstHouse, int lastHouse) {
        // If your robSequence contains only one house, rob that house
        if (lastHouse == firstHouse) {
            return nums[firstHouse];
        }
        // If your robSequence has no houses, return 0 (nothing to steal)
        if (lastHouse < firstHouse) {
            return 0;
        }
        // Check all houses in order, choosing whether to rob the current house 
        int sumPriorHouseNotRobbed = 0, sumPriorHouseRobbed = 0;
        for (int currentHouse = firstHouse; currentHouse <= lastHouse; currentHouse++) {
            // Rob the current house if doing so nets more than keeping your total from robbing the prior house
            int currentMax = Math.max(nums[currentHouse] + sumPriorHouseNotRobbed, sumPriorHouseRobbed);
            // Update the totals
            sumPriorHouseNotRobbed = sumPriorHouseRobbed;
            sumPriorHouseRobbed = currentMax;
        }
        return sumPriorHouseRobbed;
    }

}