class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new ArrayDeque<>();
        int[][] visited = new int[n][m];

        int fresh = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j, 0});
                    visited[i][j] = 2;
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int time = 0;

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            int r = curr[0];
            int c = curr[1];
            int t = curr[2];

            time = Math.max(time, t);

            for (int i = 0; i < 4; i++) {
                int nrow = r + drow[i];
                int ncol = c + dcol[i];

                if (nrow >= 0 && ncol >= 0 &&
                    nrow < n && ncol < m &&
                    visited[nrow][ncol] != 2 &&
                    grid[nrow][ncol] == 1) {

                    q.offer(new int[]{nrow, ncol, t + 1});
                    visited[nrow][ncol] = 2;
                    fresh--;
                }
            }
        }

        return fresh == 0 ? time : -1;
    }
}