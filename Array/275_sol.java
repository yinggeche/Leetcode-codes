class Solution {
    public int hIndex(int[] citations) {
        for(int i = 0;i<citations.length;i++){
            if(citations.length - i <= citations[i]){
                return citations.length - i;
            }
        }
        return 0;
    }
}
