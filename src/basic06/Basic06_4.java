package basic06;

import java.util.ArrayList;
import java.util.Scanner;

public class Basic06_4 {
	public static ArrayList<Integer> al = new ArrayList<Integer>();
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int vertexNum = in.nextInt();
		int edgeNum = in.nextInt();
		
		Vertex4[] v = new Vertex4[vertexNum];
		for(int i=0; i<v.length; i++) {
			v[i] = new Vertex4();
		}
		
		for(int i=0; i<edgeNum; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			
			v[a-1].adjVertex.add(b);
			v[b-1].adjVertex.add(a);
			
			v[a-1].data = a;
			v[b-1].data = b;
		}
		
		recursiveDFS(v, 0);
		System.out.println(al.size()-1);
	}
	
	public static void recursiveDFS(Vertex4[] v, int x) {
		al.add(v[x].data);
		v[x].visited = true;
		
		for(int i=0; i<v[x].adjVertex.size(); i++) {
			int next = v[x].adjVertex.get(i)-1;
			if(v[next].visited == false) {
				recursiveDFS(v, next);
			}
		}
	}
}

class Vertex4{
	boolean visited = false;
	int data = 0;
	ArrayList<Integer> adjVertex = new ArrayList<Integer>();
}
