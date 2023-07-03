class Solution {


//     public static void markRow(int[][] matrix,int row){
       
//          //make row zeroes
//           for(int j=0;j<matrix[0].length;j++){
//               matrix[row][j]=-1;
//           }
          
//     }
//     public static void markCol(int[][] matrix,int col){
       
//          //make col zeroes
//          for(int i=0;i<matrix.length;i++){
//              matrix[i][col]=-1;
//          }
//     }

    public void setZeroes(int[][] matrix) {
        //1st Appraoch - Brute Approach

//         for(int i=0;i<matrix.length;i++){
//             for(int j=0;j<matrix[0].length;j++){
//                 if(matrix[i][j]==0){
//                    markRow(matrix,i);
//                    markCol(matrix,j);
//                 }
//             }
//         }
        
//         for(int i=0;i<matrix.length;i++){
//             for(int j=0;j<matrix[0].length;j++){
//                 if(matrix[i][j]==-1){
//                    matrix[i][j]=0;
//                 }
//             }
//         }
        
        
//         //2nd Approach - Better
//         int m = matrix.length;
//         int n = matrix[0].length;
        
//         int[] col = new int[n];
//         int[] row = new int[m];
        
//         for(int i=0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 if(matrix[i][j]==0){
//                    col[j] = 1;
//                     row[i] = 1;
//                 }
//             }
//         }
        
//         for(int i=0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 if(row[i]==1 || col[j]==1){
//                   matrix[i][j]=0;
//                 }
//             }
//         }
        
        


        //3rd Approach - Optimal Approach
        int m = matrix.length;
        int n = matrix[0].length;
        //int col[n] --> matrix[0][...]
        //int row[m] --> matrix[...][0]

        int col0 = 1;
        for(int i=0;i<m;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    //mark ith row
                    matrix[i][0]=0;
                    //mark jth col
                    if(j!=0){
                        matrix[0][j]=0;
                    }else{
                        col0=0;
                    }
                    
                }
            }
        }


        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j] != 0){
                  //check for col and row
                    if(matrix[0][j]==0 || matrix[i][0]==0){
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        //check first row need to be set zeros
        if(matrix[0][0]==0){
            for(int j=0;j<n;j++){
                matrix[0][j] = 0;
            }
        }

        //check first column need to be set zeros
        if(col0==0){
            for(int i=0;i<m;i++){
                matrix[i][0] = 0;
            }
        }
    }
}