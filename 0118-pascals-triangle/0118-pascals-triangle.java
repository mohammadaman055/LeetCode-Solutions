import java.math.BigInteger;
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                temp.add(ncr(i, j));
            }
            result.add(temp);
        }
        return result;
    }

    private int ncr(int n, int r) {
        // Compute nCr using BigInteger
        BigInteger num = factorial(n);
        BigInteger denom = factorial(r).multiply(factorial(n - r));
        return num.divide(denom).intValue();
    }

    private BigInteger factorial(int n) {
        BigInteger f = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            f = f.multiply(BigInteger.valueOf(i));
        }
        return f;
    }
}