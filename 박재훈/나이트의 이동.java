import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 나이트의 이동 {
	static int T, l;
	static int[][] board;
	static Queue<int[]> queue;
	static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] dy = {1, 2, 2, 1, -1, -2 ,-2 ,-1};
  
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			queue = new LinkedList<>();
			l = Integer.parseInt(br.readLine());
			board = new int[l][l];
			int sx, sy, ex, ey;
			String[] temp = br.readLine().split(" ");
			sx = Integer.parseInt(temp[0]);
			sy = Integer.parseInt(temp[1]);
			
			temp = br.readLine().split(" ");
			ex = Integer.parseInt(temp[0]);
			ey = Integer.parseInt(temp[1]);
			
			bfs(sx, sy, ex, ey);
			System.out.println(board[ex][ey] - 1);
		}
	}
	public static void bfs(int sx, int sy, int ex, int ey) {
		queue.add(new int[] {sx, sy});
		board[sx][sy] = 1;
		if(sx == ex && sy == ey) {
			return;
		}
    
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
      
			for (int i = 0; i < 8; i++) {
				int nx = temp[0] + dx[i];
				int ny = temp[1] + dy[i];
        
				if(nx >= 0 && nx < l && ny >= 0 && ny < l 
						&& board[nx][ny] == 0){
					queue.add(new int[] {nx, ny});
					board[nx][ny] = board[temp[0]][temp[1]] + 1;
          
					if(nx == ex && ny == ey) {
						return;
					}
				}
			}
		}
	}
}
