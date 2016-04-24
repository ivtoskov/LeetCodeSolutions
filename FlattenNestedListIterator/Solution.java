public class NestedIterator implements Iterator<Integer> {
    private List<Integer> innerList;
    private Iterator<Integer> innerIt;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.innerList = new ArrayList<>();
        flatten(nestedList);
        innerIt = innerList.iterator();
    }
    
    private void flatten(List<NestedInteger> nestedList) {
        for(NestedInteger ni: nestedList) {
            if(ni.isInteger()) {
                innerList.add(ni.getInteger());
            } else {
                flatten(ni.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return innerIt.next();
    }

    @Override
    public boolean hasNext() {
        return innerIt.hasNext();
    }
}
