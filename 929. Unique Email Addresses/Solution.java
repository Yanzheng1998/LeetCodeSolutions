class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<String>();
        for (String email: emails) {
        StringBuilder sb = new StringBuilder();
            for(char c: email.toCharArray()) {
                if (c == '.') continue;
                if (c == '+') break;
                if (c == '@') break;
                sb.append(c);
            }
            String cur = sb.toString() +           email.substring(email.indexOf('@'));
            set.add(cur);
        }
        return set.size();
    }
}
