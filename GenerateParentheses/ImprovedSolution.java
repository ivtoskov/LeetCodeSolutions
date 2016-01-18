public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        char[] perm = new char[n * 2];
        perms(n, n, perm, 0, res);
        return res;
    }

    private void perms(int open, int close, char[] perm, int i, List<String> res) {
        if (i == perm.length) {
            res.add(new String(perm));
            return;
        }
        if (open > 0 && close >= open) {
            perm[i] = '(';
            perms(open - 1, close, perm, i+1, res);
        }
        if (close > 0 && close >= open) {
            perm[i] = ')';
            perms(open, close - 1, perm, i+1, res);
        }
    }
}
