class Solution {
    public int[] frequencySort(int[] nums) {
        // Create a HashMap to store the count of each element
        Map<Integer, Integer> frq = new HashMap<>();

        // Count the occurrences of each number
        for (int n : nums) {
            frq.put(n, frq.getOrDefault(n, 0) + 1);
        }

        // Create a list from the entry set of the map
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(frq.entrySet());

        // Sort the list by values (frequencies) in increasing order
        Collections.sort(entryList, (a, b) -> {
            int cmp = a.getValue().compareTo(b.getValue());
            if (cmp != 0) {
                return cmp;
            } else {
                return b.getKey().compareTo(a.getKey());
            }
        });

        // Convert the sorted list back to an array
        int[] result = new int[nums.length];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : entryList) {
            int value = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                result[index++] = value;
            }
        }

        return result;
    }
}