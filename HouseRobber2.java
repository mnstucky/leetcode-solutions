// https://leetcode.com/problems/house-robber-ii/submissions/

import java.util.Map;
import java.util.HashMap;

class HouseRobber2 {

    private Map<String, Integer> memo;

    HouseRobber2() {
        memo = new HashMap<>();
    }

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(robSequence(nums, 0, nums.length - 2), robSequence(nums, 1, nums.length - 1));
    }

    public int robSequence(int[] nums, int firstHouse, int lastHouse) {
        if (lastHouse == firstHouse) {
            return nums[firstHouse];
        }
        if (lastHouse < firstHouse) {
            return 0;
        }
        Integer chooseFirst = memo.get(firstHouse + 2 + "," + lastHouse);
        Integer chooseSecond = memo.get(firstHouse + 3 + "," + lastHouse);
        if (chooseFirst == null) {
            chooseFirst = robSequence(nums, firstHouse + 2, lastHouse);
            memo.put(firstHouse + 2 + "," + lastHouse, chooseFirst);
        }
        if (chooseSecond == null) {
            chooseSecond = robSequence(nums, firstHouse + 3, lastHouse);
            memo.put(firstHouse + 3 + "," + lastHouse, chooseSecond);
        }
        return Math.max(nums[firstHouse] + chooseFirst, nums[firstHouse + 1] + chooseSecond);
    }

    public static void main(String[] args) {
        HouseRobber2 tester = new HouseRobber2();
        System.out.println(tester.rob(new int[] { 1, 2, 1, 1 }));
    }

}