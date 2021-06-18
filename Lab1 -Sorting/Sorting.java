import java.util.Scanner; 

 public class Sorting 
 {
 
static Scanner in = new Scanner(System.in);  

static int exchCounter = 0;

   	public static void InsertionSort(int [] a) 		
   	{
    //System.out.println("\nINSERTIONSORT:"); 
	 int N = a.length;
	 for (int i = 1; i < N; i++)    // Insert a[i] among a[i-1], a[i-2], a[i-3]... ..
	 {
		    {													 
		    	for (int j = i; j > 0 && less(a[j], a[j-1]); j--)
                    exch(a, j, j-1); 
                    	    
     }
 }
 }
  
 public static boolean less(Integer v, Integer w)
 {    
	 return v.compareTo(w) < 0; 
 
 }
 
 public static void exch(int[] a, int i, int j)  //uppg2 SWAPS 
 { 
	 int t = a[i]; 
	 a[i] = a[j]; 
     a[j] = t; 
     //show(a);                       //kommentera bort när vi vi testar tiden i Mergesort 
     exchCounter++;    
     
 }
 
 public static void show(int[] a)  // Print the array, on a single line.
 { 
 
   for (int i = 0; i < a.length; i++)
      System.out.print(a[i] + " ");
      System.out.println();
 }
 
 public static boolean isSorted(int[] a)   // Test whether the array entries are in order.
 {
     for (int i = 1; i < a.length; i++)
     if (less(a[i], a[i-1])) return false;
     return true;
 }
 
	static int countInversion=0; 
	
        public static int inversions(int [] a)     //uppg3 INVERSIONS 
        {  
         System.out.println("INVERSIONS:");    //worst case O(n)^2 , two for loops 
         for(int i=0; i<a.length; i++)
     
	 {
		 for(int j=i+1; j > i && j<a.length; j++)
		 {
			 if (a[i] > a[j])
             countInversion++; 
			 System.out.println("[" + i + "," +  a[i] +  "]" + "," + "["   + j + "," +  a[j]+ "]"); 
		 }
	 }
	 

	 return countInversion; 
}
 
	public static void main(String[] args) 
   	{
        
   		System.out.println("Write the number of elements to be sorted");
   		int e = in.nextInt();
   		
   		System.out.println("Write the numbers to be sorted"); 
   		
   		int a[] = new int[e];
  		    for(int i=0; i < e; i++)
   		    a[i] = in.nextInt(); 
  		System.out.println(); 
          
  		
   		int inversions = inversions(a);
   		   	    	
        InsertionSort(a);
   		
   		show(a);
 
        System.out.println("Number of inversions: " + inversions);
        System.out.println("Number of swaps: " + exchCounter);
  	    System.out.print("Sorted elements: ");
  	    show(a); 
   		
   	}
}





