package basic08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Basic08_01_bak {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] arr1 = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<arr1.length; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		
		int m = Integer.parseInt(br.readLine());
		int[] arr2 = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<arr2.length; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr1);
		
		
		for(int i=0; i<arr2.length; i++) {
			int temp = biS(arr1, 0, arr1.length-1, arr2[i]);
			if(temp!=-1) {
				System.out.println("1");
			}else {
				System.out.println("0");
			}
		}
		
	}
	public static int biS(int[] arr, int s, int e, int value) {
		if(s>e) {
			return -1;
		}else if(s==e) {
			if(arr[s]==value) {
				return s;
			}else {
				return -1;
			}
		}
		
		int mid = (s+e)/2;
		if(arr[mid]==value) {
			return mid;
		}else if(arr[mid]>value) {
			return biS(arr, s, mid-1, value);
		}else {
			return biS(arr, mid+1, e, value);
		}
	}
}
