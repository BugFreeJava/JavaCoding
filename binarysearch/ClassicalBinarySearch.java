/**
 * Given an integer array (nums) which sorted in ascending order and
 * a target integer (target). Please find the index of i such that
 * nums[i] == target. If you could not find any number from nums is
 * equal to target, return -1;
 * 
 * Attendtion: the array does not include any duplicate elements.
 * and the array is not empty, it at least has one element.
 * 
 * leetcode: https://leetcode.com/problems/binary-search/
 * 
*/
import java.util.*;
public class ClassicalBinarySearch {
	public static int binarySearch(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;

		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			int midValue = nums[mid];

			if (midValue == target) {
				return mid;
			} else if (midValue > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return nums[left] == target ? left : (nums[right] == target ? right : -1);
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5};
		int[] targets = {2, 4, 6};
		int[] expectedResults = {1, 3, -1};

		for (int i = 0; i < targets.length; i++) {
			boolean isCorrect = binarySearch(nums, targets[i]) == expectedResults[i];
			String message = isCorrect ? "Correct" : "Wrong";
			System.out.println(message);
		}
	}
}