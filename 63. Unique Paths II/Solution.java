class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[] dp = new int[obstacleGrid[0].length];
        if (obstacleGrid[0][0] != 1) dp[0] = 1;
        else dp[0] = 0;
        for (int i = 1; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] != 1) dp[i] = dp[i-1];
            else dp[i] = 0;
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                int temp = 0;
                if (obstacleGrid[i][j] != 1) temp += dp[j];
                if (j > 0 && obstacleGrid[i][j] != 1) temp +=dp[j-1];
                dp[j] = temp;
            }
        }
        return dp[obstacleGrid[0].length-1];
    }
}
