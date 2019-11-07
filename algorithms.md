# Algorithms in Leetcode

## Arrays
#### In-Place 原地
1. In computer science, an in-place algorithm is an algorithm which transforms input using no auxiliary 附属的 data structure.
2. In-place algorithm updates input sequence only through replacement or swapping of elements. An algorithm which is not in-place is sometimes called not-in-place or out-of-place.
3. 解法：遍历，满足情况的nums[i]赋值到nums[j]；
4. i->原数组的index，j->新数组的index
5. 返回：j->新数组
6. O(1)

#### H-Index
1. A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each.
2. lens-i <= nums[i], h_index = lens - i

## Dynamic Programming
1. 形式
   - f[i][j] = f[i - 1][j] + f[i][j - 1]

   - f[i] = max{f[j] if j < i and …} + 1

   - f[i][j] = f[0][j - 1] && judge(1,i) || f[1][j - 1] && judge(2,i) || …
2. 一个规模比较大的问题（假如用2-3个参数可以表示），是通过规模比较小的若干问题的结果来得到的（通过取最大，取最小，或者加起来之类的运算）
3. 问题类型
   - 求最大值/最小值
   - 求可不可行
   - 求方案总数
4. 解决：
   - 状态是什么
   - 状态转移方程是什么
   - 状态的初始值是什么
   - 问题要求的最后答案是什么
