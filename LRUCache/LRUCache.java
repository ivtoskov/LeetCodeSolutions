public class LRUCache {
    private int size;
	private final int capacity;
	private final Map<Integer, ListNode> map;
	private ListNode head, tail;

	public LRUCache(int capacity) {
		this.size = 0;
		this.capacity = capacity;
		this.map = new HashMap<>(capacity);
		this.head = null;
		this.tail = null;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			update(key, map.get(key).value);
			return map.get(key).value;
		} else {
		    return -1;
		}
	}

	public void set(int key, int value) {
		update(key, value);
		if (size > capacity) {
			removeKey(tail.key);
		}
	}
	
	private void update(int key, int value) {
		removeKey(key);
		insertAtTop(key, value);
	}

	private void insertAtTop(int key, int value) {
		ListNode node = new ListNode(key, value);
		++size;
		map.put(key, node);

		if (head == null) {
			head = tail = node;
			return;
		}

		node.next = head;
		head.prev = node;
		head = node;
	}

	private void removeKey(int key) {
		removeNode(map.get(key));
		map.remove(key);
	}

	private void removeNode(ListNode node) {
		if (node == null) {
			return;
		}

		if (node.prev != null) {
			node.prev.next = node.next;
		} else {
			head = node.next;
		}

		if (node.next != null) {
			node.next.prev = node.prev;
		} else {
			tail = node.prev;
		}
		--size;
	}

	private class ListNode {
		int key;
		int value;
		ListNode prev;
		ListNode next;

		ListNode(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
}


