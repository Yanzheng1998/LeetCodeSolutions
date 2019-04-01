class DPSolution {
    public String longestPalindrome(String s) {
        if (s.length() == 0)
            return "";
        String sub = "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int j = 0; j<s.length(); j++){
            for (int i = 0; i<=j; i++){
                if (i==j) {
                    dp[j][i] = true;
                }
                else if (i == j-1) {
                    if (s.charAt(i) == s.charAt(j)) dp[j][i] = true;              
                }
                else {
                    if (dp[j-1][i+1] == true && s.charAt(i) == s.charAt(j))
                        dp[j][i] = true;
                }
                if (dp[j][i] == true && j-i+1 >sub.length()) sub = s.substring(i,j+1);
            }
        } 
        return sub;
    }
}
