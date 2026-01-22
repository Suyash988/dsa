// 51. N-Queens
// Solved
// Hard
// Topics
// premium lock icon
// Companies
// The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

// Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

// Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.


// code 

// brute force appraoch 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public void solve(int col, char[][] board, List<List<String>> res,int n){
      // base case

      if(col == n){
        List<String> temp = new ArrayList<>();

        for(int i=0; i<n; i++){
            temp.add(new String(board[i]));
        }
        res.add(temp);
        return;
      }

      // try placing the queen in each row for the current column.
      for(int row = 0;row<n;row++){
          if(isSafe(row,col,board,n)){
            // place the queen
              board[row][col] = 'Q';
             // recurse to the next col
               solve(col+1,board,res,n);
             // backtrack
              board[row][col] = '.';   
          }
      }
    }

    public boolean isSafe(int row, int col, char[][] board, int n){
        // check left in the same row
        for(int i=col; i>=0; i--){
           if(board[row][i] == 'Q') return false; 
        }

        // check for the upper left
        for(int i=row,j=col; i>=0 && j>=0; i--,j--){
            if(board[i][j] == 'Q') return false;
        }

        // checking for lower left 
        for(int i=row,j=col; i<n && j>=0; i++,j--){
            if(board[i][j] == 'Q') return false;
         }

         return true;
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];

        for(int i=0; i<n; i++){
            Arrays.fill(board[i], '.');
        }

        solve(0,board,res,n);
        return res;
    }
}

// optimized approach

