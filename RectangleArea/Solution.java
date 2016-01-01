public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int interWidth = Math.min((C > E ? C - E : 0) - (A > E ? A - E : 0), (G > A ? G - A : 0) - (E > A ? E - A : 0));
        int interHeight = Math.min((D > F ? D - F : 0) - (B > F ? B - F : 0), (H > B ? H - B : 0) - (F > B ? F - B : 0));
        return (C - A) * (D - B) + (G - E) * (H - F) - interWidth * interHeight;
    }
}
