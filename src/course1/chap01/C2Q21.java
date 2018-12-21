package course1.chap01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C2Q21 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		
		int[][] arr1 = new int[n][m];
		for(int i=0; i<arr1.length; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<arr1[0].length; j++) {
				arr1[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<arr1.length; i++) {
			for(int j=arr1.length-1; j>=0; j--) {
				System.out.print(arr1[i][j]+" ");
			}
			System.out.println("");
		}
	}
}
