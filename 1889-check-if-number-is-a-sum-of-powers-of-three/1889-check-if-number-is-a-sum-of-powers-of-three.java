class Solution {
    // Map<List<Double>, Boolean> map = new HashMap<>();
    public boolean helper(double n, double exp) {
        if (n == 0) return true;
        if (n < 0 || n < Math.pow(3, exp)) return false;
        // List<Double> lt = new ArrayList<>();
        // lt.add(n); lt.add(exp);
        // if (map.containsKey(lt)) return map.get(lt);
        boolean ans = helper(n - Math.pow(3, exp), exp + 1) || helper(n, exp + 1);
        // map.put(lt, ans);
        return ans;
    }
    public boolean checkPowersOfThree(int n) {
        return helper((double) n, 0);
    }
}