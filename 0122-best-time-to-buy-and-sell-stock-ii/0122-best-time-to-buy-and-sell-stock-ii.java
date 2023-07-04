class Solution {
    // buy = 0 -> you cannot buy current stock -> prev stock has been bought
    // buy = 1 -> you can buy current stock
    //using recursion
    public int recursionProfit(int[] prices,int idx, int buy,int n){
        //base case
        if(idx == n){
            return 0;
        }

        int maxProfit;
        if(buy==1){
            //include-> if bought then profit
            int profit1 = -prices[idx] + recursionProfit(prices,idx+1,0,n);
            //exclude -> if not bought then profit
            int profit2 = 0 + recursionProfit(prices,idx+1,1,n);
            maxProfit = Math.max(profit1 , profit2);
        }else{
            //include-> if sold then profit
            int profit1 = prices[idx] + recursionProfit(prices,idx+1,1,n);
            //exclude -> if not sold then profit
            int profit2 = 0 + recursionProfit(prices,idx+1,0,n);
            maxProfit = Math.max(profit1 , profit2);
        }

        return maxProfit; 
    }

    //2nd Approach
    //Using Memoization
    public int memoizationProfit(int[] prices,int idx, int buy,int n , int[][] dp){
        //base case
        if(idx == n){
            return 0;
        }

        if(dp[idx][buy] != -1){ // it is already calculated
            return dp[idx][buy]; 
        }

        int maxProfit;
        if(buy==1){
            //include-> if bought then profit
            int profit1 = -prices[idx] + memoizationProfit(prices,idx+1,0,n,dp);
            //exclude -> if not bought then profit
            int profit2 = 0 + memoizationProfit(prices,idx+1,1,n,dp);
            maxProfit = Math.max(profit1 , profit2);
        }else{
            //include-> if sold then profit
            int profit1 = prices[idx] + memoizationProfit(prices,idx+1,1,n,dp);
            //exclude -> if not sold then profit
            int profit2 = 0 + memoizationProfit(prices,idx+1,0,n,dp);
            maxProfit = Math.max(profit1 , profit2);
        }
        dp[idx][buy] = maxProfit;
        return maxProfit; 
    }


    //3rd Approach
    //Using Tabulation
    public int tabulationProfit(int[] prices,int n ){
        int[][] dp = new int[n+1][2];
        //base case -> initialization
        dp[n][0] = dp[n][1] = 0;

        for(int i = n-1;i>=0;i--){
            for(int buy = 0;buy<=1;buy++){
                int maxProfit;
                if(buy==1){
                    //include-> if bought then profit
                    int profit1 = -prices[i] + dp[i+1][0];
                    //exclude -> if not bought then profit
                    int profit2 = 0 + dp[i+1][1];
                    maxProfit = Math.max(profit1 , profit2);
                }else{
                    //include-> if sold then profit
                    int profit1 = prices[i] + dp[i+1][1];
                    //exclude -> if not sold then profit
                    int profit2 = 0 + dp[i+1][0];
                    maxProfit = Math.max(profit1 , profit2);
                }
                dp[i][buy] = maxProfit;
                
            }
        }

        return dp[0][1]; 
        
    }



    public int maxProfit(int[] prices) {
        // return recursionProfit(prices,0,1,prices.length);
         // Time Limit Exceeded as time = (2^N)

         //Optimized Approach Using Memoization
         int n = prices.length;
         
        //  for(int i = 0;i<n;i++){
        //      dp[i][0] = -1;
        //      dp[i][1] = -1;
        //  }
        // return memoizationProfit(prices,0,1,n,dp);

        //Using Tabulation
        return tabulationProfit(prices,n);

    }
}