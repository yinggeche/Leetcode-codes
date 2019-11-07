class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> nans = new ArrayList<>();
    int n;

    public void dfs( int start, int[] candidates, int target){
        System.out.println("target:"+ target);
        if(target <= 0)
        {
            if(target == 0){
		    // for (int j = 0; j <  nans.size(); j++) {
		    // System.out.print("nans: "+ nans.get(j));
		    // }
                ans.add(new ArrayList<>(nans));
                nans.remove(nans.size()-1);
            }

            return;
        }
        for (int i = start; i < n; i++){
            if (candidates[i] > target){
		         // System.out.println(i+": "+candidates[i]);
		         // System.out.println("return nans:");
		         // for (int j = 0; j <  nans.size(); j++) {
		         //    System.out.print(nans.get(j));
		         // }
		         // System.out.println(" ");
                nans.remove(nans.size() - 1);
                return;
            }
            nans.add(candidates[i]);
            dfs(i, candidates, target - candidates[i]);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        n = candidates.length;
        this.dfs(0, candidates, target);
        return ans;
    }
}
