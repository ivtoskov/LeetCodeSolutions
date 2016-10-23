public class RandomizedSet {
    private List<Integer> nums;
    private Map<Integer, Integer> map;
    private Random rand;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.nums = new ArrayList<>();
        this.map = new HashMap<>();
        this.rand = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            map.put(val, nums.size());
            nums.add(val);
            return true;
        }
        return false;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        
        int remInd = map.get(val), lastPos = nums.size() - 1;
        
        nums.set(remInd, nums.get(lastPos));
        map.put(nums.get(lastPos), remInd);
        
        map.remove(val);
        nums.remove(lastPos);
        
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}
