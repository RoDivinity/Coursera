
/**
 * You are given a sorted (from smallest to largest) array A of n distinct integers 
 * which can be positive, negative, or zero. You want to decide whether or not
 * there is an index i such that A[i] = i. Design the fastest algorithm that you can for solving this problem.
 */
package coursera;

/**
 *
 * @author Vodka
 */
public class Week1Prob3 {
    
    public static boolean b_search (int lower, int upper, int[] data) {
        int mid = (int) (lower + upper) / 2;
        if (mid == upper || mid == lower)
            return false;
        if (data[mid] == mid)
            return true;
        if (data[mid] < mid)
            return b_search (mid , upper , data);
        else 
            return b_search (lower , mid, data);
    }
  /*  
    public static void main (String args[])
    {
        int[] data = { -5, -3 , -2 , 3 ,4 ,7 ,8, 9};
        System.out.println (b_search ( 0 , data.length , data));
    }*/
}
