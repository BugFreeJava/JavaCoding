/**
 * Given two sorted arrays nums1 and nums2 of size m and n 
 * respectively, return the median of the two sorted arrays.
 * 
 * leetcode:
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 */
public class MedianOfTwoSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        return (findKth(nums1, 0, nums2, 0, (m + n + 1) / 2) + findKth(nums1, 0, nums2, 0, (m + n + 2) / 2)) / 2.0;
    }
    
    private int findKth(int[] a, int i, int[] b, int j, int k) {
        if (i >= a.length) {
            return b[j + k - 1];
        }
        
        if (j >= b.length) {
            return a[i + k - 1];
        }
        
        if (k == 1) {
            return Math.min(a[i], b[j]);
        }
        
        int mid1 = (i + k / 2 - 1) < a.length ? a[i + k / 2 - 1] : Integer.MAX_VALUE;
        int mid2 = (j + k / 2 - 1) < b.length ? b[j + k / 2 - 1] : Integer.MAX_VALUE;
        
        if (mid1 <= mid2) {
            return findKth(a, i + k / 2, b, j, k - k / 2);
        }
        return findKth(a, i, b, j + k / 2, k - k / 2);
    }
}