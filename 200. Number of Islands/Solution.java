class Solution {   
    void helper(int i, int j, char[][] grid) {
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
            if (i>0) {
                helper(i-1, j, grid);
            }
            if (i<grid.length-1) {
                helper(i+1, j, grid);
            }
            if (j>0) {
                helper(i, j-1, grid);
            }
            if (j<grid[0].length-1) {
                helper(i, j+1, grid);
            }     
        } else {
            return;
        }       
    }
    
    public int numIslands(char[][] grid) {
        int hgt = grid.length;
        int wid = 0;
        if (grid.length != 0)
            wid = grid[0].length;
 
        int num_island = 0;
        for(int i = 0; i < hgt; i++) {
            for(int j = 0; j < wid; j++) {
                if (grid[i][j] == '1') {
                    num_island++;
                    helper(i, j, grid);
                }         
            }
        }
        return num_island;
    }
}
