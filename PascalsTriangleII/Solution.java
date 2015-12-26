public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        long temp = 1;
        for(int i = 0; i < rowIndex; ++i) {
            temp = temp * (rowIndex - i) / (i + 1);
            result.add((int)temp);
        }
        return result;
    }
}
