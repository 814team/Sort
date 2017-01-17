package com.song.sort;

/**
 * 直接插入排序的算法思路：
 *（1） 设置监视哨r[0]，将待插入纪录的值赋值给r[0]；
 *（2） 设置开始查找的位置j；
 *（3） 在数组中进行搜索，搜索中将第j个纪录后移，直至r[0].key≥r[j].key为止；
 *（4） 将r[0]插入r[j+1]的位置上。
 *****每次找出来一个满足条件的放在前面指定位置其它的向后移动************
 *原序列 5 |1  7  3  1  6  9 4
 *第一遍 1  5 |7  3  1  6  9 4
 *第二遍 1  5  7 |3  1  6  9 4
 *第三遍 1  3  5  7 |1  6  9 4
 *第四遍 1  1  3  5  7 |6  9 4
 *我五遍 1  1  3  5  6  7 |9 4
 *第六遍 1  1  3  5  6  7  9|4
 *结果: 1  1  3  4  5  6  7 9
  *********************************************************
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
