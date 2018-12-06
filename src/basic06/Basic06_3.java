package basic06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Basic06_3 {
	public static ArrayList<Integer> box1 = new ArrayList<Integer>();
	public static ArrayList<Integer> box2 = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int vertexNum = in.nextInt();
		int edgeNum = in.nextInt();
		
		Vertex3[] v = new Vertex3[vertexNum+1];

		for(int i=1; i<v.length; i++) {
			v[i] = new Vertex3();
		}
		
		for(int i=0; i<edgeNum; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			
			v[a].adjVertex.add(b);
			v[b].adjVertex.add(a);
		}
		
		for(int i=1; i<v.length; i++) {
			Collections.sort(v[i].adjVertex);
		}
		
		boolean answer = recursiveDFS(v, 1);
		
		if(answer) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}
	
	public static boolean recursiveDFS(Vertex3[] v, int x) {
		v[x].visited = true;
		//System.out.print(x+" ");
		boolean flag = true;
		
		addBox(x, v[x].box_flag);
		if(isConnected(v, x, v[x].box_flag)==true) {
			return false;
		}
		for(int i=0; i<v[x].adjVertex.size(); i++) {
			int next = v[x].adjVertex.get(i);
			if(v[next].visited == false) {
				v[next].box_flag = v[x].box_flag == 1 ? 2 : 1;
				flag &= recursiveDFS(v, next);
			}
		}
		
		return flag;
	}
	
	public static boolean isConnected(Vertex3[] v, int x, int box_flag) {
		if(box_flag == 1) {
			if(box1.size()==1) {
				return false;
			}else {
				for(int i=0; i<v[x].adjVertex.size(); i++) {
					int checkNum = v[x].adjVertex.get(i);
					for(int j=0; j<box1.size()-1; j++) {
						if(checkNum == box1.get(j)) {
							return true;
						}
					}
				}
			}
		}
		
		if(box_flag == 2) {
			if(box2.size()==1) {
				return false;
			}else {
				for(int i=0; i<v[x].adjVertex.size(); i++) {
					int checkNum = v[x].adjVertex.get(i);
					for(int j=0; j<box2.size()-1; j++) {
						if(checkNum == box2.get(j)) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	public static void addBox(int x, int box_flag) {
		if(box_flag == 1) {
			box1.add(x);
		}else {
			box2.add(x);
		}
	}
}

class Vertex3{
	boolean visited = false;
	int box_flag = 1;
	ArrayList<Integer> adjVertex = new ArrayList<Integer>();
}