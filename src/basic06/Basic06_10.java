package basic06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Basic06_10 {
	static int n;
	static int[][] arr;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		sb = new StringBuilder();
		
		for(int i=0; i<arr.length; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<arr[0].length; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		getCode(0, 0, n);
	}
	
	public static void getCode(int x, int y, int size) {
		int cur = arr[x][y];
		boolean flag = true;
		for(int i=x; i<(x+size); i++) {
			for(int j=y; j<(y+size); j++) {
				if(cur != arr[i][j]) {
					flag = false;
				}
			}
		}
		
		if(flag) {
			System.out.print("0"+arr[x][y]);
		}else {
			System.out.print(1);
			getCode(x, y, size/2);
			getCode(x+(size/2), y, size/2 );
			getCode(x, y+(size/2), size/2 );
			getCode(x+(size/2), y+(size/2), size/2 );
		}
	}
	
}
