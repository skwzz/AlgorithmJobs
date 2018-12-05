package basic06.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class GraphDFSEx1 {
	/*
	 * C version code [ARCHETYPE]
	 * void DFS(Graph graph, int x, bool visited[]){
	 * 	visited[x] = true;
	 *  for(int i=0; i<graph[x].size(); i++){
	 *    int y = graph[x][i];
	 *    
	 *    if(visited[y]==false){
	 *      DFS(graph, y, visited);
	 *    }
	 *  }  
	 * } 
	 */
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int vertexNum = in.nextInt();
		int edgeNum = in.nextInt();
		GraphVertex[] gv = new GraphVertex[vertexNum];
		for(int i=0; i<gv.length; i++) {
			gv[i] = new GraphVertex();
			gv[i].data = i+1;
		}
		for(int i=0; i<edgeNum; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			
			gv[a-1].adj.add(b);
			gv[b-1].adj.add(a);
		}
		for(int i=0; i<gv.length; i++) {
			Collections.sort(gv[i].adj);
		}
		
		for(int i=0; i<gv.length; i++) {
			System.out.print((i+1)+"인접한 Vertex : ");
			for(int j=0; j<gv[i].adj.size(); j++) {
				System.out.print(gv[i].adj.get(j)+" ");
			}
			System.out.println();
		}
		System.out.println("***********************");
		graphDFS(gv, 0);
		System.out.println("매무리");
	}
	
	public static void graphDFS(GraphVertex[] v, int x) {
		System.out.print(v[x].data+" ");
		v[x].visited = true;
		
		for(int i=0; i<v[x].adj.size(); i++) {
			int next = v[x].adj.get(i)-1;
			if(!v[next].visited) {
				graphDFS(v, next);
			}
		}
	}
}
class GraphVertex{
	boolean visited = false;
	int data = 0;
	ArrayList<Integer> adj = new ArrayList<Integer>();
}
