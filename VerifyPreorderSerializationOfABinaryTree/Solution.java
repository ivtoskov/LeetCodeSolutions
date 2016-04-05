public class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int number = 1;
        for(int i = 0; i < nodes.length; ++i) {
            if(number == 0) {
		          return false;
            }
            
            if("#".equals(nodes[i])) --number;
            else ++number;
        }
        return number == 0;
    }
}
