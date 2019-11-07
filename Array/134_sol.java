class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int rest = 0, run = 0, start = 0;
        for(int i = 0; i< gas.length;i++){
            run += (gas[i] - cost[i]);
            // 只要起始点之后的剩余油量>0，那车就可以开下去
            rest += (gas[i] - cost[i]);
            // 总的剩余量
            if (run < 0){
                start = i + 1;
                run = 0;
            }
        }
        // 如果总剩余量>0，那车能开完一圈
       return rest >=0 ? start: -1;
     }
}

/*证明过程：
1. run<0，判断车是否能从i开到i+1
    run >= 0 如果可以，那就能继续开下去，start是ok的
    run < 0 如果不能，无论从前面哪里开始，都不能开下去，start必然在i后面
2. rest>=0, 判断开完一圈，剩余油量 >= 0
    如果车可以从i/start开到end(run >= 0),并且从i/start开一圈rest>=0
    那么，从start开到end，剩余油run>=0,从end开一圈回到start，剩余油rest>=0
    那么从start可以开完全程
*/
