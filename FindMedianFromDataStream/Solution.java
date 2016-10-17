public class MedianFinder {
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    
    // Adds a number into the data structure.
    public void addNum(int num) {
        if (minHeap.isEmpty() || minHeap.peek() <= num) {
            minHeap.add(num);
        } else {
            maxHeap.add(num);
        }
        balanceHeaps();
    }
    
    private void balanceHeaps() {
        PriorityQueue<Integer> smaller = minHeap.size() < maxHeap.size() ? minHeap : maxHeap;
        PriorityQueue<Integer> bigger = minHeap == smaller ? maxHeap : minHeap;
        
        if (smaller.size() + 1 < bigger.size()) {
            smaller.add(bigger.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        PriorityQueue<Integer> smaller = minHeap.size() < maxHeap.size() ? minHeap : maxHeap;
        PriorityQueue<Integer> bigger = minHeap == smaller ? maxHeap : minHeap;
        
        if (bigger.size() > smaller.size()) {
            return bigger.peek();
        }
        return (smaller.peek() + bigger.peek()) / 2.0;
    }
};
