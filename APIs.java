Math.min(a, b);
Math.abs(a);
最大值最小值 Integer.MIN_VALUE, Integer.MAX_VALUE
/* ============数组 Array============ */
/* 1. 一维数组 */
int[] nums = new int[10];
int lens = nums.length; // 长度
Arrays.sort(nums);
/* swap */
public void swap(int[] nums, int i, int j){
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}
Arrays.stream(nums).distinct().count() != nums.length
/* 2. 二维数组 */
object[][] nums;
nums.length // 行数
nums[0].length //列数

/* ============字符串 String============ */
System.out.print(secret.charAt(i)-48);//减去ASCII的‘0’
System.out.println(guess.charAt(i)-'0');
count_A[secret.charAt(i) - 48]++; //这里用的ASCII码
count_B[guess.charAt(i) - 48]++;



/* ============  list============ */
排序:
Collections.sort(list);

/* ============ 栈 Stack============ */
// LIFO
// 1.基本操作
.push 插入
.pop 删除

/* ============ 队列 Queue============ */
// FIFO
// 1.基本操作
Queue theQueue = new Queue(5); // 长度5的队列
theQueue.insert(10); // 尾部插入10
.add .offer
// 前端删除，后端插入
theQueue.remove(); // 头部删除
.poll
// 队头指针增加1，一般数据还保留在内存中，只是Front移到下一个位置，
theQueue.front()；// 队头指针
.element
theQueue.rear(); // 队尾指针
theQueue.peek(); // front指针所指数据项的值
theQueue.isFull();
theQueue.isEmpty();
theQueue.size()
// 尽量使用offer()方法添加元素，使用poll()方法移除元素
TreeNode tmpNode= queue.poll()

/* HashSet HashMap*/
HashSet<Integer> set = new HashSet<Integer>(nums.length);
// Set<Integer> set = new HashSet<>();
用hashset来判断重复
Map<Integer, Integer> map = new HashMap<>();

       for (int i = 0; i < nums.length; i++) {
           if (!map.containsKey(nums[i])) {
               map.put(nums[i], i);
