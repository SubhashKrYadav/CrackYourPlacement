class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        //brute Approach

        //  List<Integer> res=new ArrayList<>();
        // Set<Integer> set1=new HashSet<>();
        // for(int i=0;i<nums.length;i++){
        //     if(set1.contains(nums[i])){
        //         res.add(nums[i]);
        //     }else{
        //         set1.add(nums[i]);
        //     }
        // }
        // return res;

        //Optimized Approach
        List<Integer> res=new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            int index = Math.abs(nums[i]) - 1; 
            if(nums[index] < 0) {// it is already visited => it is an duplicate num
                res.add(Math.abs(nums[i]));
            }
             nums[index] = -nums[index];
            
        }

        return res;
    }
}