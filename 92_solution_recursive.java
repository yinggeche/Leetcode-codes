/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // 这两个变量在递归的时候要重新定义
    // 定义了两个成员变量，私有
    private boolean stop; // A boolean variable to stop swap nodes
    private ListNode left;
    // Recursive function
    // 如果我想返回空值，change the return type to void

    // 成员方法的定义方式：
    // 权限+ 返回值*没有返回值就是返回void*+ 方法名+ （参数类型*可以是对象/基本数据类型* 参数名）
    public void reverseAndrecurse(ListNode right, int m, int n){
        //两个指针：right和left都从链表的head开始移动
        // m是交换的左边界，n是右边界
        // Step 1: right和left到达m和n的位置
        // 先判断n是否为1，如果为1，就结束
        if (n == 1) {
            return;
            // 如果在程序中遇到return语句，那么代码就退出该函数的执行，返回到函数的调用处，如果是main()函数，那么结束整个程序的运行。
            // 如果是在自定义的函数中执行，那么执行return之后就返回到函数的调用处继续往下执行。
            // 因此如果n == 1，即right和left都到达合适的位置之后，返回reverseAndrecurse函数的调用处，继续往下执行，即执行Step 2
        }
        // 移动right直到 n == 1
        right = right.next;
        // 如果 m > 1，再移动left
        if (m > 1){
          this.left = this.left.next;
          // this指的是对这个类的引用
          // this.left，对类Solution的成员变量left的引用
        }
        // Recurse right, m, n
        this.reverseAndrecurse(right, m-1, n-1);

        // Step 2: Swap nodes from left to right
        // 首先判断right和left是否到达同一个位置 或者 right和left crose each other
        // 如果成立，停止交换
        if(this.left == right || right.next == this.left){
          this.stop = true;
        }
        // stop == false的话，开始swap value
        if(!this.stop){
          int x = this.left.val;
          this.left.val = right.val;
          right.val = x;
          // left向后移动
          this.left = this.left.next;
          // The right pointer moves one step back via backtracking.
        }

    }
    // Reverse Function: to reverse the nodes between m and n by using recursive function
    public ListNode reverseBetween(ListNode head, int m, int n) {
      this.left = head;
      this.stop = false;
      this.reverseAndrecurse(head, m, n);
      return head;
    }
}
