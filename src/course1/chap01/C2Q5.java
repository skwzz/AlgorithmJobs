package course1.chap01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C2Q5 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[] arrA = new int[10];
		int[] arrB = new int[10];
		int cntA = 0;
		int cntB = 0;
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<10; i++) {
			arrA[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<10; i++) {
			arrB[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<10; i++) {
			if(arrA[i] > arrB[i]) {
				cntA++;
			}
			if(arrA[i] < arrB[i]) {
				cntB++;
			}
		}
		if(cntA>cntB) {
			System.out.println("A");
		}else if(cntA<cntB) {
			System.out.println("B");
		}else {
			System.out.println("D");
		}
	}
}
