package course1.chap01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C1Q4 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		for(int i=n; i<=m; i++) {
			isPrime(i);
		}
	}
	
	public static void isPrime(int x) {
		if(x==1) {
			return;
		}else if(x==2) {
			System.out.print(x+" ");
		}else if(x%2==0) {
			return;
		}else {
			for(int i=2; i<x-1; i++) {
				if(i%2==0) {
					continue;
				}
				if(x%i==0) {
					return;
				}
			}
			System.out.print(x+" ");
		}
	}
}
