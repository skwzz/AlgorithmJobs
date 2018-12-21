package course1.chap01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C2Q4 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		boolean streak = false;
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i]!=0) {
				if(streak==true && i!=0) {
					arr[i] = arr[i-1]+1;
				}
				streak = true;
			}else {
				streak = false;
			}
		}
		
		for(int i=0; i<arr.length; i++) {
			sum += arr[i];
		}
		System.out.print(sum);
	}
}
