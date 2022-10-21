/**
 * Given the array nums （used to sorted）after the possible rotation 
 * and an integer target, return the index of target if it is in nums, 
 * or -1 if it is not in nums.
 * 
 * 1 <= nums.length <= 5000
 * All values of nums are unique.
 * nums is an ascending array that is possibly rotated.
 * 
 * leetcode:
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
*/
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ?  0 : -1;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < nums[right]) {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return nums[left] == target ? left : (nums[right] == target ? right : -1);

    }
}