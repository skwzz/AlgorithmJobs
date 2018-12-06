package basic06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Basic06_1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int vertexNum = in.nextInt();
		int edgeNum = in.nextInt();
		Vertex1[] v = new Vertex1[vertexNum];
		
		//init start
		for(int i=0; i<v.length; i++) {
			v[i] = new Vertex1();
		}
		
		for(int i=0; i<edgeNum; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			
			v[a].adjVertex.add(b);
			v[b].adjVertex.add(a);
		}
		for(int i=0; i<v.length; i++) {
			Collections.sort(v[i].adjVertex);
		}
		//init end
		
		/*
		for(int i=0; i<v.length; i++) {
			System.out.print(i+" adjacent vertex : ");
			for(int j=0; j<v[i].adjVertex.size(); j++) {
				System.out.print(v[i].adjVertex.get(j));
			}
			System.out.println();
		}
		*/
		
		//DFS 
		recursiveDFS(v, 0);
		System.out.println("");
		
		//init visit for BFS
		for(int i=0; i<v.length; i++) {
			v[i].visit = false;
		}
		
		ArrayList<Integer> myQueue = new ArrayList<Integer>();
		
		myQueue.add(0);
		v[0].visit = true;
		
		while(myQueue.size() != 0) {
			int current = myQueue.remove(0);
			System.out.print(current+" ");
			for(int i=0; i<v[current].adjVertex.size(); i++) {
				int next = v[current].adjVertex.get(i);
				if(v[next].visit==false) {
					v[next].visit = true;
					myQueue.add(next);
				}
			}
		}
		
	}
	
	
	
	
	public static void recursiveDFS(Vertex1[] v, int x) {
		v[x].visit = true;
		System.out.print(x+" ");
		
		for(int i=0; i<v[x].adjVertex.size(); i++) {
			int next = v[x].adjVertex.get(i);
			if(v[next].visit == false) {
				recursiveDFS(v, next);
			}
		}
	}
}

class Vertex1{
	boolean visit = false;
	ArrayList<Integer> adjVertex = new ArrayList<Integer>();
}
