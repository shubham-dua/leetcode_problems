// LEETCODE 69 Rotate 2D array by 90 degrees
// The solution goes around thew approach of first exchanging rows and then exchanging elements diagonally

class Solution {
    public void rotate(int[][] arr) 
    {
        int l = arr[0].length;
        if (l == 0)
            return;
        
        int k = l-1;
        // exchange rows in the first iteration
        // k is initialised since we only want to go until the half length
        for(int i = 0; i < l/2; i++)
        {
            for(int j = 0; j < l; j++)
            {
                // swap elements
                int temp = arr[i][j];
                arr[i][j] = arr[k][j];
                arr[k][j] = temp;
            }
            k--;
        }
        
        // exchange elements diagonally
        for(int i = 0; i < l; i++)
        {
            for(int j = l-1; j >= i; j--)
            {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        return;
    }
}
