// Hamming distance 1
class Solution {
    public int hammingDistance(int x, int y) 
    {
        
        String strX = Integer.toBinaryString(x);
        String strY = Integer.toBinaryString(y);
        
        //System.out.println(strX);
        //System.out.println(strY);
        
        int diff = 0;
        
        int startX = strX.length()-1;
        int startY = strY.length()-1;
        
        while(startX >= 0 && startY >= 0)
        {
            if(strX.charAt(startX) != strY.charAt(startY))
                diff++;
            startX--;
            startY--;
        }
        while(startX >= 0)
        {
            if(strX.charAt(startX)== '1')
                diff++;
            startX--;
        }
        while(startY >= 0)
        {
            if(strY.charAt(startY)== '1')
                diff++;
            startY--;
        }
        return diff;
    }
}
