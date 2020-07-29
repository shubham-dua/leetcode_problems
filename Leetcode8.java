// String to number
// ATOI
class Solution {
    public int myAtoi(String str) {
        char[] expected_characters = {'1','2','3','4','5','6','7','8','9','0'};
        int result = 0;
        boolean negative_flag = false;
        int i = 0;
        // ignore all white spaces first and check for negative sign
        while(i < str.length()){
            if(str.charAt(i) == ' ')
                i++;
            else if(str.charAt(i) == '-' || str.charAt(i) == '+'){
                if(str.charAt(i) == '-')
                    negative_flag = true;
                i++;
                break;
            }
            else if(isExpected(str.charAt(i), expected_characters))
                break;
            else
                return 0;
        }
        // add digits until any other character/end of string is reached
        while(i < str.length()){
            if(isExpected(str.charAt(i), expected_characters)){
                int n = Character.getNumericValue(str.charAt(i));
                if(negative_flag)
                    result = subtract_from_result(result, n);
                else
                    result = add_to_result(result, n);
                
                if(result == Integer.MAX_VALUE || result == Integer.MIN_VALUE)
                    return result;
                
                i++;
            }
            else
                break;
        }
        return result;
    }
    // add digit to number
    public int add_to_result(int result, int n){
        if((int)Integer.MAX_VALUE/10 >= result)
            result = result * 10;
        else
            return Integer.MAX_VALUE;
        if(Integer.MAX_VALUE - n <= result)
            return Integer.MAX_VALUE;
        return result+n;
    }
    
    //subtract digit from number
    public int subtract_from_result(int result, int n){
        if((int)Integer.MIN_VALUE/10 <= result)
            result = result * 10;
        else
            return Integer.MIN_VALUE;
        if(Integer.MIN_VALUE+n >= result)
            return Integer.MIN_VALUE;
        return result-n;
    }
    
    // return true if character is a digit
    boolean isExpected(char ch, char[] arr){
        for(char ch1: arr){
            if(ch1 == ch)
                return true;
        }
        return false;
    }
}
