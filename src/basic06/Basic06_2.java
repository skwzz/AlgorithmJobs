package basic06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Basic06_2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int vertexNum = in.nextInt();
		int edgeNum = in.nextInt();
		Vertex2[] v = new Vertex2[vertexNum];
		
		//init start
		for(int i=0; i<v.length; i++) {
			v[i] = new Vertex2();
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
		
		
		boolean answer = recursiveDFS(v, 0, 1);
		if(answer) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}
	
	public static boolean recursiveDFS(Vertex2[] v, int x, int color) {
		return true;
		
		
	}
}

class Vertex2{
	int color = 0;  // 0 : no visited
					// 1 : color 1
					// 2 : color 2

	ArrayList<Integer> adjVertex = new ArrayList<Integer>();
}
