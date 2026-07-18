public class matrixFill {
    public static void fillMatrix(int[][] dp) {
        int n = 6;
        int m = 4;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(i == 0 && j == 0) dp[i][j] = 0;
                dp[0][j] = j;
                dp[i][0] = i;
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] dp = new int[6][4];

        fillMatrix(dp);
    }
}
