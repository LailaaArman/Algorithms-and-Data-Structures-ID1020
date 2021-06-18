import java.util.Random;

public class MergeSort {
     static Random random = new Random(); 
    
	
	public static void merge(int[] a, int lo, int mid, int hi)   // Merge a[lo..mid] with a[mid+1..hi]
     { 
         int i = lo;                    //lowest index i=0
         int j = mid+1;                 
		 int aux[] = new int [a.length];      //create temp array
    
		 for (int k = lo; k <= hi; k++)    			 // Copy a[lo..hi] to aux[lo..hi].
			 aux[k] = a[k];
		 for (int k = lo; k <= hi; k++)    			 // Merge back to a[lo..hi].
             if (i > mid) 
             a[k] = aux[j++];
		 else if 
                 (j > hi ) 
                 a[k] = aux[i++];
		 else if 
             (Sorting.less(aux[j], aux[i])) 
             a[k] = aux[j++];
		 else 
			 a[k] = aux[i++];
   }
	 
     private static int[] aux;        		// auxiliary array for merges
     
     public static void sort(int[] a)      //börjar här 
     {
    	 aux = new int [a.length]; 			 // Allocate space just once.
    	 sort(a, 0, a.length - 1);             //call sort
     }
   
    private static void sort(int[] a, int lo, int hi) // Sort a[lo..hi].
    { 
    	if (hi <= lo) return;     //?
    	int mid = lo + (hi - lo)/2;
    	sort(a, lo, mid);          // Sort left half.   Recursive calls  
    	sort(a, mid+1, hi);        // Sort right half.
    	merge(a, lo, mid, hi);    // Merge the two halves sorted in step 2 and 3 (code on page 271).   ?? 
    }
    	
   public static void main(String[] args) 
    	{	
            int array  [] = new int [1000]; 
            
            Random random = new Random(); 
		
			for(int i=0; i<array.length;i++)  
		{
            array[i] = random.nextInt(100);        
        }
        
        //mergesort 
		long t1= System.nanoTime(); 
		      sort(array); 
		 long t2 = System.nanoTime(); 
		 long t = t2-t1; 
		 double tSec = (double)t/1000000000;
		 
		 System.out.println("Mergesort time: " + tSec); 
         System.out.println(Sorting.isSorted(array)); 
         

         for(int i=0; i<array.length;i++)  
         {
             array[i] = random.nextInt(100);      
         }

         //insertionsort 
         long time1= System.nanoTime(); 
              Sorting.InsertionSort(array); 
		 long time2 = System.nanoTime(); 
		 long timeDiff = time2-time1;  
		 double time = (double)timeDiff/1000000000;   
		 
		 System.out.println("InsertionSort time: " + time); 
		 System.out.println(Sorting.isSorted(array)); 
  }
   
   /*
    8.Compare the execution times for sorting large arrays of integers with mergesort and InsertionSort
    
    ArraySize 		InsertionSort	Mergesort 
    
    a [10]			2.6036E-5		0.042231471
    a [100]			5.91367E-4		0.042878226
    a [1000]		0.056309547	    0.05197164
    a [10000]		0.263474203 	0.1793005
    a [100000]		10.745480562	4.160788106
    a [1000000]		    -                   -  
    
    */
   	
}