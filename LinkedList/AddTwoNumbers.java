/**
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order, and each of their nodes contains a single digit. 
 * Add the two numbers and return the sum as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
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
 * leetcode: https://leetcode.com/problems/add-two-numbers/
 */
class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode();
		ListNode cur = dummy;

		int carry = 0;
		while (l1 != null || l2 != null || carry != 0) {
			int x = l1 == null ? 0 : l1.val;
			int y = l2 == null ? 0 : l2.val;

			int sum = x + y + carry;
			carry = sum / 10;
			sum = sum % 10;

			ListNode newNode = new ListNode(sum);
			cur.next = newNode;
			cur = cur.next;

			if (l1 != null) {
				l1 = l1.next;
			}

			if (l2 != null) {
				l2 = l2.next;
			}
		}

		return dummy.next;
	}
}