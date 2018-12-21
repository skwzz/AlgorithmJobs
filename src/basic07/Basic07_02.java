package basic07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Basic07_02 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		char[] arr = str.toCharArray();
		
		for(int i=0; i<arr.length; i++) {
			if('A'<=arr[i] && arr[i]<='Z') { //UpperCase
				arr[i] = (char)(arr[i]+32);
			}else if('a'<=arr[i] && arr[i]<='z') { //LowerCase
				arr[i] = (char)(arr[i]-32);
			}
			System.out.print(arr[i]);
		}
	}
}
