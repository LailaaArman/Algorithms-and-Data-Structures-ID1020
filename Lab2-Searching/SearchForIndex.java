/**Parts of this code is taken from Algorithms Fourth Edition and Princeton webpage**
 * 
 * * @author Laila Arman 
 * 
 * Creation date: September 27th 2019 
 * 
 * Last updated: September 27th 2020
 * 
 * What the code does: takes textfile as input, a word as UserInput and prints out the word and at what index it occurs.
 * 
 * The code is based on previous knowledge in the java programming language. 
 * 
 * The programming language used is java.
 */

import java.lang.*;
import java.util.*;
import java.io.*;

public class SearchForIndex{ 

    public static void main(String[] args) throws Exception{
        
    Scanner scan = new Scanner(new File ("filteredtext2.txt"));    //NEW file 

    ArrayList <String> list = new ArrayList <String>();       //ArrayList innbyggd i java 
    
    //Scans all the words in the LAB3text.txt-file
    while(scan.hasNext())
    {
        list.add(scan.next().toLowerCase());     //Lowercase converts a string to LowerCase
    }
    
    
    System.out.println("Which word would you like to find index for? ");
    Scanner scanQ = new Scanner(System.in);
    String wordSearch = scanQ.next().toLowerCase();     //user input, enters word 
    
    //Checks if the userinputword exists in the list
    if(list.contains(wordSearch))
    {
        
        int pos = 1;      //counter for positions

        for(int i = 0; i < list.size(); i++){       //Iterates thru the Arraylist
            
            if(list.get(i).equals(wordSearch))      //Checks if userinputWord matches 
            {
                System.out.println("Word "+ "''" + wordSearch + "''" + " is located on index " + "[ " + pos + " ]");
            }else
              //If i not equals the last word, we iterate thru the word and blank space to reach next word
                if(i != (list.size()-1))      // if i is not equal to the last word 
                {
                    pos += list.get(i).length();    //get length of word, which pos
                    pos++;                          //go to next word 
                } //Else if i are at the last word we only iterate thru the last word since there is no blank space after the last word
                else if (i == (list.size()-1))        //if i is at the last word 
                    pos += list.get(i).length();       //get length of the word 
            }
        }
    }
}
