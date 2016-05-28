public class Solution {
    public int hIndex(int[] citations) {
        int low = 0, high = citations.length;
        while(low < high - 1) {
            int mid = low + (high - low) / 2;
            if(check(citations, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        while(!check(citations, high)) {
            --high;
        }
        return high;
    }
    
    private boolean check(int[] citations, int h) {
        int sat = 0;
        for(int cit: citations) {
            if(cit >= h) {
                ++sat;
            }
        }
        return sat >= h;
    }
}
