package basic07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Basic07_06 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();
		if(str1.contains(str2)) {
			System.out.print("YES");
		}else {
			System.out.print("NO");
		}
		
	}
}
