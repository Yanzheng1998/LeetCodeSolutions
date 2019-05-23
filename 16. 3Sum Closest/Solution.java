class Solution {
     public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        if (len < 3) return -1;
        Arrays.sort(nums);
        int closestDiff = Integer.MAX_VALUE;
        int closestSum = 0;
        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i-1]) i++;
            int start = i + 1;
            int end = len - 1;
            int lastDiff = Integer.MAX_VALUE;
            while (start < end) {
                int localSum = nums[i] + nums[start] + nums[end];
                int localDiff = localSum - target;
                if (localDiff == 0) {
                    return localSum;
                }               
                else if (localDiff < 0) {
                    if (Math.abs(localDiff) < closestDiff) {
                        closestSum = localSum;
                        closestDiff = Math.abs(localDiff);
                    }
                    start++;
                }
                else {
                    if (Math.abs(localDiff) < closestDiff) {
                        closestSum = localSum;
                        closestDiff = Math.abs(localDiff);
                    }
                    end--;
                }
            }
        }
        return closestSum;
    }
}
