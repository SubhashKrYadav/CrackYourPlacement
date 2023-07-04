//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for(int i = 0;i<n;i++)
                {
                    int x = sc.nextInt();
                    arr.add(x);
                }
            int m = sc.nextInt();
            
            Solution ob = new Solution();
            
    		System.out.println(ob.findMinDiff(arr,n,m));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        //sort the ArrayList at first
        Collections.sort(a);
        long minDiff = Integer.MAX_VALUE;
        
        for(int i=0;i<=n-m;i++){
            long diff = a.get(i+m-1) - a.get(i);  //diff of min and max of subarray of size m
            minDiff =  Math.min(minDiff , diff);  //update minDiff value
        }
        
        return minDiff;
    }
}