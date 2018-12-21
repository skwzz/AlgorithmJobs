package course1.chap01;

import java.io.IOException;
import java.util.Scanner;

public class C2Q2 {
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(System.in);
		int[] arr = new int[9];
		int idx = 0;
		for(int i=0; i<arr.length; i++) {
			arr[i] = in.nextInt();
			if(arr[idx]<arr[i]) {
				idx = i;
			}
		}
		System.out.println(arr[idx]);
		System.out.println(idx+1);
	}
}
