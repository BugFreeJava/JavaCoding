/**
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once. 
 * Return the linked list sorted as well.
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
 * leetcode: https://leetcode.com/problems/remove-duplicates-from-sorted-list/
*/
class RemoveDuplicates {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode cur = node;
		while (cur != null && cur.next != null) {
			if (cur.val == cur.next.val) {
				cur.next = cur.next.next;
			} else {
				cur = cur.next;
			}
		}

		return head;
	}
}