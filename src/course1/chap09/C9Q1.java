package course1.chap09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Q : 이진탐색
 * @author kiwoong
 *
 */
public class C9Q1 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr1 = new int[n];
		int[] arr2 = new int[m];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<arr1.length; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<arr2.length; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<arr2.length; i++) {
			int temp = BSearch(arr1, 0, arr1.length-1, arr2[i]);
			if(temp!=-1) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
	}
	
	public static int BSearch(int[] arr, int start, int end, int target) {
		if(start>end) {
			return -1;
		}else if(start==end) {
			if(arr[start]==target) {
				return start;
			}else {
				return -1;
			}
		}
		
		int mid = (start+end)/2;
		if(arr[mid]==target) {
			return mid;
		}else if(arr[mid]>target) {
			return BSearch(arr, start, mid-1, target);
		}else {
			return BSearch(arr, mid+1, end, target);
		}
	}
}
