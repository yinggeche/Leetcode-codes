/*
两种O(1)的方法，一种是做数组向右移动一位k次（也可以向移动操作少的方向移动），时间复杂度是O(kn)；另一种是reverse前半部分、后半部分、全部，这种方法时间复杂度是O(n)。
*/

/****************** 方法2 *******************/

class Solution {

// reverse swap分开
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start, int end){
        while (start < end){
            swap(nums, start, end);
            start ++;
            end --;
        }
    }

// reverse swap合在一起
private void reverse(int[] nums, int start, int end) {
    while (start < end) {
        int temp = nums[start];
        nums[start++] = nums[end];
        // 先运算再++ 或者 --
        nums[end--] = temp;
        /*
        i++  ：先引用后增加，先在i所在的表达式中使用i的当前值，后让i加1
        ++i  ：先增加后引用，让i先加1，然后在i所在的表达式中使用i的新值
        */
    }
}


    public void rotate(int[] nums, int k) {
        if(nums.length == 0 || k < 0){
            return;
        }
        k %= length;
        // 一定要modify
        reverse(nums, 0, nums.length-k-1);
        reverse(nums, nums.length-k, nums.length-1);
        reverse(nums, 0, nums.length-1);
    }
}
