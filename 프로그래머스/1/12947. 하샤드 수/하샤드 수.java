class Solution {
    public boolean solution(int x) {
        String str = String.valueOf(x);
        int sum = 0;
        for(int i=0; i<str.length(); i++) {
            sum += Character.getNumericValue(str.charAt(i));
        }
        
        return x % sum == 0;
    }
}