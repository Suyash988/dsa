// 40. Combination Sum II
// Solved
// Medium


// Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

// Each number in candidates may only be used once in the combination.

// Note: The solution set must not contain duplicate combinations.

 

// Example 1:

// Input: candidates = [10,1,2,7,6,1,5], target = 8
// Output: 
// [
// [1,1,6],
// [1,2,5],
// [1,7],
// [2,6]
// ]
// Example 2:

// Input: candidates = [2,5,2,1,2], target = 5
// Output: 
// [
// [1,2,2],
// [5]
// ]
 

// Constraints:

// 1 <= candidates.length <= 100
// 1 <= candidates[i] <= 50
// 1 <= target <= 30

// Code 

class Solution {
    public void findCombinationSum2(int ind, int target, int[] arr, List<Integer> ds,
    List<List<Integer>> ans){
     // base case
     if(target ==0){
        ans.add(new ArrayList<>(ds));
     }
        // when we pick the element 
        for(int i=ind; i<arr.length; i++){
            // continue when the adjacent values are same
            // we have to pick the element which we are standing at
            if(i>ind && arr[i]==arr[i-1]) continue;

            // break when the value is greater than the target
            if(arr[i]> target) break;

            ds.add(arr[i]);
            findCombinationSum2(i+1,target-arr[i], arr, ds, ans);

            // backtrack to explore other paths also
            ds.remove(ds.size() -1);
        }
     }
    

    public List<List<Integer>> combinationSum2(int[] arr, int target) {
     //as each number can be used only once 
     // Brute Force Approach will use the concept of pick and non-pick
     // will give tle as the number of the combination will be more 
     //to store the arrays in the list we will take extra time
     Arrays.sort(arr);
     List<List<Integer>> ans = new ArrayList<>();
     List<Integer> ds = new ArrayList<>();
     findCombinationSum2(0,target,arr,ds,ans);
     return ans;

    // tc: O(2^k *)
}
}