public class ImprovedSolution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n + 1];
        for(int cit: citations) {
            if(cit >= n) {
                buckets[n]++;
            } else {
                buckets[cit]++;
            }
        }
        
        for(int i = n, count = 0; i >= 0; --i) {
            count += buckets[i];
            if(count >= i) {
                return i;
            }
        }
        return 0;
    }
}
