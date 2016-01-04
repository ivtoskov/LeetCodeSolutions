public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 0, end = n, mid;
        while(true) {
            mid = start + (end - start) / 2;
            if(isBadVersion(mid)) {
                if(mid >= end) {
                    break;
                } else {
                    end = mid - 1;
                }
            } else {
                start = mid + 1;
            }
        }
        return mid;
    }
}
