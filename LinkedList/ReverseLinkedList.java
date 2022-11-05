/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * 
 * leetcode: https://leetcode.com/problems/reverse-linked-list/
 * 
 */
class ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode prev = null;
		ListNode cur = head;

		while (cur != null) {
			ListNode next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}

		return prev;
	}
}