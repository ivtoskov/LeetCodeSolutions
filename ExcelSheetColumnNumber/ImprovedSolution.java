public class ImprovedSolution {
    public int titleToNumber(String s) {
        int answer = 0;
        for(char c: s.toCharArray()) {
            answer = answer * 26 + (c - 'A' + 1);
        }
        return answer;
    }
}
