
// public M-Coloring Problem

// Difficulty: MediumAccuracy: 34.42%Submissions: 182K+Points: 4Average Time: 45m
// You are given an undirected graph consisting of V vertices and E edges represented by a list edges[][], along with an integer m. Your task is to determine whether it is possible to color the graph using at most m different colors such that no two adjacent vertices share the same color. Return true if the graph can be colored with at most m colors, otherwise return false.

// Note: The graph is indexed with 0-based indexing.

// Examples:

// Input: V = 4, edges[][] = [[0, 1], [1, 3], [2, 3], [3, 0], [0, 2]], m = 3
// Output: true
// Explanation: It is possible to color the given graph using 3 colors, for example, one of the possible ways vertices can be colored as follows:

// Solevd the probelm using Recursion and Backtracking 

// Having the problem with the syntax of the Graph in Java, as i was unaware of how the adjacency list is represented in Java. 

// CODE : 

class Solution {
    
    public boolean isSafe(int node, int c,int[][] adj, int[] color,int v){
        
        for(int i=0;i<v; i++){
            if(adj[node][i] == 1 && color[i] == c) return false;
        }
        
        return true;
    }
    
    public boolean solve(int node, int[][] adj, int[] color, int v, int m) {
        
        // base condition
        
        if(node == v){
            return true;
        }
        
        
        // check for the differnt colors at the given node
        for(int i=1; i<=m; i++){
            if(isSafe(node,i,adj,color,v)) {
                color[node] = i;
               if(solve(node+1,adj,color,v,m) ==  true) return true;
                // backtrack
                color[node] = 0;
            }
        }
        return false;
    }
    
    boolean graphColoring(int v, int[][] edges, int m) {
        // code here
        
        
        // create a adjacency list
        int[][] adj = new int[v][v];
        
        for(int[] e : edges){
            adj[e[0]][e[1]] = 1;
            adj[e[1]][e[0]] = 1;
        }
        
        // maintain a color array
        int[] color = new int[v];
        
        // recursive function
        return solve(0,adj,color,v,m);
        
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        int V = 4;
        int[][] edges = {{0, 1}, {1, 3}, {2, 3}, {3, 0}, {0, 2}};
        int m = 3;
        boolean result = sol.graphColoring(V, edges, m);
        System.out.println("Can the graph be colored with " + m + " colors? " + result);
    }
}