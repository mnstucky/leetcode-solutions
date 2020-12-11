// https://leetcode.com/problems/longest-palindromic-substring/
//
// Runtime: 28 ms, faster than 82.30% of C++ online submissions for Longest Palindromic Substring.
// Memory Usage: 7.4 MB, less than 79.53% of C++ online submissions for Longest Palindromic Substring.

#include <string>
#include <iostream>
using namespace std;

class Solution
{
public:
	string longestPalindrome(string s)
	{
		int curIdx = 0, startIdx, endIdx, maxLength = 1, resultStartIdx = 0;
		while (curIdx < s.length() - 1)
		{
			if (s.at(curIdx) == s.at(curIdx + 1))
			{
				startIdx = curIdx;
				endIdx = startIdx + 1;
				while (true)
				{
					if (startIdx < 0 || endIdx >= s.length() || s.at(startIdx) != s.at(endIdx))
					{
						if (endIdx - startIdx - 1 > maxLength)
						{
							resultStartIdx = startIdx + 1;
							maxLength = endIdx - startIdx - 1;
						}
						break;
					}
					startIdx--;
					endIdx++;
				}
			}
			if (curIdx < s.length() - 2 && s.at(curIdx) == s.at(curIdx + 2))
			{
				startIdx = curIdx;
				endIdx = startIdx + 2;
				while (true)
				{
					if (startIdx < 0 || endIdx >= s.length() || s.at(startIdx) != s.at(endIdx))
					{
						if (endIdx - startIdx - 1 > maxLength)
						{
							resultStartIdx = startIdx + 1;
							maxLength = endIdx - startIdx - 1;
						}
						break;
					}
					startIdx--;
					endIdx++;
				}
			}

			curIdx++;
		}
		return maxLength == 1 ? s.substr(0, 1) : s.substr(resultStartIdx, maxLength);
	}
};