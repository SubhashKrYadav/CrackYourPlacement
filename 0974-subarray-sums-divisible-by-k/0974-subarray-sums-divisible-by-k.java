class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        //Brute Approach -> Time Limit Exceeded
        // int n = nums.length;
        // int[] prefixSum = new int[n];
        // prefixSum[0] = nums[0];
        // for(int i=1;i<n;i++){
        //     prefixSum[i] = nums[i] + prefixSum[i-1];
        // }

        // // map<(startIndex,endIdex),sumOfSubarray> 
        // //HashMap<Pair<Integer,Integer> , Integer> map = new HashMap<>();

        // int ans = 0;
        // for(int start=0;start<n;start++){
        //     for(int end=start;end<n;end++){
        //         int subarraySum = (start==0) ? prefixSum[end] : prefixSum[end] - prefixSum[start-1];
        //         if(subarraySum % k == 0){
        //             ans++;
        //         }
        //     }
        // }

        // return ans;

        //2nd Approach -> Using Hashing
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int ans = 0;

        for(int j=0;j<nums.length;j++){
            sum += nums[j];
            int rem = (sum%k) < 0 ? (sum%k) + k : sum%k;

            if(map.containsKey(rem)){
                ans += map.get(rem);
            }
            map.put(rem,map.getOrDefault(rem,0)+1);
        }

        return ans;
    }
}