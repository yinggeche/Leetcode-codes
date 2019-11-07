class Solution {
  int INT_MAX = Integer.MAX_VALUE;
  // 或者直接定义INT_MAX=999，会更少内存
  private class MyPoint {
      int x; // value
      int y; // Node next
      MyPoint(int v1, int v2) {
          this.x = v1;
          this.y = v2;
      } // constructor of Node
  }
    public int[][] updateMatrix(int[][] matrix) {
      // 得到行数列数
        int rows = matrix.length;
        int cols = matrix[0].length;
        // 行数为0，直接返回
        if(rows == 0){
          return matrix;
        }
        // 初始化dist矩阵
        int[][] dist = new int[rows][cols];
        // 初始化BFS遍历队列
        Queue<MyPoint> q = new LinkedList<>();
        // 元素0的dist初始化为0，元素1的dist初始化为INT_MAX
        for ( int i=0; i <rows; i++){
          for (int j =0; j<cols; j++){
            if (matrix[i][j] == 0){
              dist[i][j] = 0;
              MyPoint new_point_1 = new MyPoint(i,j);
              q.offer(new_point_1);
            }
            else{
              dist[i][j] = INT_MAX;
            }
          }
        }
        // 开始DFS
        // 创建左、右、上、下四个移动方向
        MyPoint left = new MyPoint(-1,0);
        MyPoint right = new MyPoint(1,0);
        MyPoint up = new MyPoint(0,-1);
        MyPoint down = new MyPoint(0,1);
        MyPoint[] dir= new MyPoint[]{left,right,up,down};
        while(!q.isEmpty()){
          // 把队头先存起来
          MyPoint current = q.element();
          // 删除队头，开始找队头的neighbor节点，更新元素1的dist
          q.poll();
          for (int i=0; i<4;i++){
            // 遍历current附近的四个点
            int new_r = current.x+ dir[i].x;
            int new_c = current.y + dir[i].y;
            // 基础判断
            if (new_r >= 0 && new_c >= 0 && new_r < rows && new_c < cols){
              if (dist[new_r][new_c] > (dist[current.x][current.y] + 1)){
                dist[new_r][new_c] = dist[current.x][current.y] + 1;
                MyPoint new_point_2 = new MyPoint(new_r,new_c);
                q.offer(new_point_2);
              }
            }
          }
        }
        return dist;
    }
}
