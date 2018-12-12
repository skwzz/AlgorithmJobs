package solution;

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
		boolean flag = true;
		addBox(x, v[x].box_flag);
		
		if(isConnected(v[x], v[x].box_flag, x)==true) {
			return false;
		}
		
		for(int i=0; i<v[x].adjVertex.size(); i++) {
			int next = v[x].adjVertex.get(i);
			if(v[next].visited == false) {
				v[next].box_flag = (v[x].box_flag == 1 ? 2 : 1) ;
				flag &= recursiveDFS(v, next);
			}
		}
		
		return flag;
	}
	
	public static boolean isConnected(Vertex3 v, int box_flag, int data) {
		ArrayList<Integer> temp;
		if(box_flag == 1) {
			temp = box1;
		}else {
			temp = box2;
		}
		
		for(int i=0; i<temp.size(); i++) {
			int check = temp.get(i);
			
			for(int j=0; j<v.adjVertex.size(); j++) {
				if(check == v.adjVertex.get(j)) {
					return true;
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
	
	public static boolean isConnected() {
		return true;
	}
}

class Vertex3{
	boolean visited = false;
	int box_flag = 1;
	ArrayList<Integer> adjVertex = new ArrayList<Integer>();
}