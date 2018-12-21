package basic07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Basic07_05 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		char[] arr = str.toCharArray();
		char temp = arr[0];
		int cnt = 0;
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == temp) {
				cnt++;
			}else {
				if(cnt!=1) {
					System.out.print(cnt);
				}
				System.out.print(temp);
				cnt=1;
				temp = arr[i];
			}
		}
		if(cnt!=1) {
			System.out.print(cnt);
		}
		System.out.print(temp);
	}
}
