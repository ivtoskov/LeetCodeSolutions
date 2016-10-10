public class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Map<String, Double>> eqMap = computeDistances(equations, values);
        double[] result = new double[queries.length];
        
        for (int i = 0; i < queries.length; ++i) {
            if (eqMap.containsKey(queries[i][0])) {
                result[i] = eqMap.get(queries[i][0]).getOrDefault(queries[i][1], -1.0);
            } else {
                result[i] = -1.0;
            }
        }
        
        return result;
    }
    
    private Map<String, Map<String, Double>> computeDistances(String[][] equations, double[] values) {
        Map<String, Map<String, Double>> eqMap = new HashMap<>();
        Map<String, Map<String, Double>> completeMap = new HashMap<>();
        for (int i = 0; i < equations.length; ++i) {
            addVal(eqMap, equations[i][0], equations[i][1], values[i]);
            addVal(completeMap, equations[i][0], equations[i][1], values[i]);
        }
        
        Set<String> visited = new HashSet<>();
        for (String start : eqMap.keySet()) {
            visited.add(start);
            computeDistances(eqMap, start, start, 1.0, visited, completeMap);
            visited.clear();
        }
        return completeMap;
    }
    
    private void computeDistances(Map<String, Map<String, Double>> eqMap, String start, String current, Double prev,
                                  Set<String> visited, Map<String, Map<String, Double>> completeMap) {
        addVal(completeMap, start, current, prev);
        for (Map.Entry<String, Double> nbr : eqMap.get(current).entrySet()) {
            if (visited.add(nbr.getKey())) {
                computeDistances(eqMap, start, nbr.getKey(), prev * nbr.getValue(), visited, completeMap);
            }
        }
    }
    
    private void addVal(Map<String, Map<String, Double>> eqMap, String left, String right, Double val) {
        if (!eqMap.containsKey(left)) {
            eqMap.put(left, new HashMap<>());
        }
        if (!eqMap.containsKey(right)) {
            eqMap.put(right, new HashMap<>());
        }
        
        eqMap.get(left).put(right, val);
        eqMap.get(right).put(left, 1.0 / val);
    }
}
