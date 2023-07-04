class Solution {

    public void sortColors(int[] nums) {
        // int c0=0;
        // int c1=0;
        // int c2=0;
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i]==0){
        //         c0++;
        //     }else if(nums[i]==1){
        //         c1++;
        //     }else{
        //         c2++;
        //     }
        // }
        // for(int i=0;i<c0;i++){
        //     nums[i]=0;
        // }

        // for(int i=c0;i<c0+c1;i++){
        //     nums[i]=1;
        // }

        // for(int i=c0+c1;i<c0+c1+c2;i++){
        //     nums[i]=2;
        // }

        //Best Approach
        //Dutch National Flag Algorithm
        //3 Pointer Approach
        int n=nums.length;
        int low=0,mid=0,high=n-1;

        while(mid<=high){
            if(nums[mid]==0){
                //swap a[low],a[mid] and low++ and mid++
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            }else if(nums[mid]==1){
                mid++;
            }else if(nums[mid]==2){
                //swap a[mid],a[high] and high--
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }

    }
}