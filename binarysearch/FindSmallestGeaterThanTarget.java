/**
 * You are given an array of characters letters that is sorted in 
 * non-decreasing order, and a character target. There are at least 
 * two different characters in letters.
 * 
 * Return the smallest character in letters that is lexicographically 
 * greater than target. If such a character does not exist, return the 
 * first character in letters.
 * 
 * leetcode:
 * https://leetcode.com/problems/find-smallest-letter-greater-than-target/
*/

public class FindSmallestGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;

        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (letters[left] > target) {
            return letters[left];
        }

        if (letters[right] > target) {
            return letters[right];
        }

        return letters[0];
    }
}