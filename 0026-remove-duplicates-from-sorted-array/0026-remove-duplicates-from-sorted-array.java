class Solution {
    public int removeDuplicates(int[] nums) {
    //    int i=0,j=1;
    //    while(i<nums.length && j<nums.length){
    //        while(j<nums.length && nums[i]==nums[j]){
    //            j++;
    //        }
    //        if(i<nums.length && j<nums.length && nums[i]!=nums[j]){
    //            i++;
    //            nums[i]=nums[j];
              
    //        }else{
    //             j++;
    //        }
           
    //    }
    //    return i+1;


    //   //2nd Approach
    //   int index=1;
    //   for(int j=1;j<nums.length;j++){
    //       if(nums[j-1]!=nums[j]){
    //           nums[index]=nums[j];
    //           index++;
    //       }
    //   }
    //   return index;

      //3rd Approach - Striver
      //2nd Approach
      if(nums.length==0){
          return 0;
      }
      int i=0; // till index i all elements are unique
      for(int j=1;j<nums.length;j++){
          if(nums[j]!=nums[i]){
              i++;
              nums[i] = nums[j];
          }
      }
      return i+1;
    }
}