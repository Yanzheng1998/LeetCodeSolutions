class Solution {
    int find_max(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[max]) {
                max = i;
            }
        }
        return max;
    } 
    
    
    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int max = find_max(height);
        // System.out.println(max);
        int prev_idx = 0;
        // int prev_min_idx = 0;
        int curr_idx = 1;
        int sum = 0;
        for ( curr_idx = 1;curr_idx < max+1; curr_idx++) {
            if (height[curr_idx] >= height[prev_idx]) {
                prev_idx = curr_idx;
            }
            else {
                sum+=height[prev_idx] - height[curr_idx];
            }
        }
        prev_idx = height.length - 1;
        for ( curr_idx = height.length - 2; 
             curr_idx > max; curr_idx -- ) {
                        if (height[curr_idx] >= height[prev_idx]) {
                prev_idx = curr_idx;
            }
            else {
                sum+=height[prev_idx] - height[curr_idx];
            }
        }
        return sum;
    }
}
