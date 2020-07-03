class Solution 
{
    public int smallestRangeI(int[] A, int K) 
    {
        int minimum = A[0];
        int maximum = A[0];
        for(int i : A){
            if(i < minimum)
                minimum = i;
            if(i > maximum)
                maximum = i;
        }
        int temp = maximum-minimum-2*K;
        return temp <= 0 ? 0 : temp;
    }
}
