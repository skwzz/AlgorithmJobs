package basic06.study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GraphBFSEx1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int vertexNum = in.nextInt();
		int edgeNum = in.nextInt();
		GraphVertex_BFS[] gv = new GraphVertex_BFS[vertexNum];
		//initialize
		for(int i=0; i<gv.length; i++) {
			gv[i] = new GraphVertex_BFS();
		}
		
		for(int i=0; i<edgeNum; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			
			gv[a-1].adjVertex.add(b);
			gv[b-1].adjVertex.add(a);
			
			gv[a-1].data = a;
			gv[b-1].data = b;
		}
		
		for(int i=0; i<gv.length; i++) {
			Collections.sort(gv[i].adjVertex);
		}
		
		for(int i=0; i<gv.length; i++) {
			System.out.print((i+1)+"Adjacent Vertex : ");
			for(int j=0; j<gv[i].adjVertex.size(); j++) {
				System.out.print(gv[i].adjVertex.get(j)+" ");
			}
			System.out.println();
		}
		System.out.println("**************************");
		ArrayList<Integer> myQueue = new ArrayList<Integer>();
		
		myQueue.add(1);
		gv[0].visited = true;
		
		for(; myQueue.size()!=0;) {
			int currentV = myQueue.remove(0) - 1;
			System.out.print(gv[currentV].data);
			for(int i=0; i<gv[currentV].adjVertex.size(); i++) {
				int adj = gv[currentV].adjVertex.get(i);
				if(gv[adj-1].visited == false) {
					gv[adj-1].visited = true;
					myQueue.add(adj);
				}
			}
		}
		
	}
}

class GraphVertex_BFS{
	boolean visited = false;
	int data = 0;
	ArrayList<Integer> adjVertex = new ArrayList<Integer>();
}