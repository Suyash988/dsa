// 60. Permutation Sequence
// hard

// The set [1, 2, 3, ..., n] contains a total of n! unique permutations.

// By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

// "123"
// "132"
// "213"
// "231"
// "312"
// "321"
// Given n and k, return the kth permutation sequence.

 

// Example 1:

// Input: n = 3, k = 3
// Output: "213"
// Example 2:

// Input: n = 4, k = 9
// Output: "2314"
// Example 3:

// Input: n = 3, k = 1
// Output: "123"

// code 

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> numbers = new ArrayList<>();
        // find the factorial of one lesser value i.e. for n = 4, 
        // find the factorail of 3 i.e 6
        // add the number to the numbers array to make the first number.
        for(int i=1;i<n; i++){
            fact *= i;
            numbers.add(i);
        }
        numbers.add(n);
        // take a empty string
        String ans = "";
        k = k-1;
        // run an infinite loop, until the break occurs.
        while(true){
            ans = ans + numbers.get(k/fact);
            numbers.remove(k/fact);
            // when the size of the array becomes 0 break from the loop;
            if(numbers.size() == 0) break;
            // change the size of the k 
            k = k % fact;
            // change the fact value by dividing it with the numbers.size();
            fact = fact/numbers.size();
        }
        // return the answer.
    return ans;
    }
}