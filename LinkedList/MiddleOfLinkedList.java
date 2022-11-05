/**
 * Given the head of a singly linked list, return the middle node of the linked list.
 * 
 * If there are two middle nodes, return the second middle node.
 * 
 * leetcode: https://leetcode.com/problems/middle-of-the-linked-list/
*/
class MiddleOfLinkedList {
	public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
        	return head;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
        	slow = slow.next;
        	fast = fast.next.next;
        }

        return slow;
    }
}