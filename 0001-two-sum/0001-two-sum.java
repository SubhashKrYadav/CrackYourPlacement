class Solution {
    public int[] twoSum(int[] nums, int target) {
       
        //BruteForce Approach
        //for(int i=0;i<nums.length;i++){
        //     for(int j=i+1;j<nums.length;j++){
        //         if(nums[i]+nums[j]==target){
        //              return new int[]{i,j};
        //         }
        //     }
        // }

        // return new int[]{};

        //Best Approach
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int cmpl=target-nums[i];
            if(map.containsKey(cmpl)){
                return new int[]{i,map.get(cmpl)};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}