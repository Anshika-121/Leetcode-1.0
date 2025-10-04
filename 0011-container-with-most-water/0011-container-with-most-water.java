class Solution {
    public int maxArea(int[] height) {
        int left =0 , right =height.length-1 , maxAreafound =0;
        while(left< right){
            int width = right -left;
            int minHeight = Math.min(height[left] , height[right]);
            int area = width * minHeight;
            maxAreafound = Math.max(maxAreafound , area);
            if(height[left]< height[right]){
                left++;
            }else{
                right--;
            }

        }
        return maxAreafound;
    }
}