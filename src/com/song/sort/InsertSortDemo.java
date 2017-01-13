package com.song.sort;

/**
 * @author carpenter
 * @version 2017/1/13
 * Worst running time T(n) = n(n-1)/2
 */
public class InsertSortDemo {
	/**
	 * insertion sort algorithm results in ascending order
	 * @param array array to sorted 
	 * @return  a sorted array
	 */
	public  static int[] insertSortAsc(int array[]){
       for(int currentIndex=1;currentIndex<array.length;currentIndex++){
    	   //get current data   
    	   int current = array[currentIndex];
    	   //insert array[i] into the sorted sequence A[0...i-1]
    	   //gets the index of the previous position
    	   int beforeIndex = currentIndex-1;
    	  //The index is greater than 0 and the data corresponding 
    	   //to the previous index is larger than the current position data
    	   while(beforeIndex >= 0&&array[beforeIndex]>current){
    		 //when the data if found to be larger than the current data data
    		   //the current data is moved backwards
    		   array[beforeIndex+1] = array[beforeIndex];
    	  //subscript minus one,you can continue to determine whether the
    	  //previous a is larger than the current record number
    		   beforeIndex--;
    	   }
    	   //if there is no larger number than the current record,the current
    	   //number is smaller than the current number
    	   array[beforeIndex+1] = current;
       }
		return array;
	}
	public static void main(String[] args) {
		int array[] = {1,3,2,5,6,7,9,4,8};
		array = insertSortAsc(array);
		for(int current:array){
			System.out.println(current);
		}
	}
}
