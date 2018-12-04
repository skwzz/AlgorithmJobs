package basic05;

import java.util.ArrayList;
import java.util.Scanner;

public class Test2 {
	public static final int MAX = 1000;
	public int[] getParents(Tree2[] tree, int x) {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		while(tree[x].getParentsLength() != 0) {
			temp.add(tree[x].getParentNode());
			x = tree[x].getParentNode();
		}
		int[] array = new int[temp.size()];
		for(int i=0; i<temp.size(); i++) {
			array[i] = temp.get(i).intValue();
		}
		return array;
	}
	public static void main(String[] args) {
		Test2 t2 = new Test2();
		Scanner in = new Scanner(System.in);
		int nodeCnt = in.nextInt();
		int a = in.nextInt();
		int b = in.nextInt();
		Tree2[] tree = new Tree2[MAX];
		for(int i=0; i<nodeCnt-1; i++) {
			int x, y;
			x = in.nextInt();
			y = in.nextInt();
			
			if(tree[x] == null) {
				tree[x] = new Tree2();
			}
			if(tree[y] == null) {
				tree[y] = new Tree2();
			}
			tree[x].addNodes(y);
			tree[y].addParents(x);
		}
		int[] temp1 = t2.getParents(tree, a);
		int[] temp2 = t2.getParents(tree, b);
		int x = temp1.length;
		int y = temp2.length; 
		
		boolean cf = false;
		for(int i=0; i<temp2.length; i++) {
			for(int j=0; j<temp1.length; j++) {
				if(temp2[i]==temp1[j]) {
					System.out.println(temp2[i]);
					cf = true;
					break;
				}
			}
			if(cf) {
				break;
			}
		}
		
	}
}
class Tree2{
	ArrayList<Integer> parents = new ArrayList<Integer>();
	ArrayList<Integer> nodes = new ArrayList<Integer>();
	
	public void addNodes(int x) {
		nodes.add(x);
	}
	public void addParents(int x) {
		parents.add(x);
	}
	public int getParentsLength() {
		return parents.size();
	}
	public int getParentNode() {
		return parents.get(0);
	}
}