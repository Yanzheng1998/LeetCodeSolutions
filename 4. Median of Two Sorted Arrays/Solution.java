class Solution {
    double search_median(int[] nums1, int[] nums2, int imin, int imax, int sum_ij) {
        int i = (imin + imax)/2;
        int j = sum_ij - i;
        int max1Left = (i==0)? Integer.MIN_VALUE: nums1[i-1];
        int min1Right = (i==nums1.length)? Integer.MAX_VALUE: nums1[i];
        int max2Left = (j==0)? Integer.MIN_VALUE: nums2[j-1];
        int min2Right = (j==nums2.length)? Integer.MAX_VALUE: nums2[j];
        if (max1Left > min2Right) {
            return search_median(nums1, nums2, imin, i-1, sum_ij);
        }
        else if (min1Right < max2Left) {
            return search_median(nums1, nums2, i+1, imax, sum_ij);
        }
        else {
            if ((nums1.length + nums2.length)%2 == 1) {
                return Math.max(max1Left,max2Left);
            }
            else {
                return (Math.max(max1Left,max2Left)+Math.min(min1Right,min2Right))/2.0;
            }
        }
                            
    }
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int sum_ij = (m+n+1)/2;
        if (n<m) return findMedianSortedArrays(nums2, nums1);
        return   search_median(nums1, nums2, 0, m, sum_ij);
    }
}
