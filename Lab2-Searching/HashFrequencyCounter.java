import java.util.*;
import java.io.*;
/**
 *  The {@code FrequencyCounter} class provides a client for
 *  reading in a sequence of words and printing a word (exceeding
 *  a given length) that occurs most frequently. It is useful as
 *  a test client for various symbol table implementations.
 *  <p>
 *  For additional documentation, see <a href="https://algs4.cs.princeton.edu/31elementary">Section 3.1</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 * 
 ******** Parts of this code, explained above, is taken from Algorithms Fourth Edition and Princeton webpage *********
 * 
 * *
 * 
 * Creation date: September 26th 2019 
 * 
 * Last updated: September 26th 2020
 * 
 * What the code does: takes textfile as input and prints the hashCode and number of collisions.
 * 
 * The code is based on previous knowledge in the java programming language. 
 * 
 * The programming language used is java.
 */

public class HashFrequencyCounter {

    /**
     * Reads in a command-line integer and sequence of words from
     * standard input and prints out a word (whose length exceeds
     * the threshold) that occurs most frequently to standard output.
     * It also prints out the number of words whose length exceeds
     * the threshold and the number of distinct such words.
     *
     * @param args the command-line arguments
     * TIME COMPLEXITY : Worst case: O(n)
     */
    public static void main(String[] args) throws Exception {
       
        Scanner scan = new Scanner(new File("filteredtext2.txt"));     //create scanner object and get file

        int words = 0;

        BinarySearchST <String, Integer> ST = new BinarySearchST<String, Integer>(2); //Create Symbol Binary ST 
        int minlen = 1;  

        while (scan.hasNext()) {             //
            String key = scan.next();  
            if (key.length() < minlen) 
            {
                continue;  
            }
            words++;     

            if (ST.contains(key)) 
            {
                ST.put(key, ST.get(key) + 1);     // if key already exists, add another one  
            }
            else {
                ST.put(key, 1);             //if it doesnt exist, add the new key 
            }
        }
        
        BinarySearchST<Integer, Integer> hstabel = new BinarySearchST<Integer, Integer>(2);  //create ST for hash

        //For-each loop that checks every word in Binary Search Symbol Table st 
        for(String word : ST.keys())   //för vajre ord som finns i st.keys
        {
            int hscode = word.hashCode();     //gets the hashCode value for the String 
            hscode = Math.abs(hscode)% 97;    //Index! mod on hashCode, using math.abs to make sure it is not negative
                                        //97 because it's a prime number, reduces collisons. 

            if(hstabel.contains(hscode))             //checks if hstabel contains my hsCode 
            {
                int countHashes = hstabel.get(hscode);    //get returns the value   ??
                hstabel.put(hscode, countHashes+1);    //increase counter for collisions since it already exist
            }                                          //counts collisions 
            else{                             //if not, put it there and adds 1 as frequency
                hstabel.put(hscode, 1);    //annars lägg till 
            }
        }
        
        //Prints every hashcode and collision
        for(int hscode : hstabel.keys())          
        {
            System.out.println("The hashCode is: " + hscode + " with " + hstabel.get(hscode) + " number of Collisions");
        }
    }
}