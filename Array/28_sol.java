class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums== null || nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int j = 1;
        for (int i = 1; i <nums.length;i++){
            if(nums[i] != nums[i-1]){
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
