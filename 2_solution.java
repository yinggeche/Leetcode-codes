/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode preNode = new ListNode(0); //初始化头节点的前一个节点
        ListNode current = preNode;
        int carry = 0; //初始化进位carry = 0
        ListNode p = l1; //初始化p和q为l1和l2的头部
        ListNode q = l2;
        int x, y;
        int sum;
        while (p != null || q != null)
        {
            if (p == null){
                x = 0;
            }
            else{
                x = p.val;
            }
            if (q == null){
                y = 0;
            }
            else{
                y = q.val;
            }
            sum = x + y + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
            // 第一遍报错：
            // Line 37: java.lang.NullPointerException
            // 因为没加非空的判断
        }
        if (carry == 1)
        {
          current.next = new ListNode(carry);
        }
        return preNode.next;
    }
}
