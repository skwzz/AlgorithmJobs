package basic07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Basic07_03 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		char[] arr = str.toCharArray();
		
		for(int i=arr.length-1; i>=0; i--) {
			System.out.print(arr[i]);
		}
	}
}
