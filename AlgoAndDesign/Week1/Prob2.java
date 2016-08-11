/**
 * You are a given a unimodal array of n distinct elements, 
 * meaning that its entries are in increasing order up until its maximum element, 
 * after which its elements are in decreasing order. 
 * Give an algorithm to compute the maximum element that runs in O(log n) time.
 */

package coursera;

/**
 *
 * @author Vodka
 */
public class Prob2 {
    public static int b_search (int lower , int upper, int[] data)
    {
        int mid = (int) (lower + upper) / 2;
        if (data[mid] < data [mid + 1])
            return b_search (mid , upper , data);
        else 
        {
            if (mid == lower)
                return data[lower];
            else if (data[mid - 1] < data[ mid ])
                    return data[mid];
            else
                return b_search (lower , mid , data);
        }
    }
    
    public static void main (String args[])
    {
        int [] data = { -5 , -2 , -1 ,0 ,5 ,6 , 4, 2, 1};
        System.out.println(b_search (0, data.length, data) );
    }
}
