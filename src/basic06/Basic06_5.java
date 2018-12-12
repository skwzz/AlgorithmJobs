package basic06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Basic06_5 {
	static int[][] arr;
	static boolean[][] visited;
	static int n;
	static int m;
	static int startX;
	static int startY;
	static int endX;
	static int endY;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		visited = new boolean[n][m];
		String str;
		
		for(int i=0; i<arr.length; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0 ;j<arr[0].length; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				visited[i][j] = false;
			}
		}
		
		startX = 0;
		startY = m-1;
		endX = n-1;
		endY = 0;
		
		visited[startX][startY] = true;
		BFS(startX, startY);
		System.out.println(arr[endX][endY]);
	}
	
	public static void BFS(int x, int y) {
		ArrayList<Dot> al = new ArrayList<Dot>();
		al.add(new Dot(x, y));
		
		while(!al.isEmpty()) {
			Dot d = al.remove(0);
			if(endX == d.x && endY == d.y) {
				break;
			}
			for(int i=0; i<4; i++) {
				int nextX = d.x + dx[i];
				int nextY = d.y + dy[i];
				
				if(nextX<0 || nextY<0 || nextX>=n || nextY>=m) {
					continue;
				}
				
				if(visited[nextX][nextY] || arr[nextX][nextY]==1) {
					continue;
				}
				
				al.add(new Dot(nextX, nextY));
				
				arr[nextX][nextY] = arr[d.x][d.y]+1;
				visited[nextX][nextY] = true;
			}
		}
	}
}
class Dot{
	int x;
	int y;
	public Dot(int x, int y) {
		this.x = x;
		this.y = y;
	}
}