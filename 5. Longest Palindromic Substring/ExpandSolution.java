class ExpandSolution {
    int expander(String s, int idx1, int idx2) {
        while (idx1>=0 && idx2<s.length() &&s.charAt(idx1) == s.charAt(idx2)) {
            idx1--;
            idx2++;
        }
        // need the values in last loop
        return idx2-idx1 + 1 - 2;
    }
    
    public String longestPalindrome(String s) {
        if (s.length() == 0) return "";
        int end = 0;
        int start = 0;
        for (int i = 0; i<s.length();i++) {
            int l1 = expander(s,i,i);
            int l2 = expander(s,i,i+1);
            int l = Math.max(l1,l2);
            if (l >= end-start+1) {
                start = i - (l-1)/2;
                end = i + l/2;
            }
        }
        return s.substring(start, end+1);
    }
    
    
}
