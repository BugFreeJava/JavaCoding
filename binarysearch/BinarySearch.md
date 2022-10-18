## Binary Search

### Rules
1. if you want to use binary search, the data should follow the rule: Have to be sorted, could be fully sorted, or partly sorted.
2. Your solution should
	1. guarantee that the search space decreases over time (after each iteration)
	2. guarantee that the target (if exist) cannot be ruled out accidentally, when we change the value of Left or Right. (It is critical to define the rule about how to move the range for search)

### Solution Template

```
int left = 0; // points to first element
int right = array.length - 1; // points to last element

// always make sure the last search range include three elements
// this could avoid over-range search.
while (left < right - 1) {
	int mid = left + (right - left) / 2;

	if (array[mid] matches requirments) {
		do something like return mid
	} else if (array[mid] is bigger than requirment) {
		do something to reduce the search space by abandon HALF part
		like right = mid - 1;
	} else {
		do something to reduce the search space by abandon HALF part
		like left = mid + 1;
	}
}

check current left;
check for current right;

return result;
```

### Tips
Here are something you need to pay attention on, might be useful during interview:
1. Why you use `mid = left + (right - left) / 2` not `mid = (right + left) / 2`?  
This is when we do `left + right` it might will over the max range of INT which will bring some error. 
2. Even though here is a SKILL which could help you avoid over-range issue, but if you are asked to change this while condition.  
You could do a quick analysis by using an array with two elements and an array with three elements, this will help you pick `left <= right` or `left < right` or other possible conditions.