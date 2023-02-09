// 참고 https://smartpro.tistory.com/18
import java.util.*;

public class Main {
	static int N;
	static int K;
	static int result=100001;
	static int[] visited=new int[100001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N= sc.nextInt();
		K= sc.nextInt();

		// 처음 시작 지점을 0로 (다음에 도착할 위치는 +1)로 둔다.
		// visited는 즉 몇번을 거쳐서 여기까지 왔는가를 의미한다.
		// 만약 최소 시간을 가지는 경로를 알고 싶다면 1을 두고 마지막 결과를 출력할때 -1을 해주어야한다.
		visited[N]=0; 
		search(N);
	}

	static void search(int x) {
		Queue<Integer> q = new LinkedList<>();
		q.add(x); //시작점 큐에 넣기
		 while(!q.isEmpty()) { 
			 int n = q.poll();
			 
			 // 동생의 위치에 도착하면 
			 if(n == K) {
				 System.out.println(visited[n]); //N에서 n==K의 자리까지 visited[n]의 값만큼 거쳐서 옴
				 return;
			 }
			 //n-1일 한 자리가 0보다 크고 방문하지 않았을때 
			 if(n-1 >=0 && visited[n-1]==0) {
				 visited[n-1]= visited[n]+1; //옮겨갈 자리에 지금 현재 자리까지의 이동횟수 +1을 넣어준다.
				 q.add(n-1);
			 }
			//n+1일때 범위를 넘어가지 않고 방문하지 않았을때 
			 if(n+1 <= 100000 && visited[n+1]==0) {
				 visited[n+1]= visited[n]+1;
				 q.add(n+1);
			 }
			 //n*1일때 범위를 넘어가지 않고 방문하지 않았을때 
			 if(n*2 <= 100000 &&visited[n*2]==0) {
				 visited[n*2]= visited[n]+1;
				 q.add(n*2);
			 }
			 
		 }
		 return;
		
	}
}