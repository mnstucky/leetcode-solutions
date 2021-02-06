// https://leetcode.com/problems/linked-list-cycle-ii/
// Runtime: 8 ms, faster than 80.00% of C++ online submissions for Linked List Cycle II.
// Memory Usage: 7.4 MB, less than 99.77% of C++ online submissions for Linked List Cycle II.

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *detectCycle(ListNode *head) {
        ListNode* fast = head;
        ListNode* slow = head;
        // Loop while fast and fast->next aren't null, moving slow forward 1 node per iteration,
        //   and moving fast forward 2 nodes per iteration
        while (fast && fast->next)
        {
            fast = fast->next->next;
            slow = slow->next;
            // Exit the loop if fast and slow are on the same node
            if (fast == slow) break;
        }
        // If fast reached the end of the list, we don't have a cycle
        if (!fast || !fast->next) return nullptr;
        // Otherwise, reset fast to the head, and move slow and fast forward 1 node at a time;
        //   when they meet, we've found the start of the cycle
        fast = head;
        while (fast != slow)
        {
            fast = fast->next;
            slow = slow->next;
        }
        return fast;
    }
};