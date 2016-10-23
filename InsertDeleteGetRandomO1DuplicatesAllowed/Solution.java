public class RandomizedCollection {
    private List<Integer> nums;
    private Map<Integer, Set<Integer>> map;
    private Random rand;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        this.nums = new ArrayList<>();
        this.map = new HashMap<>();
        this.rand = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contains = map.containsKey(val);
        if (!contains) {
            map.put(val, new HashSet<>());
        }
        map.get(val).add(nums.size());
        nums.add(val);
        
        return !contains;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        
        Set<Integer> remSet = map.get(val);
        int remInd = remSet.iterator().next(), lastPos = nums.size() - 1;
        
        Set<Integer> substSet = map.get(nums.get(lastPos));
        nums.set(remInd, nums.get(lastPos));
        
        remSet.remove(remInd);
        substSet.add(remInd);
        substSet.remove(lastPos);
        
        if (remSet.isEmpty()) {
            map.remove(val);
        }
        
        nums.remove(lastPos);
        
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}
