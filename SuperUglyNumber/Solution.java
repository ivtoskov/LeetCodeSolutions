public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        
        PriorityQueue<Num> pq = new PriorityQueue<>();
        for(int i = 0; i < primes.length; ++i) {
            pq.add(new Num(primes[i], 1, primes[i]));
        }
        
        for(int i = 1; i < n; ++i) {
            ugly[i] = pq.peek().val;
            while(pq.peek().val == ugly[i]) {
                Num cur = pq.poll();
                pq.add(new Num(ugly[cur.index] * cur.prime, cur.index + 1, cur.prime));
            }
        }
        
        return ugly[n-1];
    }
    
    private class Num implements Comparable<Num> {
        int val;
        int index;
        int prime;
        
        Num(int val, int index, int prime) {
            this.val = val;
            this.index = index;
            this.prime = prime;
        }
        
        @Override
        public int compareTo(Num other) {
            return this.val - other.val;
        }
    }
}
