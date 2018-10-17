package com.web.apps.HelperClasses;
public class Testing{
	public static void main(String[] args){
       int[] arr={90,23,101,45,65,23,67,89,34,23};  
       //insertionSort(arr);
       quickSort(arr);
	}
	
	public static void insertionSort(int[] arr){
		int c;
		for(int i=1;i<arr.length;i++){
			for(int j=0;j<i;j++){
				if(arr[i]<arr[j]){
					c=arr[i];
					arr[i]=arr[j];
					arr[j]=c;
				}
			}
		}
		System.out.println("After Doing Insertion Sort :");
		for(int k=0;k<arr.length;k++)
			System.out.print(arr[k]+" ");
	}
	
	public static void quickSort(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			
		}
	}
}