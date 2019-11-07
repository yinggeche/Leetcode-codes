class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        HashSet<Integer> set = new HashSet<Integer>(nums.length);
        // Set<Integer> set = new HashSet<>();
        for (int i = 0; i< nums.length;i++){
            if(!set.add(nums[i])){
                return true;
            }
        }
        return false;
    }
}
// 只用一行
class Solution {
    public boolean containsDuplicate(int[] nums) {
        return (Arrays.stream(nums).distinct().count() != nums.length);
        // Streams don’t change the original data structure, they only provide the result as per the pipelined methods.
        // stream不储存修改元素，只是通过pipe把数据源中的元素传递给操作
        // 可以用limit(n)/ findFirst()来使时间有限
        // 只能访问一次，类似于iterator
    }
}
