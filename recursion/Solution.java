
// 60. Permutations 
// medium

// Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 

// Example 1:

// Input: nums = [1,2,3]
// Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// Example 2:

// Input: nums = [0,1]
// Output: [[0,1],[1,0]]
// Example 3:

// Input: nums = [1]
// Output: [[1]]
 

// Constraints:

// 1 <= nums.length <= 6
// -10 <= nums[i] <= 10
// All the integers of nums are unique.


// code : 

import java.util.ArrayList;
import java.util.List;

class Solution {
    public void findPermutations(int index, int[] nums,List<List<Integer>> ans ){
       // base case 
       if(index == nums.length){
        // create a temporary data structure to store the data.
        List<Integer> temp = new ArrayList<>();
        for(int num: nums){
            temp.add(num);
        }
        ans.add(temp);
        return;
       }

       // loop to find the possible paths.
       for(int i=index; i<nums.length; i++){
        //  to create a new sequence
          swap(nums,index,i);
          // recursion to find the new numbers
          findPermutations(index+1,nums,ans);
          // this step is used to backtrack, keep the number in the original state.
          swap(nums,index,i);
     
       }
    }

    public void swap(int[]nums, int index, int i){
        int temp = nums[index];
        nums[index] = nums[i];
        nums[i] = temp; 
        return;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        findPermutations(0,nums,ans);
        return ans;
    }
}
