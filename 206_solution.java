/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode preNode = null;
        ListNode current = head;
        while (current != null)
        {
          ListNode nextNode = current.next;
          current.next = preNode;
          preNode = current;
          current = nextNode;
        }
        return preNode;
    }
}
