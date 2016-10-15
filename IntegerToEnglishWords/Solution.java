public class Solution {
    private String[] bigs = {" Billion", " Million", " Thousand", ""};
    private String[] mids = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private String[] smalls = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private int[] nums = {1_000_000_000, 1_000_000, 1_000, 1};
    
    public String numberToWords(int num) {
        if (num < 0) {
            return "Negative " + numberToWords(-num);
        }
        
        if (num == 0) {
            return "Zero";
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bigs.length; ++i) {
            if (num >= nums[i]) {
                sb.append(numberUpTo1000(num / nums[i]));
                sb.append(bigs[i]);
                num %= nums[i];
                if (num != 0) {
                    sb.append(' ');
                } else {
                    break;
                }
            }
        }
        
        return sb.toString();
    }
    
    public String numberUpTo1000(int num) {
        StringBuilder sb = new StringBuilder();
        
        if (num >= 100) {
            sb.append(smalls[num / 100] + " Hundred");
            if (num % 100 != 0) {
                sb.append(' ');
            }
            num %= 100;
        }
        
        if (num >= 20) {
            sb.append(mids[num / 10]);
            if (num % 10 != 0) {
                sb.append(' ');
            }
            num %= 10;
        }
        
        sb.append(smalls[num]);
        
        return sb.toString();
    }
}
