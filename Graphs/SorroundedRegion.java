public class SorroundedRegion {
    int rows;
    int cols;
    void dfs(int row, int col, char[][] board) {
        if(row < 0 || row >= rows || col < 0 || col >= cols || board[row][col] != 'O') {
            return;
        }
        board[row][col]='T';
        dfs(row-1,col,board);
        dfs(row,col-1,board);
        dfs(row+1,col,board);
        dfs(row,col+1,board);
    }
    public void solve(char[][] board) {
        rows = board.length;
        cols = board[0].length;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(board[i][j]=='O' && ((i == 0 && i == rows-1) || (j == 0 && j == cols-1))) {
                    dfs(i,j, board);
                }
            }
        }

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(board[i][j]=='O') {
                    board[i][j]='X';
                }
            }
        }

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(board[i][j]=='T') {
                    board[i][j]='O';
                }
            }
        }
    }
}
