public class Solution {
    private class Pair implements Comparable<Pair> {
        int num, freq;

        private Pair(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }

        public int compareTo(Pair p) {
            if(this.freq < p.freq) {
                return -1;
            }
            if(this.freq > p.freq) {
                return 1;
            }
            return 0;
        }
    }
    
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqs = new HashMap<>();
        for(int num: nums) {
            if(!freqs.containsKey(num)) {
                freqs.put(num, 0);
            } else {
                freqs.put(num, freqs.get(num) + 1);
            }
        }
        PriorityQueue<Pair> q = new PriorityQueue<>(k, Collections.reverseOrder());
        for(Map.Entry<Integer, Integer> entry: freqs.entrySet()) {
            q.add(new Pair(entry.getKey(), entry.getValue()));
        }
        List<Integer> result = new ArrayList<>();
        while(k-- > 0) {
            result.add(q.poll().num);
        }
        return result;
    }
}
