/**
 * Given an array of integers nums sorted in non-decreasing order, 
 * find the starting and ending position of a given target value.
 * If target is not found in the array, return [-1, -1].
 * 
 * leetcode:
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */

public class FirstAndLastPosition {
	public int[] searchRange(int[] nums, int target) {
		int[] result = {-1, -1};
		if (nums.length == 0) {
			return result;
		}

		result[0] = findFirstPosition(nums, target);
		result[1] = findLastPosition(nums, target);

		return result;
	}

	private int findFirstPosition(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;

		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			/**
			 * since we want to find the first position,
			 * so we know that there might be element lives
			 * in left part still be equals to target, then
			 * we let right = mid
			 * 
			*/
			if (nums[mid] == target) {
				right = mid;
			} else if (nums[mid] > target){
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		if (nums[left] == target) {
			return left;
		}

		if (nums[right] == target) {
			return right;
		}

		return -1;
	}

	private int findLastPosition(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;

		while (left < right - 1) {
			/**
			 * since we want to find the last position,
			 * so we know that there might be element lives
			 * in right part still be equals to target, then
			 * we let left = mid
			 * 
			*/
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				left = mid;
			} else if (nums[mid] > target){
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		if (nums[right] == target) {
			return right;
		}

		if (nums[left] == target) {
			return left;
		}

		return -1;
	}
}


