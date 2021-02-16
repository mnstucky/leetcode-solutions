// https://leetcode.com/problems/3sum/

// Runtime: 84 ms, faster than 70.25% of C++ online submissions for 3Sum.
// Memory Usage: 19.8 MB, less than 96.23% of C++ online submissions for 3Sum.

#include <algorithm>
#include <vector>
#include <iostream>

class Solution
{
public:
    std::vector<std::vector<int>> threeSum(std::vector<int> &nums)
    {
        std::vector<std::vector<int>> result;
        int numsSize = nums.size();
        if (numsSize < 3) return result;
        std::sort(nums.begin(), nums.end());
        for (int anchor = 0; anchor < numsSize - 2; anchor++)
        {
            if (nums.at(anchor) > 0) break;
            if (anchor > 0 && nums.at(anchor) == nums.at(anchor - 1)) continue;
            int front = anchor + 1;
            int back = numsSize - 1;
            while (front < back)
            {
                int currentSum = nums.at(anchor) + nums.at(front) + nums.at(back);
                if (currentSum > 0) back--;
                else if (currentSum < 0) front++;
                else
                {
                    result.push_back(std::vector<int>{nums.at(anchor), nums.at(front), nums.at(back)});
                    int priorFront = nums.at(front);
                    int priorBack = nums.at(back);
                    while (front < back && nums.at(front) == priorFront) front++;
                    while (front < back && nums.at(back) == priorBack) back--;
                }
            }
        }
        return result;
    }
};