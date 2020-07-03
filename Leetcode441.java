class Solution 
{
    public int arrangeCoins(int n) 
    {
        if(n <= 1)
            return n;
        long start = 1;
        long end = n;
        long curr= (start+end)/2;;
        while(start < end)
        {
            long s = (curr*(curr+1))/2;
            if(s == n)
                return (int)curr;
            else if(s < n)
                start = curr+1;
            else
                end = curr-1;
            curr = (start+end)/2;
        }
        if((curr*(curr+1))/2 <= n)
            return (int)curr;
        return (int)curr-1;
    }
}
