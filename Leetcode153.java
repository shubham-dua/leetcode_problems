// rotated sorted array
// no duplicates
class Solution {
    public int findMin(int[] nums){
        if(nums.length == 1)
            return nums[0];
        return customBinarySearch(0, nums.length-1, nums, nums[0]);
    }
    public int customBinarySearch(int start, int end, int[] arr, int minimum){
        if(start<=end){
            int mid = start + ((end-start)/2);
            if(arr[mid]<minimum)
                minimum = arr[mid];
            if(arr[end] < arr[mid])
                return customBinarySearch(mid+1, end, arr, minimum);
            return customBinarySearch(start, mid-1, arr, minimum);
        }
        return minimum;
    }
}
