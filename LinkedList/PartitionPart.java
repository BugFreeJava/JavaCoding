/**
 * Given the head of a linked list and a value x, partition it such that all nodes less than x come 
 * before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the two partitions.
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
 * leetcode: https://leetcode.com/problems/partition-list/
*/
class PartitionPart {
	ListNode leftDummy = new ListNode();
    ListNode rightDummy = new ListNode();
    ListNode left = leftDummy;
    ListNode right = rightDummy;
    
    ListNode cur = head;
    while (cur != null) {
        if (cur.val < x) {
            left.next = cur;
            left = left.next;
        } else {
            right.next = cur;
            right = right.next;
        }
        
        cur = cur.next;
    }
    
    left.next = rightDummy.next;
    right.next = null;
    return leftDummy.next;
}