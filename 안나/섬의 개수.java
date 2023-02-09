import java.io.*;
import java.util.*;

public class Main {
	static int w;
	static int h;
	static int[][] map;
	static int[] dr= {-1,-1,0,1,1,1,0,-1};
	static int[] dc= {0,1,1,1,0,-1,-1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w==0 && h==0) break;
			map = new int[h][w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			int count=0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if(map[i][j]==1) {
						bfs(i,j);
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}
	static void bfs(int r,int c) {
		Queue<int[]> q = new LinkedList<>();
		if(h==1) {
			return;
		}
		int[] n = {r,c};
		q.add(n);
		while(!q.isEmpty()) {
			n = q.poll();
			map[n[0]][n[1]] = 2;
			for (int i = 0; i < dr.length; i++) {
				int nr = n[0]+dr[i];
				int nc = n[1]+dc[i];

				boolean isRange = nr>=0 && nc>=0 && nr<h && nc<w;
				
				if(isRange && map[nr][nc]==1) {
					map[nr][nc] = 2;
					int[] new_n = {nr,nc};
					q.add(new_n);
				}
			}
		}
	}
}



