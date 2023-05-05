
//package csc311phase2;
import java.util.*;

public class CSC311phase2 {

   static Scanner input = new Scanner (System.in);
   static final int BIG = Integer.MAX_VALUE;
   static String[][] arrangement;

   public static void main(String[] args) {
      
      System.out.println("Enter the width of the line");
      int M = input.nextInt();
      System.out.println("Enter the number of words: ");
      int n = input.nextInt();
      //array to save the lengths of each word 
      int lengths[] = new int [n];
      //array to save the words to calculate it in the loop     
      String[] words=new String[n];
      arrangement =new String[n][];
      for (int i = 0; i < n; i++) 
      {
         System.out.println("Enter word #" + (i+1));
         words[i]=input.next();
         lengths[i] = words[i].length();
      }   
      
      //2D array to save number of extra spaces if words from i to j are put in a single line
      int es[][] = new int[n+1][n+1]; 
      
      //2D array to save the cost of a line which has words from i to j
      int lineCost[][]= new int[n+1][n+1];
      
      //array to save the total cost of optimal arrangement of words from 1 to i
      int Ocost[] = new int[n+1];
   
      //array used to print the solution
      int P[] = new int[n+1];
      
      //calculate extra spaces in a single line.
      for (int i = 1; i <= n; i++)
      {
         es[i][i] = M - lengths[i-1];
         
         for (int j = i+1; j <= n; j++)
            es[i][j] = es[i][j-1] - lengths[j-1] - 1;
      }
      
      //calculate line cost 
      for (int i = 1; i <= n; i++)
      {
         for (int j = i; j <= n; j++)
         {
            if (es[i][j] < 0)
               lineCost[i][j] = BIG;
            else if (j == n && es[i][j] >= 0)
               lineCost[i][j] = 0;
            else
               lineCost[i][j] = es[i][j]*es[i][j];
         }
      }
      
      //calculate minimum cost 
      Ocost[0] = 0;
      for (int j = 1; j <= n; j++)
      {
         Ocost[j] = BIG;
         for (int i = 1; i <= j; i++)
         {
            if (Ocost[i-1] != BIG && lineCost[i][j] != BIG &&
              (Ocost[i-1] + lineCost[i][j] < Ocost[j]))
            {
               Ocost[j] = Ocost[i-1] + lineCost[i][j];
               P[j] = i;
            }
         }
      }
      
    
      
      System.out.println("Optimal design for writing the pargraph is :");
      printer(P, n);
      printerTable(P,n,words,M);
      
   }
   

   
   
   public static int printer (int s[], int n)
   {
      
   
      int l;
      if (s[n] == 1)
         l = 1;
      else
         l = printer (s, s[n]-1) + 1;
      System.out.println("Line "  + l + " can hold the words from word" + " " + s[n] + " " + "to word" + " " + n);
      
      return l;
   }
   public static int printerTable (int s[], int n,String[]word,int width)
   {
      
   
      int l;
      if (s[n] == 1)
         l = 1;
      else
         l = printerTable (s, s[n]-1,word,width) + 1;
      
      String[] words = new String[n-s[n]+1];
      int j=0;
      for(int i=s[n]-1;i<n;i++){
         words[j++]=word[i];
      }
      int len =words.length;
      for(int p=0;p<width;p++){
         if(len>0){
                   
            for(int k=0;k<words.length;k++){
               for(int e=0;e<words[k].length();e++)
                  System.out.print("| "  + words[k].charAt(e) + " |" );
               if(k != words.length-1 )
                  System.out.print("|   |" );
               if(words.length == 1)
                  System.out.print("|   |" );
               len--;
               p+=words[k].length();
               
              
            }
         }
         else{
            System.out.print("|   |" );
         }
         
      }
      
      System.out.println();
      return l;
   }
}