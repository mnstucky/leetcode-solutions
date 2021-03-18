// https://leetcode.com/problems/letter-combinations-of-a-phone-number/

// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Letter Combinations of a Phone Number.
// Memory Usage: 6.4 MB, less than 90.73% of C++ online submissions for Letter Combinations of a Phone Number.

#include <iostream>
#include <vector>
#include <string>
using namespace std;

class Solution
{
public:
    vector<string> letterCombinations(string digits)
    {
        if (digits.length() == 0)
        {
            return vector<string>(0);
        }
        // Calculate size of result vector for initialization
        int numCombos = 1;
        for (auto character : digits)
        {
            numCombos *= character == '7' || character == '9' ? 4 : 3;
        }
        vector<string> combos(numCombos);
        auto numDups = numCombos;
        // Move through digits, adding the appropriate letters to the result
        for (auto character : digits)
        {
            auto combosIdx = 0;
            // Convert the digit char into its offset from 2 (e.g., '2' to 0, '3' to 1, etc.)
            auto charOffset = (static_cast<int>(character) - 50);
            // Calculate the int representation of the starting char for the digit
            auto startingChar = 'a' + 3 * charOffset;
            if (character == '8' || character == '9')
            {
                startingChar++;
            }
            // Store the number of chars for the digit
            auto numChars = character == '7' || character == '9' ? 4 : 3;
            // Calculate the number of times to print each char
            numDups = numDups / numChars;
            // Print chars
            while (combosIdx < numCombos)
            {
                for (auto charIdx = 0; charIdx < numChars; ++charIdx)
                {
                    auto dupsRemaining = numDups;
                    auto curChar = static_cast<char>(startingChar + charIdx);
                    for (auto dupIdx = 0; dupIdx < dupsRemaining; ++dupIdx)
                    {
                        combos.at(combosIdx) += curChar;
                        combosIdx++;
                    }
                }
            }
        }
        return combos;
    }
};

int main()
{
    Solution test;
    auto result = test.letterCombinations("234");
    for (auto const &i : result)
    {
        cout << i << " | ";
    }
}