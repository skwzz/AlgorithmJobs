package basic06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Basic06_3 {
	public static final int MAX = 1000;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		ArrayList<Integer> box1 = new ArrayList<Integer>();
		ArrayList<Integer> box2 = new ArrayList<Integer>();
		
		int vertexCnt = Integer.parseInt(st.nextToken());
		int edgeCnt = Integer.parseInt(st.nextToken());
		int startNum = 0;
		
		boolean firstCheck = false;
		
		Vertex3[] v = new Vertex3[MAX];
		for(int i=0; i<v.length; i++) {
			v[i] = new Vertex3();
		}
		
		for(int i=0; i<edgeCnt; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			if(firstCheck == false) {
				startNum = n;
				firstCheck = true;
			}
			v[n].adj.add(m);
			v[m].adj.add(n);
			
			v[n].data = n;
			v[m].data = m;
			
		}
		for(int i=0; i<v.length; i++) {
			if(v[i].adj.size()!=0) {
				Collections.sort(v[i].adj);
			}
		}
		
		/*
		for(int i=0; i<v.length; i++) {
			if(v[i].adj.size()!=0) {
				System.out.print(i+" VERTEX : ");
				for(int j=0; j<v[i].adj.size(); j++) {
					System.out.print(v[i].adj.get(j)+" ");
				}
				System.out.println("");
			}
		}
		*/
		
		
		Basic06_3 test = new Basic06_3();
		test.recursiveDFS(v, startNum);
	}
	
	public void recursiveDFS(Vertex3[] v, int num) {
		v[num].visited = true;
		
		for(int i=0; i<v[num].adj.size(); i++) {
			int next = v[num].adj.get(i);
			if(v[next].visited == false) {
				recursiveDFS(v, next);
			}
		}
	}
}

class Vertex3{
	boolean visited = false;
	int data = 0;
	int box_flag = 1;
	ArrayList<Integer> adj = new ArrayList<Integer>();
}