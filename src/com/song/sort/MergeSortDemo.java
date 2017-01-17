package com.song.sort;

/***********************************************************
 * 归并排序 分治法，自顶向下，递归分割数组，最终归并
 * 比较操作的次数介于(nlogn) / 2和nlogn - n + 1。
 * 归并排序比较占用内存，但却是一种效率高且稳定的算法。
 *（速度仅次于快速排序，为稳定排序算法，一般用于对总体无序
 ********************************************************** 
 *******************10 4 6 3 8 2 5 7***********************
 ***************10 4 6 3********8 2 5 7********************
 *************10 4****6 3*****8 2*****5 7******************
 ************10***4**6***3***8***2***5***7*****************
 *************4 10****3 6*****2 8*****5 7******************
 **************3 4 6 10********2 8 5 7*********************
 *******************1 3 4 5 6 7 8 10************************
 ***********************************************************
 * 
 * @author 123456
 *
 */
public class MergeSortDemo{
 	public static void main(String[] args) {
		int arr[] = {2,4,6,8,1,3,5,9};
		mergeAsc(arr,0,arr.length-1);
		for(int index=0;index<arr.length;index++){
			System.out.println(arr[index]);
		}
	}

	/**
	 * 分治法，自顶向下，递归分割数组，最终归并
	 * @param arr 要排序的数组
	 * @param start 要排序的数组的开始下标
	 * @param end 要排序的数组的结束下标
	 */
	private static void mergeAsc(int[] arr, int start, int end) {
		// TODO Auto-generated method stub
		if(start<end){//如果开始下标小于结束下标，拆分数据到不可以拆分
			/*先找到中点下标--如果 数组为:1 2 3 
			 * 中点下标为（开始0+结束1)/2 = 0
			 * 如果数组为1 2 3 4
			 * 中点下标为(开始0+结束3）/2=1
			 * 中点下标属于前半部分
			 */
			int mid = (start+end)/2;
			//开始递归，把找到的开始下标到中点下标再拆分
			mergeAsc(arr,start,mid);
			//开始递归，把找到的结束下标到中点下标+1再拆分
			mergeAsc(arr,mid+1,end);
			
		    doMerge(arr,start,mid,end);
		}
		
	}

	/**
	 * 求解+组合 ---因为递归越小的数组肯定会越先比较然后合并大小
	 * @param arr 完整数组
	 * @param start 被拆分后的每个子数组的开始下标
	 * @param mid  被拆分后的每个子数组的中点下标
	 * @param end  被拆分后的每个子数组的结束下标
	 */
	private static void doMerge(int[] arr, int start, int mid, int end) {
		// TODO Auto-generated method stub
		int tempIndex = start;//把开始下标赋值给临时下标
		int index = start;//让开始下标等于index下标
		int right = mid + 1;//让右边下标等于中间下标加1
		int temp[] = new int[arr.length];//创建新的临时数组长度与原数组长度一样
		//两个子序列比较，小的放入临时数组例如:
		 //举例子:因为子序列肯定先执行所以每个子序列数据都是从小到大
		 //start=0        mid=3   right=4          end=7
		//1  3 4 5                   2 6 7 8
        //1 -------start=1
		//1 2------start = 1 right = 5
		//1 2 3 ---start = 2 right = 5
		//1 2 3 5---start = 3 right = 5
		//1 2 3 5 6--start = 4 right = 5
		//两个序列同时开始走，谁小取谁放到临时数组里面
		while(start <= mid && right <= end){
			if(arr[start] <= arr[right]){
				temp[tempIndex++] = arr [start++];
			}else{
				temp[tempIndex++] = arr[right++];
			}
		}
		//第一个循环走完临时数组里面保存了子序列中的最小值
		//剩下的右边的元素加入临时数组
		while(start <= mid){
			temp[tempIndex++] = arr[start++];
		}
		while(right <= end){
			temp[tempIndex++] = arr[right++];
		}
		//复制临时数据temp[]中的数据到arr[]数组
		while(index<end){
			arr[index] = temp[index++];
		}
	}
}
