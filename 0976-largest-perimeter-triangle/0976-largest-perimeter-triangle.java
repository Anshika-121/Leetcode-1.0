class Solution {
    public int largestPerimeter(int[] nums) {
   Arrays.sort(nums);
   for(int i=0 ; i<nums.length/2;i++){
    int temp = nums[i];
    nums[i] = nums[nums.length -1-i];
    nums[nums.length -1-i]= temp;

   }
   for(int i=0;i<nums.length-2;i++){
    int a = nums[i];
    int b = nums[i+1];
    int c= nums[i+2];
    if(a< b+c){
        return a+b+c;
    }
    
   }
   return 0;

    }
}