public class Solution {
    public boolean validUtf8(int[] data) {
        for (int i = 0; i < data.length; ++i) {
            int following = countFollowing(data[i]);
            if (following == -1) {
                return false;
            }
            for (int j = 1; j <= following; ++j) {
                if (i + j >= data.length || (data[i + j] >> 6) != 0b10) {
                    return false;
                }
            }
            i += following;
        }
        return true;
    }
    
    private int countFollowing(int num) {
        int count = 0, mask = (1 << 7);
        while ((num & mask) != 0) {
            ++count;
            mask >>= 1;
        }
        if (count == 1) {
            return -1;
        }
        return count > 0 ? count - 1 : 0;
    }
}
