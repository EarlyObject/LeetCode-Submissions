public class Solution {
    public int countNegatives(int[][] grid) {
        int sum;

        sum = 0;
        for(int[] arr : grid) {
            for (int i : arr)
            {
                if (i < 0){
                    sum++;
                }
            }
        }
        return sum;
    }
}
