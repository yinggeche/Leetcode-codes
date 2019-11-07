class MedianFinder {
  // ** initialize the private variables of the class
  // 这样也可以: private List<Integer> array = new ArrayList<>();

  private List<Integer> array;
  private int length;
    /** initialize your data structure here. */
    // 定义自己的data structure
    // MedianFinder is a constructor
    // Constructor 里面可以有内容，也可以没有
    public MedianFinder() {
        array = new ArrayList<>();
    }
    // method
    public void addNum(int num) {
        this.array.add(num);
        Collections.sort(this.array);
    }

    public double findMedian() {
      double res;
      int l = this.array.size();
        if(l % 2 != 0){
            int mid = (l-1)/2;
            res = this.array.get(mid);
            return res;
        }
        else{
            int right = l/2;
            int left = right-1;
            double sum = this.array.get(right)+this.array.get(left);
            res = sum/2;
            return res;
        }

    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
