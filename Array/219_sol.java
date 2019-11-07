//遍历解法时间复杂度太差
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i< nums.length; i++){
            for (int j =1; j <= k;j++){
                if(i+j < nums.length){
                if (nums[i] == nums[i+j]){
                return true;
                }
            }
        }
        }
        return false;
    }
}
// 用HashSet
// 不保证插入顺序，允许null element

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<Integer>();
        // 这个HashSet就像一个滑动窗口
        for (int i = 0; i < nums.length; i++){
            if (set.contains(nums[i])){
                return true;
                // 如果存在就true
            }
            set.add(nums[i]); // 一般不存在，先把不重复的存进去
            if(set.size() == k+1){ // 如果滑动窗口的长度 = k+1
                set.remove(nums[i-k]); // 把窗口第一个元素删掉，已经把i-k到i的所有元素对比完了，窗口长度为k
            }
        }
        return false;
    }
}
