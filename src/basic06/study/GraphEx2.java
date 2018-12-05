package basic06.study;

import java.util.ArrayList;
import java.util.Scanner;

public class GraphEx2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int vertexNum = in.nextInt();
		int edgeNum = in.nextInt();
		VertexEx2[] ve = new VertexEx2[vertexNum];
		for(int i=0; i<ve.length; i++) {
			ve[i] = new VertexEx2();
		}
		
		for(int i=0; i<edgeNum; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			ve[a-1].adjVertex.add(b);
			ve[b-1].adjVertex.add(a);
		}
		
		for(int i=0; i<ve.length; i++) {
			
			System.out.print((i+1)+"의 인접한 Vertex : ");
			for(int j=0; j<ve[i].adjVertex.size(); j++) {
				System.out.print(ve[i].adjVertex.get(j)+" ");
			}
			System.out.println();
		}
	}
}
class VertexEx2{
	ArrayList<Integer> adjVertex = new ArrayList<Integer>();
}