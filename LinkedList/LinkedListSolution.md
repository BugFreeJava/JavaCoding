### Solutions

#### Remove Duplicats from sorted list
1. Clarification:
	1. is that possible this list is null or empty? Yes. Because the number of nodes is in the range [0, 300]
2. Solution:
	1. Base case: if the list is null or only has one node, we do not need to do anything, directly return current head;
	2. Otherwise, since we need to remove some nodes, to avoid losing control of nodes, I will define one pointer -- cur, and first let cur = head, everytime I will move cur and do check. Do while until cur points to null or cur does not have next node. Why? Because the problem requires us to remove all duplicated elements, if cur points to null or cur is last node, we know after cur, it is impossible to find the duplicated elements, so we stop;
		1. if cur's value is equals to cur's next node's value, means we need to remove the node next to cur, in other words, we want cur point to the next node of cur.next, which is cur.next = cur.next.next;
		2. Otherwise, we directly move cur node to its next, which is cur = cur.next;
	3. After we check all nodes in the list, we return head;
3. Complexity
	1. Time Cost: Since we visit all nodes, so it will be O(n) where n is the number of nodes.
	2. Space Cost: Since we do not use any extra space, so it will be O(1)

#### Reverse LinkedList
1. Clarification:
	1. is that possible this list is null or empty? Yes. Because the number of nodes is in the range [0, 500]
2. Solution:  
The tip of this problem is since I want to reverse the list, that means for each node, I want:
`
myself.newNext = myself.Oldprev; myself.newPrev = myself; myself = myself.oldNext;  
`
	1. Base case: if the list is null or only has one node, we do not need to do anything, directly return current head;
	2. Define a pointer prev which represents the previous node, a pointer cur which represens the current visited node. Do while loop for all nodes which means do check until cur points to null
		1. Use pointer `next` to store the next node of cur, make sure we will not lose control of list node
		2. if I want to reverse two nodes means: 
			1. let cur's next node points to cur previous node: cur.next = prev;
			2. let cur's previous node points to cur: prev = cur;
			3. move cur pointer to reverse next node: cur = next;
	3. Since we already reverse the whole list, currently the new head of this list will be prev, return it.
3. Complexity
	1. Time Cost: Since we visit all nodes, so it will be O(n) where n is the number of nodes.
	2. Space Cost: Since we do not use any extra space, so it will be O(1)

#### Middle Of LinkedList
1. Clarification:
	1. is that possible this list is null or empty? No. Because the number of nodes is in the range [1, 100]
	2. If the number of nodes is even, which node we should return? Return the second middle node, which means 1,2,3,4. you should return 3.
2. Solution:
The tips of this problem is two pointers, one is fast and another is slow, here is a basic math knowledge: if one pointer move two times fast than another one, and they start from the same point at same time, and stop at same time, the slow one's distance will be the half of the fast's distance. So we use this one to solve the problem.
	1. Define two points: slow and fast, let them first point to head together;
	2. Since we want to find middle and if the length is even, we want the second middle, so we do while loop util fast's next is null. For each loop, we do:  
		1. slow move one step -> slow = slow.next;
		2. fast move two steps -> fast = fast.next.next;
	3. After loops, we know the slow one will stop at the middle of whole list, so we return slow;
3. Complexity
	1. Time Cost: Since we visit all nodes, so it will be O(n) where n is the number of nodes.
	2. Space Cost: Since we do not use any extra space, so it will be O(1)

#### Palidrome LinkedList
1. Clarification:
	1. is that possible this list is null or empty? No. Because the number of nodes is in the range [1, 10<sup>5</sup>]
2. Solution:
	1. Find Middle Node
	2. Reverse right half lists (reverse(middle.next))
	3. Compare (head - middle) and reversed right part
3. Complexity
	1. Time Cost: O(n / 2) for find middle + O(n / 2) for reverse right part + (O / 2) to compare ~ O(n)
	2. Space Cost: Since we do not use any extra space, so it will be O(1)

#### Add Two Numbers
1. Clarification:
	1. is that possible those two lists are null or empty? No. Because the number of nodes in each list is in the range [1, 100]
2. Solution:
	Considering the basic math knowledge: if you sum up two numbers, when you stop caculate? You will stop caculate when all digits of two numbers are used and no carry exists. Same for this problem;
	1. Since We do not want to lose control of lists, define one dummy head and a new cur node which also point to dummy head now. Also we need a carry to make sure we will not lose value when we do caculate.
	2. Do while loop until no digit could be find from two lists and carry is 0.
		1. get digit from each list, which need to pay attention on is if one list's all nodes are visited, its current digit should be 0;
		2. sum two digits and the carry
		3. update the carry and sum, carry will be use for next caculate and sum will be the value of current node
		4. create a new node based on current sum and let cur's next points to this new node.
		5. move cur pointer to continue caculate.
		6. move pointer of each list if they still have next node
	3. Return dummy.next as result;
3. Complexity
	1. Time Cost: O(n) n is the max length of two lists
	2. Space Cost: Since we use an extra space, so it will be O(n) n is the max length of two lists

#### Partition Part
1. Clarification:
	1. is that possible those two lists are null or empty? Yes. Because the number of nodes in each list is in the range [0, 200]
2. Solution:
	1. Define two dummyHeads for left and right parts, define two current pointers (left, right) for each parts
	2. Do while loop until all nodes of current list are visited
		1. compare cur.value with given target value
		2. If bigger -> add it to right, otherwise add it to left; (xxx.next - cur, xxx = xxx.next)
		3. move cur point to check next nodes of current list (cur = cur.next)
	3. Make sure last node of left will point to first node of right part (left.next = rightDummy.next)
	4. Release last node of right to make sure there is no cycle. (right.next = null)
	5. Return leftDummy.next as result;
3. Complexity
	1. Time Cost: O(n) n is the length of the list
	2. Space Cost: Since we do not use any extra space, so it will be O(1)

#### LRU Cache
`You can consider it as an OOD question.`

1. Thinking based on requirements: 
	1. Get should be O(1), based on key to get value and the time cost should be O(1), the first idea is using Map. 
	2. But if only use map, when do `put`, it mentioned if the number of keys exceeds the capacity, you need to delete least recently used key, map could not make sure this operation is O(1).  
	3. Thinking about least recently used, that means once you `get` it or `update` its value or `create` it, you need to make sure this `key-value` pair will be marked as used.  So you need to `move` it. The `move` contains two operations: `delete` it first then `insert` it again. We need to make sure those two operations are O(1). Only one data structure could do this -- LinkedList;  
	4. So let's combine Map and LinkedList together: Map used to record the relationship between key and value, linkedList used to record the usage of each node. 
2. Based on our thinking:
	1. Define a Map[Key(Integer), Value(Node)], head node, tail node and capacity;
	2. For `Get` function:
		1. Get node based on key
		2. If could not find node, means this cache does not have this value, return -1;
		3. Otherwise, first delete this node, and then insert this node to tail again, which is used to update the usage status of this node to make sure it is marked as most-recently used. Then return its value;
	3. For `Put` function:
		1. Get node based on key
		2. If could not find node
			1. Check whether the capacity exceeds
			2. If yes, first delete current head node which is least recently used node, also remove head node from map.
			3. Create a new node based on key and value;
		3. If could find node, update its value and delete this node
		4. Insert this node to tail again. Also put it in map.
	4. Helper Function - `Delete`
		1. If node's previous node exists, let node.prev.next = node.next;
		2. If node's next node exists, let node.next.prev = node.prev;
		3. If node is head node, directly let head's next node as new head;
		4. If node is tail node, directly let tail's previous node as new tail;
		5. Release node by let node.prev and node.next point to null;
	5. Helper Function - `Insert`
		1. If head is null, means list do not have any nodes, let head and tail point to node
		2. Otherwise, put current node after tail and let current node as new tail;


https://pythontutor.com/visualize.html#mode=edit