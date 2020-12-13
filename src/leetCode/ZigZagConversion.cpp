// https://leetcode.com/problems/zigzag-conversion/
// 
// Runtime: 16 ms, faster than 44.12% of C++ online submissions for ZigZag Conversion.
// Memory Usage: 8.3 MB, less than 94.80% of C++ online submissions for ZigZag Conversion.

#include <string>
#include <iostream>
using namespace std;

class Solution
{
public:
	string convert(string s, int numRows)
	{
		int scaleFactor = 4 + (numRows - 3) * 2;
		int curScaleFactor = scaleFactor;
		int rowNum = 0;
		bool toggle = true;
		string result;
		result.reserve(s.length());
		if (numRows == 1)
		{
			return s;
		}
		while (rowNum < numRows)
		{
			for (int i = rowNum; i < s.length();)
			{
				result.push_back(s.at(i));
				if (curScaleFactor == scaleFactor || curScaleFactor == 0)
				{
					i += scaleFactor;
				}
				else
				{
					toggle ? i += curScaleFactor : i += (scaleFactor - curScaleFactor);
					toggle = toggle ? false : true;
				}
			}
			curScaleFactor -= 2;
			rowNum++;
			toggle = true;
		}
		return result;
	}
};