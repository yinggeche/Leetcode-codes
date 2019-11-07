class Solution {
    public int hIndex(int[] citations) {
        // citation 正序
        int lens = citations.length;
        Arrays.sort(citations);
        for (int i = 0; i < lens; i++){
            if(lens - i <= citations[i]){
                return lens - i;
            }
        }
        return 0;
    }
}
