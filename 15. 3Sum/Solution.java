class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < len; i++) {
            // stop earlier when there`s no possible solution(ith number in the sorted array is already larger than target)
            if (nums[i] > 0) {
                break;
            }
            // avoid dup
            if(i > 0 && (nums[i] == nums[i-1])) continue;
            int start = i + 1;
            int end = nums.length - 1;
            
            while (start < end) {
                int twoSum = nums[start] + nums[end];
                if (twoSum == -nums[i]) {
                    result.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    //avoid dup
                    while (start < end && nums[start] == nums[start+1]) start++;
                    while (end > start && nums[end] == nums[end-1]) end--;
                    start++;
                    end--;
                }
                else if (twoSum > -nums[i]) {
                    end--;           
                }
                else {
                    start++;    
                }
            }
        }
        return result;
    }
}
