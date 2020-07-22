class Solution {
    public boolean exist(char[][] arr, String word) 
    {
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = 0; j < arr[0].length; j++)
            {
                if(arr[i][j] == word.charAt(0))
                {
                    if(matchWord(word, arr, 0, i, j))
                        return true;
                }
            }
        }
        return false;
    }
    
    public boolean matchWord(String s, char[][] arr, int idx, int i, int j)
    {
        //System.out.print(Arrays.deepToString(arr));
        if(idx >= s.length())
            return true;
        if(i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || s.charAt(idx) != arr[i][j])
            return false;
            //System.out.println("Character found at: " + i + " " + j);
        char temp = arr[i][j];
        arr[i][j] = '*';
        boolean flag = (matchWord(s, arr, idx+1, i-1, j) || matchWord(s, arr, idx+1, i+1, j) || matchWord(s, arr, idx+1, i, j-1) || matchWord(s, arr, idx+1, i, j+1));
        arr[i][j] = temp;
        return flag;
    }
    
/**    public char[][] getCopy(char[][] arr)
    {
        char[][] arr1 = new char[arr.length][arr[0].length];
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = 0; j < arr[0].length; j++)
            {
                arr1[i][j] = arr[i][j];
            }
        }
        return arr1;
    }
*/
}
