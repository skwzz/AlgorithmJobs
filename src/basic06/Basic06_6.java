package basic06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Basic06_6 {
	public static int idx = 2;
	public static int oneCount = 0;
	public static void main(String[] args) {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		
		Basic06_6 test = new Basic06_6();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] arr = new int[n+2][n+2];
		//int[][] arr = new int[n][n];
		
		for(int i=0; i<n; i++) {
			String str = in.next();
			for(int j=0; j<str.length(); j++) {
				arr[i+1][j+1] = (int)str.charAt(j)-48;
			}
		}
		
		for(int i=0; i<arr[0].length; i++) {
			for(int j=0; j<arr.length; j++) {
				if(arr[i][j] == 1) {
					int cnt = test.recursiveDFS(arr, i, j);
					temp.add(cnt);
					oneCount = 0;
					idx+=1;
				}
			}
		}
		
		System.out.println(temp.size());
		Collections.sort(temp);
		for(int i=0; i<temp.size(); i++) {
			System.out.println(temp.get(i));
		}
	}
	
	public int recursiveDFS(int[][] arr, int x, int y) {
		oneCount++;
		arr[x][y] = idx;
		
		if(arr[x-1][y]==1) {
			recursiveDFS(arr, x-1, y);
		}
		if(arr[x+1][y]==1) {
			recursiveDFS(arr, x+1, y);
		}
		if(arr[x][y-1]==1) {
			recursiveDFS(arr, x, y-1);
		}
		if(arr[x][y+1]==1) {
			recursiveDFS(arr, x, y+1);
		}
		
		return oneCount;
	}
}
