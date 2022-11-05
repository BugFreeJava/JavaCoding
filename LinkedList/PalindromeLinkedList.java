/**
 * Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 
 * leetcode: https://leetcode.com/problems/palindrome-linked-list/description/
*/

class PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}

		ListNode middle = findMiddle(head);
		ListNode left = headl
		ListNode right = reverse(middle.next);
		middle.next = null;

		return compare(left, right);
	}

	private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
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

    private boolean compare(ListNode left, ListNode right) {
        ListNode one = left;
        ListNode two = right;
        while (one != null && two != null) {
            if (one.val != two.val) {
                return false;
            }
            one = one.next;
            two = two.next;
        }
        return true;
    }
}