// https://leetcode.com/problems/longest-increasing-subsequence/

// Runtime: 316 ms, faster than 26.06% of C++ online submissions for Longest Increasing Subsequence.
// Memory Usage: 10.6 MB, less than 62.66% of C++ online submissions for Longest Increasing Subsequence.

#include <vector>
using namespace std;

class Solution
{
public:
    int lengthOfLIS(vector<int> &nums)
    {
        vector<int> memo(nums.size(), 1);
        int result = 0;
        // Iterate backward through nums
        for (int i = nums.size() - 1; i >= 0; --i)
        {
            // Iterate forward for each value in nums
            int curMaxLen = 1;
            for (int j = i + 1; j < nums.size(); ++j)
            {
                if (nums.at(i) < nums.at(j)) {
                    if (memo[j] + 1 > curMaxLen)
                    {
                        curMaxLen = memo[j] + 1;
                    }
                }
            }
            memo[i] = curMaxLen;
            if (curMaxLen > result)
            {
                result = curMaxLen;
            }
        }
        return result;
    }
};