/**
 * @author Laila Arman
 * What the code does: takes textfile as input and prints Alphas, blank and new lines.
 * 
 * The code is based on previous knowledge in the c programming language. 
 * 
 * The programming language used is c. 
 *  gcc -Wall -o uppg1 Assignment1.c
 *  Run with ./uppg1 < filteredtext2.txt > output.txt (skriv annat namn än output)
 */

#include <stdio.h>
#include <ctype.h>

int main()
{
    char a;

    /*This while-loops get chars from the text until End Of File, the if statement contains the requirements asked in the task, 
    it checks if char a is Alpha, Blank or newline and prints the new text otherwise it skips (signs like .:,!0 etc)*/

    while((a = getchar()) != EOF)    //get chars from the text until End of File 
    {
    
    if (isalpha(a) || a == ' ' || a == '\n')    //check if char a is Alpha,Blank or newline
        {
            printf("%c", a);                   //print the the charachters one by one 
        }
    else
        { 
            printf(" ");                      //Write blank otherwise 
        }
    }
}
