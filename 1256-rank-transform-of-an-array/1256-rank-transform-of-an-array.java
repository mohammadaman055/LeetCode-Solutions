class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int [] newarr = new int[arr.length];
        int i=0;

        for(int n : arr){
            newarr[i]=n;
            i++;
        }

        Arrays.sort(newarr);

        i=1;

        Map<Integer, Integer> map = new HashMap<>();

        for(int n : newarr){
            if(map.get(n)==null){
                map.put(n,i);
                i++;
            }
            // map.put(n, map.getOrDefault(n, i) + 0);
            // i++;
        }

        i=0;
        for(int n:arr){
            newarr[i]=map.get(n);
            i++;
        }

        return newarr;
    }
}