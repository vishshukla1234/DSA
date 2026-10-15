public class NoOfIsland {
    private int m;
    private int n;
    private char[][] grid;

    public int numIslands(char[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        int numIslands = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfsHelper(i, j);
                    numIslands++;
                }
            }
        }
        return numIslands;
    }

    private void dfsHelper(int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0') return;

        grid[i][j] = '0';

        dfsHelper(i - 1, j);
        dfsHelper(i + 1, j);
        dfsHelper(i, j - 1);
        dfsHelper(i, j + 1);
    }
}
