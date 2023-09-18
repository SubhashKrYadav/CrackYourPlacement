//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class comp implements Comparator<ArrayList<String>> {
    // override the compare() method
    public int compare(ArrayList<String> a, ArrayList<String> b)
    {
        String x = "";
        String y = "";
        for(int i=0; i<a.size(); i++)
            x += a.get(i);
        for(int i=0; i<b.size(); i++)
            y += b.get(i);
        return x.compareTo(y);
    }
}

public class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            ArrayList<ArrayList<String>> ans = obj.findSequences(startWord, targetWord, wordList);
            if(ans.size()==0)
                System.out.println(-1);
            else
            {
                Collections.sort(ans, new comp());
                for(int i=0; i<ans.size(); i++)
                {
                    for(int j=0; j<ans.get(i).size(); j++)
                    {
                        System.out.print(ans.get(i).get(j) + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList)
    {
        ArrayList<ArrayList<String>> ans = new ArrayList<>();

        HashSet<String> set = new HashSet<>();
        for(String word:wordList){
            set.add(word);
        }

        Queue<ArrayList<String>> q = new LinkedList<>();
        
        ArrayList<String> strList = new ArrayList<>();
        strList.add(startWord);
        q.add(strList);

        while(!q.isEmpty()){
            int size = q.size();

            ArrayList<String> usedOnLevel = new ArrayList<>();

            for(int i=0;i<size;i++){
                ArrayList<String> currList = q.remove();
               
                String word = currList.get(currList.size()-1); //last word of currrent list

                if(word.equals(targetWord)){
                    if(ans.size()==0){
                        ans.add(currList);
                    }else if(ans.get(0).size()==currList.size()){
                        ans.add(currList);
                    }
                }
                
                StringBuilder currWord = new StringBuilder(word);

                for(int j=0;j<currWord.length();j++){
                    char original = currWord.charAt(j);
                    for(char ch='a';ch<='z';ch++){
                        // char[] replacedArr = word.toCharArray();
                        // replacedArr[j] = ch;
                        // String replacedStr = new String(replacedArr);
                        currWord.setCharAt(j, ch);
                        if(set.contains(currWord.toString())){
                            ArrayList<String> temp = new ArrayList<>(currList);
                            temp.add(currWord.toString());
                            usedOnLevel.add(currWord.toString());
                            q.add(temp);
                        }
                    }
                    currWord.setCharAt(j, original);
                }
            }
            
            //erase all string which is used in this level
            for(String usedStr : usedOnLevel){
                set.remove(usedStr);
            }
            
        }

        return ans;
    }
}