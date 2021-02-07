// https://leetcode.com/problems/remove-duplicates-from-sorted-list/

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode currentNode = head;
        ListNode testNode = head.next;
        while (currentNode.next != null) {
            while (testNode != null) {
                if (currentNode.val != testNode.val) {
                    currentNode.next = testNode;
                    break;
                } else {
                    if (testNode.next == null) {
                        currentNode.next = null;
                        return head;
                    } else testNode = testNode.next;
                }
            }
            currentNode = currentNode.next;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
