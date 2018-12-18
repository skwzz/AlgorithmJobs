package basic06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Basic06_9 {
	static int n;
	static int m;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static boolean[][][] visited;
	static int[][] arr;
	static int startX;
	static int startY;
	static int endX;
	static int endY;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); //n*m  start(n-1,0)  end(0,m-1);
		m = Integer.parseInt(st.nextToken());
		startX = 0;
		startY = m-1;
		endX = n-1;
		endY = 0;
		
		visited = new boolean[n][m][2];
		arr	= new int[n][m];
		
		for(int i=0; i<arr.length; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<arr[0].length; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		moksuBFS();
	}
	
	public static void moksuBFS() {
		Queue<Dot9> q = new LinkedList<Dot9>();
		visited[startX][startY][1] = true;
		q.add(new Dot9(startX, startY, 1));
		int step = 0;
		
		loop : while(!q.isEmpty()) {
			int size = q.size();
			step++;
			
			for(int i=0; i<size; i++) {
				Dot9 d = q.poll();
				int curX = d.x;
				int curY = d.y;
				int curDrillCnt = d.drillCnt;
				
				if(curX==endX && curY==endY) {
					break loop;
				}
				
				for(int j=0; j<4; j++) {
					int nextX = curX + dx[j];
					int nextY = curY + dy[j];
					
					if(nextX<0 || nextY<0 || nextX>=n || nextY>=m) {
						continue;
					}
					
					if(arr[nextX][nextY]==1) {
						if(curDrillCnt==1 && !visited[nextX][nextY][curDrillCnt]) {
							visited[nextX][nextY][curDrillCnt]=true;
							q.add(new Dot9(nextX, nextY, 0));
						}
					}else {
						if(!visited[nextX][nextY][curDrillCnt]) {
							visited[nextX][nextY][curDrillCnt] = true;
							q.add(new Dot9(nextX, nextY, curDrillCnt));
						}
					}
				}
			}
		}
		
		System.out.println(step-1);
	}
}

class Dot9{
	int x;
	int y;
	int drillCnt;
	
	public Dot9(int x, int y, int drillCnt) {
		this.x = x;
		this.y = y;
		this.drillCnt = drillCnt;
	}
}