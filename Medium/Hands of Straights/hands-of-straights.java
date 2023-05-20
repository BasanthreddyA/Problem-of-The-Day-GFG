class Solution {
    static boolean isStraightHand(int N, int groupSize, int hand[]) {
        // If we can't divide into groups, return false
        if (hand.length % groupSize != 0) {
            return false;
        }
        
        // Implement a HashMap to keep track of element counts
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int value : hand) {
            countMap.put(value, countMap.getOrDefault(value, 0) + 1);
        }
        
        // Process the hand
        while (!countMap.isEmpty()) {
            int smallest = Collections.min(countMap.keySet()); // Get the smallest element
            
            // Remove (groupSize - 1) consecutive values
            for (int i = 0; i < groupSize; i++) {
                int current = smallest + i;
                
                // If the current element is not present or its count is zero, return false
                if (!countMap.containsKey(current) || countMap.get(current) == 0) {
                    return false;
                }
                
                // Decrement the count of the current element
                countMap.put(current, countMap.get(current) - 1);
                
                // Remove the entry if the count becomes zero
                if (countMap.get(current) == 0) {
                    countMap.remove(current);
                }
            }
        }
        
        return true;
    }
}
