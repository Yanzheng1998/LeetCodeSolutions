class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """  
        if not s:
            return 0
        dp = [0]*len(s)
        d = defaultdict(int)
        for i in range(len(s)):
            if s[i] not in d or i - d[s[i]] > dp[i-1]:
                dp[i] = dp[i-1] + 1
            else:
                dp[i] = i - d[s[i]]
            d[s[i]] = i
        return max(dp)
