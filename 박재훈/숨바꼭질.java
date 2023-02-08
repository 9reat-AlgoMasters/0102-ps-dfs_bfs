import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 숨바꼭질 {
	static int N, K;
	static int[] visited = new int[100001];
	static Queue<Integer> queue = new LinkedList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		if(N==K) {
			System.out.println(0);
			System.exit(0);
		}
		bfs(N);

	}
	public static void bfs(int n) {
		queue.add(n);
		//시작점 1로 표시
		visited[n] = 1;
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			int cnt = visited[temp];
			//큐에서 뽑은 위치에서 이동할수 있는 위치들의 visited값 설정
			//뽑은 위치의 값 + 1(초)
			if(temp > 0 && visited[temp-1] == 0) {
				queue.add(temp - 1);
				visited[temp - 1] = cnt+1;
			}
			if(temp < 100000 && visited[temp+1] == 0) {
				queue.add(temp + 1);
				visited[temp + 1] = cnt+1;
			}
			if(temp < 50001 && visited[temp*2] == 0) {
				queue.add(temp * 2);
				visited[temp * 2] = cnt+1;
			}
			//K의 visited값이 채워졌다면 출력하고 메소드 종료
			//시작점이 1에서 시작해서 1 빼줘야 원하는 결과(소요시간) 출력
			if(visited[K] != 0) {
				System.out.println(visited[K]-1);
				return;
			}
		}
	}
}
