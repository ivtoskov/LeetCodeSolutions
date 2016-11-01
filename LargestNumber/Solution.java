public class Solution {
    public String largestNumber(int[] nums) {
        String result = IntStream.of(nums).mapToObj(Integer::toString).sorted((num1, num2) -> (num2 + num1).compareTo(num1 + num2)).collect(Collectors.joining(""));
        return (result.charAt(0) == '0') ? "0" : result;
    }
}
