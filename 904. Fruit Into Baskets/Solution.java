class Solution {
    public int totalFruit(int[] tree) {
        if (tree.length <= 2) {
            return tree.length;
        }
        int l_a1 = 0;
        int l_a2 = -1;
        int l_b1 = -1;
        int l_b2 = -1;
        int i;
        int max_len = 0;
        int previous_max = -1;
        for ( i = 0; i<tree.length; i++) {
            max_len++; 
            if (tree[i] == tree[l_a1]) {
                l_a2 = i;
            } else {
                l_b1 = i;
                l_b2 = i;
                break;
            }
            
        }
        System.out.println(max_len);
        previous_max = max_len;
        for (i=max_len;i<tree.length; i++) {
            if (tree[i] == tree[l_a1]) {
                l_a2 = i;
                max_len++;
            } 
            else if (tree[i] == tree[l_b1]){
                l_b2 = i;
                max_len++;
            }
            else {
                if (tree[i-1] == tree[l_a1]) {
                    max_len = i - l_b2 ;
                    l_a1 = l_a2;
                    l_b1 = l_b2 = i;
                }
                else {
                    max_len = i - l_a2 ;
                    l_b1 = l_b2;
                    l_a1 = l_a2 = i;
                } 
            }
            if (max_len > previous_max) {
                previous_max = max_len;
            }
        }
        return previous_max;
    }
}
