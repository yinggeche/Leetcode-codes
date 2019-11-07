class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); //创建map实例
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i); //向集合中添加key数组元素+ value数组下标
        }
        for (int i = 0; i < nums.length; i++) { //遍历数组的temporal cost = O(n)
            int complement = target - nums[i]; //计算出目标元素
            if (map.containsKey(complement) && map.get(complement) != i) {
              //如果此映射包含key=complement，返回true  取得complement对应的value数组下标
              //ture&&数组下标 = complement的数组下标
              //如果这个 != i，就是我们要的数组下标
              //用hash表的查找O(1)来减小整体的时间复杂度
              //hash表的insert/ find/ remove的temporal cost都是O(1)， spatial cost O(n)
                return new int[] { i, map.get(complement) };
              //如果存在key = complement，就返回complement对应的value，否则返回null
            }
        }
        throw new IllegalArgumentException("No two sum solution");
        // 非法参数异常
    }
}
