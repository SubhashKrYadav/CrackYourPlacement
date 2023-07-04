class Solution {
    public void moveZeroes(int[] nums) {
        // int i=0,j=0;
        // int count=0;
        // while(i<nums.length){
        //     if(nums[i]==0){
        //         i++;
        //         count++;
        //     }else{
        //         if(j<=i){
        //             nums[j]=nums[i];
        //             j++;
                   
        //         }
        //          i++;
        //     }
        // }
        // while(count>0 && j<nums.length){
        //     nums[j++]=0;
        //     count--;
        // }

        //2nd Approach

        // int zIdx = 0;      //  index Of First Zero from Left
        // int nzIdx = -1;    //  index Of First Non-Zero from Left

       
        // while(nzIdx<nums.length){
        //     while(zIdx<nums.length && nums[zIdx] != 0){
        //         zIdx++;
        //     }
        //     // now zIdx is pointing leftmost zero position
        //     nzIdx = (nzIdx == -1) ? zIdx + 1 : nzIdx;
        //     while(nzIdx<nums.length && nums[nzIdx] == 0){
        //         nzIdx++;
        //     } 
        //     // now nzIdx is pointing rightmost non-zero position after that leftmost zero position
        //     // now swap both
        //     if(nzIdx<nums.length && zIdx<nums.length){
        //         nums[zIdx] = nums[nzIdx];
        //         zIdx++;
        //         nums[nzIdx] = 0;
        //         nzIdx++;
        //     }
        // }

        //3rd Appraoch
        //All elements before the slow pointer (lastNonZeroFoundAt) are non-zeroes.
        //All elements between the current and slow pointer are zeroes.

        int lastNonZeroFoundAt = 0 ;
        for(int curr = 0;curr<nums.length;curr++ ){
            if(nums[curr] != 0){  
                 // If the current element is not 0, then we need to
                // append it just in front of last non 0 element we found.
                int temp = nums[lastNonZeroFoundAt];
                nums[lastNonZeroFoundAt++] = nums[curr];
                nums[curr] = temp++;
            }
        }
    }
}