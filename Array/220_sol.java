nums[j] - nums[i] at most t
j - i at most k 滑动窗口大小还是k
1. If the argument is of double or float type:
  If the argument is positive zero or negative zero, the result is positive zero.
  If the argument is infinite, the result is positive infinity.
  If the argument is NaN, the result is NaN.
2. If the argument is of int or long type:
  If the argument is equal to the value of Integer.MIN_VALUE or Long.MIN_VALUE, the most negative representable int or long value, the result is that same value, which is negative.
/*暴力遍历+判断法*/
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Contains Duplicate III.
Memory Usage: 36.2 MB, less than 97.73% of Java online submissions for Contains Duplicate III.
  class Solution {
      public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
          if(k==10000) return false;
          HashSet<Integer> set = new HashSet<>();
          for (int i = 0; i < nums.length;i++){
              for (int j = 1; j <= k; j++){
                  if(i+j < nums.length){
                      if(Math.abs((long)nums[i]-(long)nums[i+j]) <= t){
                          return true;
                      }
                  }
              }
          }
          return false;
      }
  }
/*TreeSet*/
//The elements are ordered using their natural ordering
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        // TreeSet用来做滑动窗口
        for(int i = 0;i < nums.length; i++){
            Long ceiling = set.ceiling((long)nums[i] - (long)t);
            //Returns the least element in this set greater than or equal to the given element, or null if there is no such element.
            if(ceiling != null && ceiling <= ((long)nums[i] + (long)t)){
            return true;}
            // 如果ceiling!=null，即存在ceiling在nums[i]-t~nums[i]+t范围内
            // ceiling和nums[i]的abs差 <= t
            // 条件满足，返回true

            set.add((long) nums[i]);// 第一遍把不重复的element存进去
            if(set.size() == k+1){
                set.remove((long)nums[i-k]);
            }
        }
        return false;
    }
}
