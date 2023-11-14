class Solution {
    public int[] solution(int brown, int yellow) { // col이 가로길이로 더 크다.
        for(int row=1; row*row<=yellow; row++) {
            if(yellow % row == 0) {
                int col = yellow / row;
                int temp = (row + col + 4) * 2 - 4;
                if(temp == brown) {
                    return new int[]{col + 2, row + 2};
                }
            }
        }
        return new int[]{-1, -1};
    }
}