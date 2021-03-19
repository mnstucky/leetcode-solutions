// https://leetcode.com/problems/remove-nth-node-from-end-of-list/

// Runtime: 4 ms, faster than 83.74% of C++ online submissions for Remove Nth Node From End of List.
// Memory Usage: 10.8 MB, less than 43.46% of C++ online submissions for Remove Nth Node From End of List.

#include <vector>
using std::vector;

// Definition for singly-linked list.
struct ListNode
{
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution
{
public:
    ListNode *removeNthFromEnd(ListNode *head, int n)
    {
        typedef ListNode *nodePtr;
        vector<nodePtr> listRecord;
        nodePtr curNode = head;
        while (curNode != nullptr)
        {
            listRecord.push_back(curNode);
            curNode = curNode->next;
        }
        // Handle list of length 1
        if (listRecord.size() == 1)
        {
            delete head;
            head = nullptr;
        }
        // Handle deletion of head
        else if (listRecord.size() == n)
        {
            delete listRecord.at(0);
            head = listRecord.at(1);
        }
        // Handle deletion of tail
        else if (n == 1)
        {
            delete listRecord.at(listRecord.size() - n);
            listRecord.at(listRecord.size() - n - 1)->next = nullptr;
        }
        // Handle all other deletions
        else
        {
            listRecord.at(listRecord.size() - n - 1)->next = listRecord.at(listRecord.size() - n + 1);
            delete listRecord.at(listRecord.size() - n);
        }
        return head;
    }
};
