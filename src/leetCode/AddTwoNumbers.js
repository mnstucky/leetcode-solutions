// https://leetcode.com/problems/add-two-numbers/submissions/

/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function (l1, l2) {
  let result = new ListNode();
  let head = result;
  let carried = 0;
  while (true) {
    result.val = (l1.val + l2.val + carried) % 10;
    carried = l1.val + l2.val + carried > 9 ? 1 : 0;
    if (l1.next == null || l2.next == null) {
      break;
    }
    result.next = new ListNode();
    result = result.next;
    l1 = l1.next;
    l2 = l2.next;
  }
  if (l1.next == null && l2.next != null) {
    while (true) {
      if (l2.next == null) {
        break;
      }
      result.next = new ListNode();
      result = result.next;
      l2 = l2.next;
      result.val = (l2.val + carried) % 10;
      carried = l2.val + carried > 9 ? 1 : 0;
    }
  } else if (l1.next != null && l2.next == null) {
    while (true) {
      if (l1.next == null) {
        break;
      }
      result.next = new ListNode();
      result = result.next;
      l1 = l1.next;
      result.val = (l1.val + carried) % 10;
      carried = l1.val + carried > 9 ? 1 : 0;
    }
  }
  if (carried === 1) {
    result.next = new ListNode();
    result = result.next;
    result.val = 1;
  }
  return head;
};
