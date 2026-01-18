
// 131. Palindrome Partitioning
// Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

 

// Example 1:

// Input: s = "aab"
// Output: [["a","a","b"],["aa","b"]]
// Example 2:

// Input: s = "a"
// Output: [["a"]]
 

// Constraints:

// 1 <= s.length <= 16
// s contains only lowercase English letters.

// Code 

import java.util.ArrayList;
import java.util.List;

class Solution {
    public void func(int index, String s, List<String>path, List<List<String>> res){
         // base case 
         if(index==s.length()) {
            res.add(new ArrayList<>(path));
         }
         // loop through the string to find the palindrome strings.
         for(int i=index; i<s.length(); i++){
            // check if the given string is the palindrome or not.
            if(isPalindrome(s,index,i)){
                // add the substring to the path
                path.add(s.substring(index,i+1));
                // recursive calling of the function.
                func(i+1,s,path,res);
                // backtrack to explore the other paths also
                path.remove(path.size() -1);
            }
         }
    }
    // checks if the given string is palindrome or not.
    public boolean isPalindrome(String s, int start,int end){
          while(start<end){
            if(s.charAt(start) !=s.charAt(end)) return false;
            start++;
            end--;
          }
          return true;
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        func(0,s,path,res);
        return res;
    }
}

// TC: O(N*2^N) SC: O(N)
// N is the length of the string s. In the worst case, we can have 2^N possible partitions, and for each partition, we may need to check if each substring is a palindrome, which takes O(N) time. Hence, the overall time complexity is O(N*2^N). The space complexity is O(N) for the recursion stack and the path list.
