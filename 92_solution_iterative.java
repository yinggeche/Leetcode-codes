/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {

        // 【错1】判断链表是否空！！！！
        if (head == null){
          return null;
        }


        ListNode prev = null;
        ListNode curr = head;

        // 先把left和right从head挪到对的位置
        while(m > 1){
          prev = curr;
          curr = curr.next;
          m = m - 1;
          n = n - 1;
        }

        // 设定con和tail的位置
        ListNode con = prev;
        ListNode tail = curr;
        ListNode x = null;
        //把x的初始化设定在循环外，否则会Memory Limit Exceeded


        // 反转子链表
        // 这里 n>0，因为n>1，才换到current = n， 但是要存下子链表之后的节点
        while(n > 0){
          x = curr.next;
          curr.next = prev;
          // prev.next = curr;
          // 【错2】prev.next在每次循环中已经修改了，prev即是前一个curr！！！！
          prev = curr;
          curr = x;
          n = n - 1;
        }

        // 拼接con+prev; tail + curr
        // 【错3】这里要判断con是否为null！！！！
        if (con != null){
          con.next = prev;
        }
        else{
          head = prev;
        }

        tail.next = curr;

        return head;

    }
}
