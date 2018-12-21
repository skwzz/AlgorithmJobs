package course1.chap01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C1Q3 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<=n; i++) {
			for(int k=n-1; k>=i; k--) {
				System.out.print(" ");
			}
			for(int j=1; j<=(i*2)-1; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
}
