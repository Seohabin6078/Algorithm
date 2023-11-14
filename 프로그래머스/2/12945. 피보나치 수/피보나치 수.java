class Solution {
    private int[] memo = new int[100001];
    public int solution(int n) {
        if(n < 2) {
            return n;
        }
        
        if(memo[n] != 0) {
            return memo[n];
        }
        
        return memo[n] = (solution(n-1) + solution(n-2)) % 1234567;
    }
}