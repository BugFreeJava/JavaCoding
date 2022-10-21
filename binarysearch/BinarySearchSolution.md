### Solutions

#### Classical Binary Search
1. Clarification: 
	1. does this array has duplicate elements? No
	2. is that possible this array is null or empty? No
2. Solution:  
	Since this problem is based on a sorted array, I think we could use binary search to  
	reduce the search time.  
	
	My solution is:  
	1. Firstly I want to define two variables: left and right. They means the search range we are looking for.
	2. These two elements should first points to 0 and last element of array.
	3. Then I will do a while loop, this loop will be ended when the search range only has two elements, so it will do search while left < right - 1
	4. In each loop, I will first get the middle index of current search range.
	5. The I will compare the element at the middle index with the target element.
	6. If current middle element is equals to target, we return middle index. If current middle element is smaller than target, we move left to mid + 1; Otherwise, we move right to mid - 1;
	7. After we finish the while loop, we still have two elements, so we also do check with those two elements.
3. Complexity
	1. Time Cost: Since we use binary search, so it will be O(log n) where n is the length of array.
	2. Space Cost: Since we do not use any extra space, so it will be O(1)

#### Find First and Last Position of Element in Sorted Array
1. Clarification: 
	1. does this array has duplicate elements? Yes
	2. is that possible this array is null or empty? Yes, it could be empty.
2. Solution:  
	Since this problem is based on a sorted array, I think we could use binary search to  
	reduce the search time.  

	My solution is:  
	1. I will use two helper functions to find first position and last position.
	2. To finding first position, I will use two points left and right to represents the search range. I will do the while loop until the search range only has two elements. For each while loop, after I get the middle elememt, I will compare it with target:
		1. if middle elememt == target, I will let right = mid since I know it is impossible to find the first position after current middle index.
		2. if middle element > target, I will move right to mid - 1; otherwise, I will move left to mid + 1;
		3. after finish the while loop, I will first check the left element since we want to find the first position.
	3. To finding the last position, I will use same logic as we find the first position, but there is a slightly difference: when I find the middle element is equals to target, I will let left = mid, since I could make sure before the middle index, it is impossible to find the last position. And also after while loop, I will first check the right position not the left one.
3. Complexity
	1. Time Cost: Since we use binary search, so it will be O(log n) + O(log n) ~ O(log n) where n is the length of array.
	2. Space Cost: Since we do not use any extra space, so it will be O(1)

#### Find Smallest Letter Greater Than Target
1. Clarification: 
	1. does this array has duplicate elements? Might
	2. is that possible this array is null or empty? No
	3. does all elements in this arrat is lowercase english letters? Yes
2. Solution:  
	Since this problem is based on a sorted array, I think we could use binary search to  
	reduce the search time.  
	
	My solution is:  
	1. Firstly I want to define two variables: left and right. They means the search range we are looking for.
	2. These two elements should first points to 0 and last element of array.
	3. Then I will do a while loop, this loop will be ended when the search range only has two elements, so it will do search while left < right - 1
	4. In each loop, I will first get the middle index of current search range.
	5. The I will compare the element at the middle index with the target element.
	6. If current middle element is equals to target, we return middle element. If current middle element is smaller than target, we move left to mid + 1; Otherwise, we move right to mid - 1;
	7. After we finish the while loop, we still have two elements, so we also do check with those two elements.
3. Complexity
	1. Time Cost: Since we use binary search, so it will be O(log n) where n is the length of array.
	2. Space Cost: Since we do not use any extra space, so it will be O(1)

#### Search Insert Position
1. Clarification: 
	1. does this array has duplicate elements? No
	2. is that possible this array is null or empty? No
2. Solution:
	Basically same as the above problem, but there is an important thing need to pay attention on: after while loop, if we do not return anything, that means:
	1. target element live in last left and last right
	2. target element should be inserted into last left or last right position
	So we should first do the check for left and right, if one of them is equals to target, return the correct index. Otherwise, since we want to insert the target just at the position whose element is smallest bigger than target, so compare with left first, then right. Otherwise means in this last search range, all elements are smaller than target, so we insert this target at right + 1 position.
3. Complexity
	1. Time Cost: Since we use binary search, so it will be O(log n) where n is the length of array.
	2. Space Cost: Since we do not use any extra space, so it will be O(1)

#### Search In Sorted Matrix
1. Clarification: 
	1. does this matrix has duplicate elements? No
	2. is that possible this matrix is null or empty? No
2. Solution:  
	This matrix is special, if you consider this matrix as a long array, which link each line's last element to next line's first element, it will be a sorted array whose length is m * n, where m is the rows of matrix and n is the columns of matrix.
	So what we will do is:  
	1. First get the width and length of matrix, then based on these information to get the length of that long sorted array.
	2. We do the regular binary search to this long array, but every time after we get the middle index, we want to know the row number and column number of this element, which is row = middle / width and col = middle % width (About this, you could derive it by yourself), then based on the row and column number, we could know the element at middle index position, and we use it to compare with target;
	3. Also do not forget to compare last two positions with target.
3. Complexity
	1. Time Cost: Since we use binary search, so it will be O(length) where length should be width * height of matrix
	2. Space Cost: Since we do not use any extra space, so it will be O(1)

#### Search in Rotated Sorted Array
1. Clarification:
	1. does this array has duplicate elements? No
	2. is that possible this array is null or empty? No
2. Solution:  
	Looks like this array is not sorted totally, but this array is partially sorted. And based on the problem description, we could know, this array must like this:
``` 
	  /  
	 /  
	/  
	      /  
	     /  
	    / 
```
	so this means if we do get mid, and use it compare with left and right, we could at least find one part which is sorted. 
	1. set left = 0; right = length - 1
	2. do while loop until left == right - 1  
		1. get mid and compare nums[mid] to target, if matches, return;  
		2. compare nums[mid] with nums[right]  
			1. if nums[mid] < nums[right] means from mid to right part is sorted;  
				1. if nums[mid] < target <= nums[right]: move left = mid + 1; Otherwise,  
				2. move right = mid - 1;  
			2. Otherwise, we know from left to mid is sorted  
				1. if nums[left] <= target < nums[mid]: move right = mid - 1; Otherwise,  
				2. move left = mid + 1;  
	3. compare target with nums[left] and nums[right]
3. Complexity
	1. Time Cost: Since we use binary search, so it will be O(n) where n should be length of array
	2. Space Cost: Since we do not use any extra space, so it will be O(1)

#### Median of Two Sorted Arrays (check https://www.enjoyalgorithms.com/blog/median-of-two-sorted-arrays) 

3. Complexity
	1. Time Cost: Since we use binary search and recursive, so it will be O(log (m + n)) where n and m should be length of arrays
	2. Space Cost: Since we use recursive, so it will be O(log m + n)
