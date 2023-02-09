import java.util.*;
import java.io.*;

public class Main {
	static int M;
	static int N;
	static int[][] box; //창고
	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}}; //상 하 좌 우
	static int[] n; //탐색해갈 위치의 좌표를 담고 있는 배열 0은 r, 1은 c
	static Queue<int[]> q= new LinkedList<>(); //1인 위치를 넣기위해서 static 사용
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		box = new int[N][M];
		for (int i = 0; i <N ; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				box[i][j]=Integer.parseInt(st.nextToken());
				if(box[i][j]==1) {
					int[] one = {i,j};
					q.add(one); //box를 만들면서 값이 1이면 큐에 넣음
				}
			}
		}
		
			bfs();
	}
	static void bfs() {
		if(q.isEmpty()) { // 시작점이 없을때 => 2 2 /n 0 0 /n 0 0 
			System.out.println("-1");
			return;
		}
		
		while (!q.isEmpty()) {
			n = q.poll();
			
			if(box[n[0]][n[1]]==-1) {
				return;
			}
			
			for (int i = 0; i < dir.length; i++) {
				int nr = n[0]+dir[i][0];
				int nc = n[1]+dir[i][1];

				boolean isRange = nr>=0 && nc>=0 && nr<N && nc<M;
				
				//이동할 위치가 box 안에 있고 한번도 가지 않은 곳 즉, 값이 0이라면 
				if(isRange && box[nr][nc]==0) {
					box[nr][nc] = box[n[0]][n[1]]+1; //이전 위치까지 몇번이나 걸렸는지 확인해서 +1
					int[] new_n = {nr,nc};
					q.add(new_n); //그리고 이동할 위치를 큐에 넣음
				}
			}
		}
		
		//전부 다 익지 못한경우 즉 , 큐에 남아있는게 없는데 전체를 확인해서 0이 남아 있을때 
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(box[i][j]==0) {
					System.out.println("-1");
					return;
				}
			}
		}
		
		System.out.println(box[n[0]][n[1]]-1);
		return;
		
		
	}

}