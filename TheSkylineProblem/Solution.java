public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        int[][] points = new int[buildings.length * 2][];
        int index = 0;
        for (int[] building : buildings) {
            points[index++] = new int[] {building[0], -building[2]};
            points[index++] = new int[] {building[1], building[2]};
        }
        Arrays.sort(points, (p1, p2) -> {
           if (p1[0] != p2[0]) {
               return p1[0] - p2[0];
           }
           return p1[1] - p2[1];
        });
        
        PriorityQueue<Integer> prevs = new PriorityQueue<>(Collections.reverseOrder());
        prevs.offer(0);
        int prev = 0;
        
        for (int[] p : points) {
            if (p[1] < 0) {
                prevs.offer(-p[1]);
            } else {
                prevs.remove(p[1]);
            }
            int cur = prevs.peek();
            if (prev != cur) {
                result.add(new int[] {p[0], cur});
                prev = cur;
            }
        }
        
        return result;
    }
}
