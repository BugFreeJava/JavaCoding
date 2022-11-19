## LinkedList

### Conditions
1. The problem mentions the data structure it uses is LinkedList.
2. The problem wants you to implement a new data structure and this struture's operations' time complexity should be O(1). Like get / put / delete operations have to be O(1)
3. The problem needs some data structure like Stack / Queue / Deque, you should use Java LinkedList.

### Solution Tips
1. If the data structure provided by problem is LinkedList. Mostly, it needs you do something to a linkedlist, like find the middle node, delete a node or reorder it.
```
- The Most important part for this condition is NEVER LOSE CONTROL OF HEAD NODE. Using a dummy head points
  to head node, and do not move this dummy head, then you will not lose control of head node.

- Two pointers. For some problems which need you to modify current linkedlist, or create a new linkedlist
  based on exiting lists, you could consider use two pointers.
```

2. If the problem needs you to implemente a new data structure.
```
- Define the Node, node is basic component of linkedlist, you could customize it based on your requirement.
  Most of time, you only need to make sure this Node class has two fields: value and next.

- Define the LinkedList or you could named it as NodeList, this class should at least has one field: head.

- Implements basic operations like add / delete / update.
```

3. If the problem should be solved by stack / queue / deque, I will discuss this condition when I introduce those three data structures.



