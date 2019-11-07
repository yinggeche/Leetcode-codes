class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int j = 2;
        for (int i = 2; i<nums.length;i++){
          // 这里比较要和j的前两个比
          // 要和新数组比
            if(nums[i] != nums[j-2]){
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
