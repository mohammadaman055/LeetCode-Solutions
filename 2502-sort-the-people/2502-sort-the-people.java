class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
         // Create a list of pairs (height, name)
        List<Pair<Integer, String>> people = new ArrayList<>();
        
        // Populate the list of pairs
        for (int i = 0; i < names.length; i++) {
            people.add(new Pair<>(heights[i], names[i]));
        }

        Collections.sort(people, (a, b) -> {
            if (a.getKey().equals(b.getKey())) {
                return a.getValue().compareTo(b.getValue()); // sort by lexicographically
            } else {
                return b.getKey().compareTo(a.getKey()); // sort by height descending
            }
        });
        
        // Extract sorted names into result list
        List<String> result = new ArrayList<>();
        for (Pair<Integer, String> person : people) {
            result.add(person.getValue());
        }
        
        return result.toArray(new String[result.size()]);
    }
}