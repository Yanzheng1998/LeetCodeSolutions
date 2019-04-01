class Solution {
    public boolean canPermutePalindrome(String s) {

        HashMap<Character, Integer> map = new HashMap<>(); 
        for(char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int odd_num = 0;
        for (int i : map.values()) {
            if (i%2==1) {
                odd_num++;
                if (odd_num>1) return false;
            }
        }
        return true;
    }
}
