class Solution {

    public void islandsAndTreasure(int[][] grid) {
     int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        // Add all treasure cells
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        while (!queue.isEmpty()) {

            int[] curr = queue.poll();

            int i = curr[0];
            int j = curr[1];

            for (int[] dir : directions) {

                int x = i + dir[0];
                int y = j + dir[1];

                if (x < 0 || y < 0 ||
                    x >= m || y >= n ||
                    grid[x][y] != Integer.MAX_VALUE) {
                    continue;
                }

                grid[x][y] = grid[i][j] + 1;

                queue.offer(new int[]{x, y});
            }
        }
    }
}