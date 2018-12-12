package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Basic06_5 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][m];
		int num = 3;
		for(int i=0; i<arr.length; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<arr[0].length; j++) {
				if(st.hasMoreElements()) {
					num = Integer.parseInt(st.nextToken());
				}
				arr[i][j] = num;
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println("");
		}
		
	}
}