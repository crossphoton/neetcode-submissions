class Solution {
    private static int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private void dfs(char[][] grid, boolean[][] vis, int i, int j) {
        int m = grid.length, n = grid[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0' || vis[i][j]) return;

        vis[i][j] = true;

        for (int[] direction: directions) {
            dfs(grid, vis, i+direction[0], j+direction[1]);
        }
    }

    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;

        boolean[][] vis = new boolean[m][n];

        int islandCount = 0;

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (vis[i][j] == true) continue;

                if (grid[i][j] == '1') {
                    dfs(grid, vis, i, j);
                    islandCount++;
                }
            }
        }

        return islandCount;
    }
}
