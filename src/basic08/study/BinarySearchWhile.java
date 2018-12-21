package basic08.study;

import java.util.Scanner;

public class BinarySearchWhile {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int value = in.nextInt();
		int[] arr = new int[10];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = i*2;
			System.out.print(arr[i]+" ");
		}
		System.out.println("");
		
		int start = 0;
		int end = arr.length-1;
		
		while(true) {
			if(start>end) {
				System.out.println("-1");
				break;
			}else if(start==end && arr[start]==value) {
				System.out.println(start);
				break;
			}
			
			int mid = (start+end)/2;
			
			if(arr[mid]==value) {
				System.out.println(mid);
				break;
			}else if(arr[mid]>value) {
				end = mid-1;
			}else {
				start = mid+1;
			}
		}
	}
}
