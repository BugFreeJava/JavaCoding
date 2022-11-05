public class LinkedList {
	Node head;
	Node tail;

	public void add(int data) {
		Node newNode = new Node(data);

		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = tail.next;
		}
	}

	public void delete(Node node) {
		if (node.prev != null) {
			node.prev.next = node.next;
		}

		if (node.next != null) {
			node.next.prev = node.prev;
		}

		if (node == head) {
            head = head.next;
        }
        
        if (node == tail) {
            tail = tail.prev;
        }
        
        node.prev = null;
        node.next = null;

	}


	class Node {
		int data;
		Node next;
		Node prev;

		public Node(int data) {
			this.data = data;
		}
	}
}