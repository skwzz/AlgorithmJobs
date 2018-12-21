package course1.chap01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C2Q3 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[] arr = new int[9];
		int idx=0;
		for(int i=0; i<arr.length; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
			if(arr[idx]>arr[i]) {
				idx = i;
			}
		}
		
		arr[idx] = 999999999;
		idx = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[idx]>arr[i]) {
				idx = i;
			}
		}

		System.out.println(arr[idx]);
		System.out.println(idx+1);
		
		
	}
}
