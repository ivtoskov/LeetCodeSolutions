public class Solution {
	public List<List<String>> findLadders(String endWord, String beginWord, Set<String> wordList) {
		wordList.add(endWord);
		Queue<Node> queue = new LinkedList<>();
		Set<String> visited = new HashSet<>(), unvisited = new HashSet<>();
		unvisited.addAll(wordList);
		int level = 0, minDist = Integer.MAX_VALUE;
		List<List<String>> result = new ArrayList<>();

		queue.add(new Node(beginWord, null, 0));
		visited.add(beginWord);

		while (!queue.isEmpty()) {
			Node current = queue.remove();
			if (current.val.equals(endWord) && current.dist <= minDist) {
				minDist = current.dist;
				addPath(result, current);
				continue;
			}

			if (current.dist > minDist) {
				break;
			}

			if (current.dist > level) {
				unvisited.removeAll(visited);
				level = current.dist;
			}

			addNeighbours(queue, visited, unvisited, current);
		}

		return result;
	}

	private void addNeighbours(Queue<Node> queue, Set<String> visited, Set<String> unvisited, Node current) {
		char[] chars = current.val.toCharArray();
		for (int i = 0; i < chars.length; ++i) {
			for (char c = 'a'; c <= 'z'; ++c) {
				char tmp = chars[i];
				chars[i] = c;
				String nbr = new String(chars);
				if (unvisited.contains(nbr)) {
					queue.add(new Node(nbr, current, current.dist + 1));
					visited.add(nbr);
				}
				chars[i] = tmp;
			}
		}
	}

	private void addPath(List<List<String>> result, Node current) {
		List<String> path = new ArrayList<>(current.dist);
		while (current != null) {
			path.add(current.val);
			current = current.parent;
		}
		result.add(path);
	}

	private class Node {
		String val;
		Node parent;
		int dist;

		private Node(String val, Node parent, int dist) {
			this.val = val;
			this.parent = parent;
			this.dist = dist;
		}
	}
}
