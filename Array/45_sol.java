class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1){
            return 0;
        }
        int reach = 0; // 当前位置
        int nextReach = 0; // 当前能到的最远位置
        int step = 0; // 最后的步数

        for (int i = 0; i < nums.length; i++){
            nextReach = Math.max(i+nums[i], nextReach);// 当前能到的最远位置
            if (nextReach >= nums.length-1) return step+1;
            // 如果下一步能直接跳到end=nums.length-1这个位置
            // return step+1
            // 如果能跳到的最远距离是i，那reach = curFar(在i能跳到的最远位置)
            if (i == reach){
                reach = nextReach;
                step++;//因为跳了一步，所以要step++
            }
        }
        return step;
    }
}
