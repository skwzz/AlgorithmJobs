package solution;

import java.util.ArrayList;
import java.util.Scanner;

public class Test4 {
	public static final int MAX = 1000;
	
	public int[] getTree(Tree4[] tree, int target) {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		Tree4 x = tree[target];
		while(x.parent!=-1) { //부모가 있을동안만
			temp.add(x.data);
			x = tree[x.parent];
		}
		temp.add(x.data);
		System.out.print(target+" : ");
		for(int i=0; i<temp.size(); i++) {
			System.out.print(temp.get(i)+" ");
		}
		
		int[] array = new int[temp.size()];
		for(int i=0; i<temp.size(); i++) {
			array[i] = temp.get(i).intValue();
		}
		return array;
	}
	
	public static void main(String[] args) {
		Test4 t4 = new Test4();
		Tree4[] tree = new Tree4[MAX];
		Scanner in = new Scanner(System.in);
		int nodeNum = in.nextInt();
		int target1 = in.nextInt();
		int target2 = in.nextInt();
		for(int i=0; i<nodeNum-1; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			if(tree[a]==null) {
				tree[a] = new Tree4();
			}
			if(tree[b]==null) {
				tree[b] = new Tree4();
			}
			tree[a].data = a;
			tree[a].child = b;
			
			tree[b].data = b;
			tree[b].parent = a;
		}
		/*
		for(int i=0; i<11; i++) {
			t4.getTree(tree, i);
			System.out.println();
		}
		 */
		
		int[] arr1 = t4.getTree(tree, target1);
		System.out.println();
		int[] arr2 = t4.getTree(tree, target2);
		boolean sf = false;
		int common = 0;
		for(int i=0; i<arr1.length; i++) {
			for(int j=0; j<arr2.length; j++) {
				if(arr1[i] == arr2[j]) {
					common = arr1[i];
					sf = true;
					break;
				}
			}
			if(sf) {break;}
		}
		System.out.println("common:"+common);
		int cnt1 = 0;
		int cnt2 = 0;
		for(int i=0; i<arr1.length; i++) {
			if(arr1[i] == common) {
				break;
			}else {
				cnt1++;
			}
		}
		for(int i=0; i<arr2.length; i++) {
			if(arr2[i] == common) {
				break;
			}else {
				cnt2++;
			}
		}
		
		System.out.println("");
		System.out.println("answer:"+(cnt1+cnt2));
	}
}

class Tree4{
	int child;
	int data;
	int parent;
	
	public Tree4() {
		this.child = 0;
		this.data = 0;
		this.parent = -1;
	}
}
