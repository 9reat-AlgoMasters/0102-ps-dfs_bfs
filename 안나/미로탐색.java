import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[][] map;
	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}}; //상 하 좌 우
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j]=str.charAt(j)-'0';
			}
			// String으로 받아서 정수형 배열 만들기
//			map[i]=Stream.of(str.split("")).mapToInt(Integer::parseInt).toArray();
		}
	
		
		bfs(0,0);
	}
	static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		int[] n = {r,c};
		q.add(n);
		
		while(!q.isEmpty()) {
			n = q.poll();
			if(n[0]==N-1 && n[1]==M-1) {
				System.out.println(map[n[0]][n[1]]);
				return;
			}
			for (int i = 0; i < dir.length; i++) {
				int nr = n[0] + dir[i][0];
				int nc = n[1] + dir[i][1];
				
				boolean isRange = nc>=0 && nr>=0 && nr<N && nc<M;
				if(isRange && map[nr][nc]==1) {
					map[nr][nc]=map[n[0]][n[1]]+1;
					int[] new_n = {nr,nc};
					q.add(new_n);
				}
			}
			
		}
	}

}



