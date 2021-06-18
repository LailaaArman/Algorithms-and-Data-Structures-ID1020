/* This program will order negative and positive integers, so that the negative ones are first in the sequence
*/ 
 
 // Worst case (O(n))

#include <stdio.h>
#include <stdlib.h>
 
void order(int a[], int size){
  int j = 0;
  int temp = 0;
  for (int i = 0; i < size; i++){
 
    if (a[i] < 0)
    {
    temp = a[i];
    a[i] = a[j];
    a[j] = temp;
    j++;
    }
  }
}
 
 
int main()
{
  printf("Enter size of array:");
  int num;
  scanf("%d", &num);   
 
  int array[num];
  printf("Enter elements: \n");
  for(int i=0; i<num; i++)
    scanf("%d", &array[i]);
 
  order(array, num);
 
  printf("\nArray with negative integers first: ");
  for(int i=0; i<num; i++)
    printf("%d ", array[i]);
 
  return 0;
}


