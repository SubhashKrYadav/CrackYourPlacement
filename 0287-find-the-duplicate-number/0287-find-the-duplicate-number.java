class Solution {
    public int findDuplicate(int[] nums) {
        // Arrays.sort(nums);
        // for(int i=0;i<nums.length-1;i++){
        //     if(nums[i]==nums[i+1]){
        //         return nums[i];
        //     }
        // }
        // return -1;


        // //Best Approach
        // //Using Binary Search
        // int low = 1,high = nums.length;
        // int ans  = -1;
        // while(low<=high){
        //     int curr = (low+high)/2;

        //     int count=0;
        //     for(int x:nums){
        //         if(x<=curr){
        //             count++;
        //         }
        //     }

        //     if(count>curr){
        //         ans = curr;
        //         high = curr-1;
        //     }else{
        //         low=curr+1;
        //     }
        // }

        // return ans;

        //3rd Approach using LinkedList Cycle Detection method
        // fast and slow appraoch

        int slow = nums[0];
        int fast = nums[0];

        do{
            slow= nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);

        fast = nums[0];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}