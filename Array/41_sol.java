class Solution {
    public int firstMissingPositive(int[] nums) {
        // Initial Judgement
        if (nums == null || nums.length == 0){
            return 1;
            // If the array is empty, the first = 1
        }
        // Sort Array
        Arrays.sort(nums);
        // Remove Duplicates
        int j = 1;
        for (int i = 1; i< nums.length; i++){
            if(nums[i] != nums[i-1]){
                nums[j] = nums[i];
                j++;
            }
        }
        // Set the start = first positive element
        int start = 0;
        for(int i =0; i<j;i++){
            if(nums[i] > 0){
                start = i;
                break;
            }
        }
        // Use count to find the first missing positive
        int count = 1;
        for(int i = start;i<j;i++){
            System.out.print(" "+nums[i]);
            if (nums[i] != count){
                return count;
            }
            count++;
        }
        // If the array all match with index count
        // The first missing positive is length + 1
        // Length = all positives in array
        count = j-start+1;
        return count;
    }
}
