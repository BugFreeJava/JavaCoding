/**
 * Given a sorted array of distinct integers and a target value, 
 * return the index if the target is found. If not, return the index 
 * where it would be if it were inserted in order.
 * 
 * leetcode:
 * https://leetcode.com/problems/search-insert-position/
*/

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right - 1) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (nums[left] == target) {
            return left;
        }

        if (nums[right] == target) {
            return right;
        }

        // always insert this value before the first element bigger than it
        if (nums[left] > target) {
            return left;
        }

        if (nums[right] > target) {
            return right;
        }

        // if both left and right element is smaller than this target, means
        // we need to add this target after the end of current range, which is right + 1;
        return right + 1;
    }
}