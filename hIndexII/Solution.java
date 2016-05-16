public class Solution {
    public int hIndex(int[] citations) {
        int l = 0, r = citations.length - 1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(citations[mid] >= citations.length - mid) {
                if(mid - 1 < 0 || citations[mid-1] <= citations.length - mid) {
                    return citations.length - mid;
                }
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return 0;
    }
}
