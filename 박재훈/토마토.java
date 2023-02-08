import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 토마토 {
	static int M, N, cnt, ans;
	static int[][] box;
	static Queue<int[]> queue = new LinkedList<>();
	static ArrayList<int[]> done = new ArrayList<>();
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		M = Integer.parseInt(input[0]);
		N = Integer.parseInt(input[1]);
		box = new int[N][M];
		for (int i = 0; i < N; i++) {
			String[] temp = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				int v = Integer.parseInt(temp[j]);
				if(v == 0) {
					//안 익은 토마토 수
					cnt++;
				}else if(v == 1) {
					//익은 토마토 위치 저장
					done.add(new int[] {i, j});
				}
				box[i][j] = v;
			}
		}
		
		if(cnt == 0) {
			System.out.println(0);
		}
		
		else {
			bfs();
			if(cnt != 0) {
				System.out.println(-1);
			}else {
				System.out.println(ans);
			}
		}
	}
	public static void bfs() {
		for (int i = 0; i < done.size(); i++) {
			//초기부터 익은 토마토 큐에 넣기
			queue.add(done.get(i));
		}
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int r = temp[0];
			int c = temp[1];
			for (int i = 0; i < 4; i++) {
				//4방 탐색으로 익은 토마토 주변 안 익은 토마토 탐색
				int newR = r + dr[i];
				int newC = c + dc[i];
				if(newR >= 0 && newR < N && newC >= 0 && newC < M) {
					if(box[newR][newC] == 0) {
						//익은 토마토 위치의 배열값에 1 더한 값을 넣기
						//배열의 값 == 몇째날에 익었는가
						box[newR][newC] = box[r][c] + 1;
						cnt--;
						queue.add(new int[] {newR, newC});
					}
				}
				if(cnt == 0) {
					//안 익은 토마토가 더 없다면 정답값저장
					//처음 1일부터 시작했으므로 기간을 구하기위해 1을 빼줌
					ans = box[newR][newC] - 1;
					return;
				}
			}
		}
	}
}
