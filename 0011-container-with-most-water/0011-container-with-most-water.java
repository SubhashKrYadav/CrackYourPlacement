class Solution {
    public int maxArea(int[] height) {
        int maxWater = 0;
        
        int left=0,right=height.length-1;
        int leftHt = height[left];
        int rightHt = height[right];
        int water = 0;
        while(left<right){
            if(leftHt<rightHt){
                 water = leftHt*(right-left);
                left++;
                leftHt = height[left];
            }else{
                 water = rightHt*(right-left);
                right--;
                rightHt = height[right];
            }
            maxWater = Math.max(maxWater,water);
        }
        return maxWater;
    }
}