package basic06.study;

import java.util.Scanner;

public class GraphEx1 {
	/*
	 *  5 6 ( vertex cnt, edge cnt)
	 *  1 2  
	 *  1 3     1-------2
	 *  1 4     |\     /
	 *  2 4		| \   /
	 *  4 5		|  \ /
	 *  3 5     3   4---5
	 *          ㄴ------/
	 *  
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int vertexNum = in.nextInt();
		int edgeNum = in.nextInt();
		int[][] arr = new int[vertexNum][vertexNum];
		
		for(int i=0; i<edgeNum; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			arr[a-1][b-1] = 1;
			arr[b-1][a-1] = 1;
		}
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
		//System.out.println(isConnected(arr, 1, 2));
		//System.out.println(isConnected(arr, 1, 1));
		getAdj(arr, 1);
		getAdj(arr, 2);
	}
	
	public static boolean isConnected(int[][] arr, int x, int y) {
		return arr[x-1][y-1]==1;
	}
	
	public static void getAdj(int[][] arr, int x) {
		//adjacent vertex
		for(int i=0; i<arr.length; i++) {
			if(arr[x-1][i] == 1) {
				System.out.print((i+1)+" ");
			}
		}
		System.out.println();
	}
}
