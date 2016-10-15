public class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        Set<String> points = new HashSet<>();
        int x1 = Integer.MAX_VALUE, y1 = Integer.MAX_VALUE, x2 = Integer.MIN_VALUE, y2 = Integer.MIN_VALUE, area = 0;
        
        for (int[] rect : rectangles) {
            x1 = Math.min(x1, rect[0]);
            y1 = Math.min(y1, rect[1]);
            x2 = Math.max(x2, rect[2]);
            y2 = Math.max(y2, rect[3]);
            
            area += (rect[2] - rect[0]) * (rect[3] - rect[1]);
            
            String p1 = rect[0] + " " + rect[1];
            String p2 = rect[0] + " " + rect[3];
            String p3 = rect[2] + " " + rect[1];
            String p4 = rect[2] + " " + rect[3];
            
            if (!points.add(p1)) {
                points.remove(p1);
            }
            
            if (!points.add(p2)) {
                points.remove(p2);
            }
            
            if (!points.add(p3)) {
                points.remove(p3);
            }
            
            if (!points.add(p4)) {
                points.remove(p4);
            }
        }
        
        return points.contains(x1 + " " + y1) &&
               points.contains(x1 + " " + y2) &&
               points.contains(x2 + " " + y1) &&
               points.contains(x2 + " " + y2) &&
               points.size() == 4 &&
               area == (x2 - x1) * (y2 - y1);
    }
}
