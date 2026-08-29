class Solution {
    public int maxAreaOfIsland(int[][] grid) 
    {
        int max =0;
        int count=0;
        for(int r = 0;r< grid.length;r++){
            for(int c=0;c<grid[0].length;c++){
                if (grid[r][c]==1){
                    count = areadfs(grid, r,c);
                    if (max<=count)
                    max= count;
                   }
                }
            
            }
             return max;
        }
       

    public int areadfs(int[][] grid, int r, int c){
         if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) {
            return 0;
         }
         grid[r][c]=0;

        return 1 + areadfs(grid, r+1, c) + areadfs(grid, r-1, c) + areadfs(grid, r, c+1) + areadfs(grid, r, c-1);

    }
}
