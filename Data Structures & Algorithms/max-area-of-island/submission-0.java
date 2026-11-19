class Solution {
    private static int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private int dfs(int[][] grid, boolean[][] vis, int i, int j) {
        int m = grid.length, n = grid[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0 || vis[i][j]) return 0;

        vis[i][j] = true;
        int result = 1;

        for (int[] direction: directions) {
            result += dfs(grid, vis, i+direction[0], j+direction[1]);
        }

        return result;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        boolean[][] vis = new boolean[m][n];

        int islandArea = 0;

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (vis[i][j] == true) continue;

                if (grid[i][j] == 1) {
                    islandArea = Math.max(islandArea, dfs(grid, vis, i, j));
                }
            }
        }

        return islandArea;
        
    }
}