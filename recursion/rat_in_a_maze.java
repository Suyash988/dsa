// Rat in a Maze
// Difficulty: MediumAccuracy: 35.75%Submissions: 398K+Points: 4Average Time: 25m
// Consider a rat placed at position (0, 0) in an n x n square matrix maze[][]. The rat's goal is to reach the destination at position (n-1, n-1). The rat can move in four possible directions: 'U'(up), 'D'(down), 'L' (left), 'R' (right).

// The matrix contains only two possible values:

// 0: A blocked cell through which the rat cannot travel.
// 1: A free cell that the rat can pass through.
// Your task is to find all possible paths the rat can take to reach the destination, starting from (0, 0) and ending at (n-1, n-1), under the condition that the rat cannot revisit any cell along the same path. Furthermore, the rat can only move to adjacent cells that are within the bounds of the matrix and not blocked.
// If no path exists, return an empty list.

// Note: Return the final result vector in lexicographically smallest order.

// Examples:

// Input: maze[][] = [[1, 0, 0, 0], [1, 1, 0, 1], [1, 1, 0, 0], [0, 1, 1, 1]]
// Output: ["DDRDRR", "DRDDRR"]
// Explanation: The rat can reach the destination at (3, 3) from (0, 0) by two paths - DRDDRR and DDRDRR, when printed in sorted order we get DDRDRR DRDDRR.


//Code: 

import java.util.ArrayList;

class Solution {
    
    public boolean isSafe(int x,int y, int[][] maze, int[][]visited,int n ){
        if(x>=0 && x<n && y>=0 && y<n && maze[x][y] == 1 && visited[x][y] == 0) {
            return true;
        }
        return false;
    }
    
    public void solve(int x,int y,int n,int[][] maze,int[][] visited, String path,ArrayList<String> res){
         // base case
         
         if(x==n-1 && y==n-1){
             res.add(path);
             return;
         }
         
         // add to the visited
         visited[x][y] = 1;
         
         // check in the down side
         if(isSafe(x+1,y,maze,visited,n)){
             solve(x+1,y,n,maze,visited,path+"D",res);
         }
         
         // check in the left side
         if(isSafe(x,y-1,maze,visited,n)){
             solve(x,y-1,n,maze,visited,path+"L",res);
         }
         
         // check in the right
         if(isSafe(x,y+1,maze,visited,n)){
             solve(x,y+1,n,maze,visited,path+"R",res);
         }
         
         // check in the up
         if(isSafe(x-1,y,maze,visited,n)){
             solve(x-1,y,n,maze,visited,path+"U",res);
         }
         
         // backtrack 
         visited[x][y] = 0;
         
    }
    
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        ArrayList<String> res = new ArrayList<>();
        int n = maze.length;
        int[][] visited = new int[n][n];
        
        if(maze[0][0] == 1) {
            solve(0,0,n,maze,visited,"",res);
        }
        
        return res;
    }
}

//tc: O(4^(n*n))
//sc: O(n*n) for visited array and O(path length) for recursion stack