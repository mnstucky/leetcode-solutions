#include <vector>
using namespace std;

class Solution
{
public:
    int lengthOfLIS(vector<int> &nums)
    {
        // Store the longest increasing subsequence, sorted
        vector<int> subsequence;
        for (int &num : nums)
        {
            // Check where to insert num in the current longest increasing subsequence using binary search
            auto position = lower_bound(subsequence.begin(), subsequence.end(), num);
            // If the num belongs at the end, add it
            if (position == subsequence.end())
            {
                subsequence.push_back(num);
            }
            // If the num doesn't belong at the end, replace the number at position with num
            else
            {
                *position = num;
            }
        }
        // The result will be the correct size of the longest subsequence, even if subsequence isn't the longest subsequence itself
        return subsequence.size();
    }
};