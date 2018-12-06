package basic06;

import java.util.ArrayList;
import java.util.Scanner;

public class Basic06_8 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int townNum = in.nextInt();
		int start = in.nextInt();
		
		ArrayList<Integer> myQueue = new ArrayList<Integer>();
		ArrayList<Integer> answer = new ArrayList<Integer>();
		
		Vertex8[] v = new Vertex8[townNum];
		for(int i=0; i<v.length; i++) {
			v[i] = new Vertex8();
		}
		
		myQueue.add(start);
		v[start-1].visited = true;
		
		while(myQueue.size() != 0) {
			int val = myQueue.remove(0);
			answer.add(val);
			int a = val * 2;
			int b = val / 3;
			
			if(a<=townNum) {
				if(v[a-1].visited == false) {
					myQueue.add(a);
					v[a-1].visited = true;
				}
			}
			if(b>0) {
				if(v[b-1].visited == false) {
					myQueue.add(b);
					v[b-1].visited = true;
				}
			}
		}
		
		
		System.out.println(townNum - answer.size());
	}
}
class Vertex8{
	boolean visited = false;
}
