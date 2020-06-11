class Solution {
    public void sortColors(int[] nums) 
    {
        int i = 0;
        int zero = 0, two = nums.length-1;
        while(two > zero && i < nums.length)
        {
            //if ccrent number is zero exchange it with "zero" index and increment current and zero indexes
            if(nums[i] == 0)
            {
                System.out.println("0Exchange " + i + " with " + zero);
                int temp = nums[zero];
                nums[zero] = nums[i];
                nums[i] = temp;
                zero++;
                i++;
            }
            // if current is 2 exchange it with "two" index and recheck the exchanged element 
            else if(nums[i] == 2)
            {
                // if two < zero that means we have already sorted our array
                if(two <= i)
                    break;
                int temp = nums[two];
                nums[two] = nums[i];
                nums[i] = temp;
                two--;
            }
            else
            {
                i++;
            }
        }
    }
}
