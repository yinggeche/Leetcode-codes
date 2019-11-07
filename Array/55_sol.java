class Solution {
    public boolean canJump(int[] nums) {
        int lens = nums.length;
        int n = 1;
        for (int i = lens-2; i >= 0; i--){
          // 从尾部遍历，初始要跳过一个
          // 后面所有都要跳过n个
            if(nums[i] >= n){
                n = 1;
            } // 如果前一个跳不过的话，前一个的前一个要多跳一个
            else {
                n++;
            } // 如果遍历到第一个，并且第一个的值跳不过n个，那就false
            if (i == 0 && nums[i] < n){
                return false;
            }
        }
        return true;
    }
}
