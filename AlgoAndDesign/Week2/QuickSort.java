
import java.util.Scanner;

/**
 *
 * @author Vodka
 */
public class QuickSort {
    public static int count_par = 0;
    public QuickSort (int[] data)
    {
        quicksort(data , 0 , data.length - 1);
    }
    
    public void quicksort(int[] data , int i_left , int i_right) {
        //method to control 3 main sub-routines:
        // 1) choose pivot
        // 2) partition
        // 3) recursion of this quicksort
  //      System.out.println (i_left + " " + i_right);
        int i_pivot = findPivot (data , i_left , i_right) ;
        
 //       System.out.println (i_pivot);
        int next_pivot = partition (data , i_left , i_right , i_pivot);
        if (  ( next_pivot - i_left ) > 1  )
        quicksort (data , i_left , next_pivot - 1 );
        if (  ( i_right - next_pivot ) > 1  )
        quicksort (data , next_pivot + 1 , i_right);
        
    }
    
        

    //swap method
    
    public void swap (int[] data , int i_swap , int i_target)
    {
 //       System.out.println(data[i_swap] + " swapped with " + data[i_target]);
        int temp = data[i_swap];
        data[i_swap] = data[i_target];
        data[i_target] = temp;
 //       System.out.println ("Swapped");
    }
    
    //sub_routine to find the correct position of pivot
    public int partition (int[] data , int i_left , int i_right , int i_pivot )
    {
     
        int left_ptr = i_left + 1 ; 
        int pivot = data[i_pivot];
        //swap the pivot to the front of the sub array
        swap (data , i_left , i_pivot);
       // System.out.println (java.util.Arrays.toString(data));
        for ( int i = i_left + 1 ; i <= i_right ; i++)
        {
        //if unpartitioned element < pivot value, swap with boundary element to ensure left of pivot is < pivot
            if ( data[i] < pivot ) 
            {
                swap (data , left_ptr , i);
                left_ptr ++ ;
            }            
        }
        //done iterating thru all elements, swap the pivot with the boundary index value
        swap (data , i_left , left_ptr - 1);
        int comparison = i_right - i_left;
        count_par = count_par + comparison;
        // return the boundary of the partition
        return left_ptr - 1;
    }
    
    
    //sub_routine to find pivot index
    public int findPivot ( int[] data , int i_left , int i_right)  //find next pivot index
    { 
        int i_pivot = 0;
        int i_middle = ( i_left + i_right ) / 2;
        int middle = data[i_middle];
        if ( data[i_right] > middle )
        {
            if (middle > data[i_left])
                i_pivot = i_middle;
            else if (data[i_right] > data[i_left] )
                i_pivot = i_left;
            else
                i_pivot = i_right;
        }
        else 
        {
            if (data[i_right] > data[i_left])
                i_pivot = i_right;
            else if (middle > data[i_left])
                i_pivot = i_left;
            else 
                i_pivot = i_middle;
        }
        return i_pivot;
    }
    
    public static void main (String args[] )
    {
        System.out.println("hello");
       // int[] test = { 2 , 4 ,6 , 8 , 1 };
       // QuickSort a = new QuickSort (test);
       // System.out.println(a.count_par);
        
        Scanner in = new Scanner (System.in);
        int[] data = new int[10000];
        for (int i = 0 ; i< 10000 ; i++) 
        {
            data[i] = in.nextInt();
        }
        QuickSort a  = new QuickSort(data);
        System.out.println (java.util.Arrays.toString(data));
        System.out.println (a.count_par);

    }
}
