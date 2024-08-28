class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String, Integer> wordCount = new HashMap<>();
        
        for (String word : arr) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        int count = 0;
        for (String word : arr) {
            if (wordCount.get(word) == 1) {
                count++;
                if (count == k) {
                    return word;
                }
            }
        }

        return "";
    }
}