class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> nans = new ArrayList<>();
    List<Integer> nu = new ArrayList<>();
    int n;

    public void dfs(int cur, int st, int target){
        if(target <= 0)
        {
            if(target == 0){
                nans.resize = cur;
                ans.add(nans);
            }
            return;
        }
        if(nans.length == cur){
            nans.add(0);
        }
        for (int i = st; i < n; i++){
            if (nu[i] > target){
                return;
            }
            nans[cur] = nu[i];
            this.dfs(cur+1, i, target- nu[i]);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        nu = candidates;
        n = candidates.length;
        this.dfs(0, 0, target);
        return ans;
    }
}
