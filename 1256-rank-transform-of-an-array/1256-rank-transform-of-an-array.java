class Solution {
    public int[] arrayRankTransform(int[] arr) {
         // Create a copy of the original array to sort
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);

        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;

        // Assign ranks to unique values
        for (int n : sortedArr) {
            if (!rankMap.containsKey(n)) {
                rankMap.put(n, rank++);
            }
        }

        // Build the result array using the rank map
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = rankMap.get(arr[i]);
        }

        return result;
    }
}