/* COMP 352 - Assignment 1
 * @author:  David Onwionoko 40167358
 * @version: 1.2
 * 
 * Oddonacci Class
 * This class is used to calculate the Oddonacci sequence of n size.
 * 
 * An Oddonacci sequence is a sequence of numbers where each number is the sum of the previous three numbers.
 * Ex: 1, 1, 1, 3, 5, 9, 17, 31, 51, 105, 193...
 * 
 * This class implements two recursive methods to calculate the Oddonacci sequence.
 */



import java.io.PrintWriter;
import java.io.IOException;

public class Oddonacci {
    
    /** 
     * @param i Counter used to terminate the recursion. Must not be set > 100.
     * @param n Indicates the position of the number in the Oddonacci sequence.
     * @param x The oldest number in the sequence calculation.
     * @param y The middle number in the sequence calculation.
     * @param z The newest number in the sequence calculation.
     * @return long The Oddonacci number at the position n.
     */
    
    //Implementation of Linear Oddonacci algorithm
    public static long LinOdd(int i, int n, long x, long y, long z){
        if (i < 1) return 0;
        else if (i < 4) return 1;
        if (n >= i) return z;
        else return LinOdd(i, n + 1, y, z, x + y + z);
    }

    
    /** 
     * @param i Counter used to terminate the recursion. Must not be set > 45. At 45, the program takes 15 minutes to run.
     * @return long The present Oddonacci number.
     */
    //Implementation of Exponential Oddonaci algorithm
    public static long TriOdd(int i){
        if(i==0){
            return 0;
        }
        if (i > 0 && i < 4){
            return 1;
        }
        return TriOdd(i-1) + TriOdd(i-2) + TriOdd(i-3);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        try {
            long[] triArr = new long[20];
            long[] linArr = new long[20];

            PrintWriter pw = new PrintWriter("OddoOut.txt");
            pw.println("David Onwionoko 40167358\n");

            pw.println("Trace of Linear Oddonacci output:");
            for (int i = 0; i < 20; i++) {
                long strtTime = System.nanoTime();
                long temp = LinOdd(5*(i+1), 3, 1, 1, 1);
                long endTime = System.nanoTime();
    			linArr[i] = endTime - strtTime;

                pw.println(String.format("%-50s %s", "Linear Oddonacci of "+ (5*(i+1)) + " is: " + temp, "("+ linArr[i] +"ns)"));
            }
            pw.println();

            pw.println("Trace of Exponential Oddonacci output:");
            for (int i = 0; i < 7; i++) {
                long strtTime = System.nanoTime();
                long temp = TriOdd(5*(i+1));
                long endTime = System.nanoTime();
                triArr[i] = endTime - strtTime;

                pw.println(String.format("%-50s %s", "Exponential Oddonaci of "+ (5*(i+1)) +" is: "+ temp, "("+ triArr[i] +"ns)"));
            }
            pw.println();

            pw.println("Table of exponential and linear call times (ns):");
                for (int i = 0; i < 7; i++) {
                    pw.println(String.format("%-4d %-20s %s", 5*(i+1), triArr[i], linArr[i]));
                }
            pw.close();

        } catch (IOException e) {
            System.out.println("An error has occured");
            e.printStackTrace();
        }
        System.out.println("Output file created successfully");
    }
}
