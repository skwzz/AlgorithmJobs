package basic06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Basic06_7 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] checker = new int[99999]; // 0:미방문,   1:방문
		// MUL : 현재값에 2곱함
		// DIV : 현재값에 나누기 3. 소수점 이하는 모두 버림
		// N이 주어질 때, 계산기를 작동시켜 숫자 N을 만들기 위해 최소 몇 번 버튼을 눌러야 하는지 
		int[] arr = new int[3];
		arr[0] = (n*3);
		arr[1] = (n*3)+1;
		arr[2] = (n*3)+2;
		
		int cnt = 0;
		int num = 1;
		
		ArrayList<Integer> myQueue = new ArrayList<Integer>();
		myQueue.add(num);
		checker[num] = 1;
		
		while(myQueue.size()!=0) {
			int temp = myQueue.remove(0);
			int nextPoint = checker[temp];
			if(temp == n) {
				System.out.println(checker[temp]-1);
				break;
			}
			int a = temp*2;
			int b = temp/3;
			
			if(checker[a]==0) {
				myQueue.add(a);
				checker[a] = nextPoint+1;
			}
			
			if(checker[b]==0) {
				myQueue.add(b);
				checker[b] = nextPoint+1;
			}
			
			cnt+=1;
		}
	}
}
