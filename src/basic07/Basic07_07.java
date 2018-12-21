package basic07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Basic07_07 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		ArrayList<String> arr = new ArrayList<String>();
		
		for(int i=0; i<n; i++) {
			arr.add(br.readLine());
		}
		
		Collections.sort(arr);
		for(int i=0; i<arr.size(); i++) {
			System.out.println(arr.get(i));
		}
		
	}
}
