// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver_class
{
    public static void main(String args[])
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int grid[][] = new int[9][9];
            for(int i = 0; i < 9; i++)
            {
                for(int j = 0; j < 9; j++)
                grid[i][j] = sc.nextInt();
            }
            
            if(new Sudoku().SolveSudoku(grid) == true)
                new Sudoku().printGrid(grid);
            else
                System.out.print("NO solution exists");
            System.out.println();
            
        }
    }
}



// } Driver Code Ends
//User function Template for Java

class Sudoku
{
    static boolean SolveSudoku(int grid[][])
    {   int len =  grid.length;
        int r=-1, c=-1; 
        boolean empty = true;
        for(int i=0;i<len;i++) {
            for(int j=0;j<len;j++) {
                if(grid[i][j] == 0) {
                    r=i;
                    c=j;
                    empty = false;
                    break;
                }
            }
            if(empty) {
                break;
            }
        }
        if(empty) {
            return true;
        }
        for(int t=1;t<=9;t++) {
            if(safeValue(grid, r, c, t)) {
                grid[r][c] = t;
                if(SolveSudoku(grid)) {
                    return true;
                }else {
                    grid[r][c]=0;
                }
            }
        }
        return false;
    }
    
    static boolean safeValue(int grid[][],int r,int c,int n) {
        for(int k=0;k<9;k++) {
            if(k != r && grid[k][c] == n) {
                return false;
            }
        }
        for(int k=0;k<9;k++) {
            if(k != c && grid[r][k] == n) {
                return false;
            }
        }
        int row = r/3;
        int col = c/3;
        for(int l=3*row;l<3*row+3;l++) {
            for(int m=3*col;m<3*col+3;m++) {
                if(l != row && m != col && grid[l][m] == n) {
                    return false;
                }
            }
        }
        return true;
    }
    
    static void printGrid (int grid[][])
    {
       int len =  grid.length;
       for(int i=0;i<len;i++) {
            for(int j=0;j<len;j++) {
                System.out.print(grid[i][j] + " ");
            }
       }
    }
}

