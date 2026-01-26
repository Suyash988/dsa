// 37. Sudoku Solver
// Solved
// Hard
// Topics
// premium lock icon
// Companies
// Hint
// Write a program to solve a Sudoku puzzle by filling the empty cells.

// A sudoku solution must satisfy all of the following rules:

// Each of the digits 1-9 must occur exactly once in each row.
// Each of the digits 1-9 must occur exactly once in each column.
// Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
// The '.' character indicates empty cells.


//Code

class Solution {

    public boolean solve(char[][] board){
         // check of the empty places  
         for(int i=0; i<board.length; i++){
            for(int j=0;j<board[0].length; j++){
                 // find the empty place 
                 if(board[i][j] == '.'){
                    // try fill the values from 1-9 in the empty place.
                    for(char c='1'; c<='9'; c++){
                       // check if it is valid to fill the c in the given pos.
                       if(isValid(i,j,board,c)){
                           board[i][j] = c;
                           if(solve(board) == true) return true;
                           // backtrack if required
                           board[i][j] = '.';
                       }
                        
                    }
                    // if it not possible to fill any char in the empty space.
                    return false;
                 }
            }
         }
         return true;
    }
    
    public boolean isValid(int row, int col,char[][] board,char ch){
          for(int i=0; i<9; i++){
            // check for the row
             if(board[row][i] == ch) return false;

             // check in the whole col
             if(board[i][col] == ch) return false;

             // check in the sub-matric
             int boxrow = 3*(row/3) + i/3;
             int boxcol = 3*(col/3) + i%3;
             if(board[boxrow][boxcol] == ch) return false;
          }
          return true;
    }

    public void solveSudoku(char[][] board) {
        solve(board);
    }
}

// tc: O(9^(n*n))
// sc: O(1)