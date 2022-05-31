import java.util.Scanner;

public class nqueens_SharnamAgrawal{
    public static boolean isSafe(char a[][], int column ,int row){
        for(int i = column; i>=0; i-- ){
            if(a[row][i] == 'Q'){
                return false;
            }
        }
        for(int i = column; i<a.length; i++ ){
            if(a[row][i] == 'Q'){
                return false;
            }
        }
        for(int i = row; i>=0; i-- ){
            if(a[i][column] == 'Q'){
                return false;
            }
        }
        for(int i = row; i<a.length; i++ ){
            if(a[i][column] == 'Q'){
                return false;
            }
        }
        for(int i = column-1, j = row-1; i>=0 && j>=0; i--,j-- ){
            if(a[j][i] == 'Q'){
                return false;
            }
        }
        for(int i = column+1, j = row+1; i<a.length && j<a.length; i++,j++ ){
            if(a[j][i] == 'Q'){
                return false;
            }
        }
        for(int i = column+1, j = row-1; i<a.length && j>=0; i++,j-- ){
            if(a[j][i] == 'Q'){
                return false;
            }}
        
        for(int i = column-1, j = row+1; i>=0 && j<a.length; i--,j++ ){
            if(a[j][i] == 'Q'){
                return false;
            }
        }
        return true;
    }
    public static void helper(char a[][], int column, char ans[][]){
        if(column == a.length){
            for(int i =0; i<a.length; i++){
                for(int j = 0; j<a.length; j++){
                    ans[i][j] = a[i][j];
                }
            }
            return;
        }

        
            for(int j = 0; j<a.length; j++){
                boolean d = isSafe(a,column,j);
            if(d){
                a[j][column] = 'Q';
                helper(a,column + 1,ans);
                a[j][column] = '*';
                
            }
        }
    }
    public static void main(String[] args) {
        Scanner sh = new Scanner(System.in);
        //Step 1:- Taking the number of test cases and size of the Chessboard as input from the user;
        int t = sh.nextInt();
        int n = sh.nextInt();
        //'Q' == Queen
       //'*' == empty
      //' ' == empty
       //Step 2:- We will create a 2d character array that will represtn our chessboard.
      //Step 3 :- Aim is to check whether placing a queen at a certain position on th =e chess board is safe or not. For that we will traverse column wise and check whether for an ith cloumn the corresponding jth row is safe or not.
      //Step 4 :- Creating helper function to check the safety of a queen - The helper function will check in all six directions along which the queen can move. If it is safe then will place character 'Q' at the position otherwise we will backtrack.
      while(t>0){
      char arr[][] = new char[n][n];
      char ans[][] = new char[n][n];
      helper(arr,0,ans);

      for(int i =0; i<n; i++){
          for(int j = 0; j<n; j++){
              if(ans[i][j] == 'Q'){
              System.out.print(ans[i][j]);}
              else{
                System.out.print("*");   
              }
          }
          System.out.println();
      }



      t--;}  
    }
}