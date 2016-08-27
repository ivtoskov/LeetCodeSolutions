public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Element> pq = new PriorityQueue<>(new Comparator<Element>() {
            @Override
            public int compare(Element e1, Element e2) {
                return e1.val - e2.val;
            }
        });
        
        Element elem = null;
        for (int i = 0; i < k && i < n; ++i) {
            pq.add(new Element(0, i, matrix[0][i]));
        }
        while (k-- > 0) {
            elem = pq.poll();
            if (elem.x + 1 < n) {
                pq.add(new Element(elem.x + 1, elem.y, matrix[elem.x + 1][elem.y]));
            }
        }
        return elem.val;
    }
}

class Element {
    final int x;
    final int y;
    final int val;
        
    Element(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
    
    @Override
    public String toString() {
        return "matix[" + x + ", " + y + "] = " + val;
    }
}
