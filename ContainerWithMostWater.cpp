// https://leetcode.com/problems/container-with-most-water/

// Runtime: 12 ms, faster than 99.51% of C++ online submissions for Container With Most Water.
// Memory Usage: 17.7 MB, less than 89.96% of C++ online submissions for Container With Most Water.

#include <algorithm>
#include <vector>

class Solution
{
public:
    int maxArea(std::vector<int> &height)
    {
        auto front = height.begin();
        auto back = height.end();
        back--;
        int currentLength = height.size() - 1;
        int max = 0;
        while (front != back)
        {
            int currentSize = std::min(*front, *back) * currentLength;
            if (max < currentSize)
            {
                max = currentSize;
            }
            if (*front < *back)
            {
                front++;
                currentLength--;
            }
            else
            {
                back--;
                currentLength--;
            }
        }
        return max;
    }
};