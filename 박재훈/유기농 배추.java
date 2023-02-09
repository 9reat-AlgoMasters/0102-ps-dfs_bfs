import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 유기농 배추 {
    static int T, M, N, K;
    static int[][] map;
    static Queue<Integer[]> queue = new LinkedList<>();
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String[] temp = br.readLine().split(" ");
            M = Integer.parseInt(temp[0]);
            N = Integer.parseInt(temp[1]);
            K = Integer.parseInt(temp[2]);
            map = new int[N][M];
            for (int i = 0; i < K; i++) {
                String[] points = br.readLine().split(" ");
                int r = Integer.parseInt(points[1]);
                int c = Integer.parseInt(points[0]);
                map[r][c] = 1;
            }

            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(map[i][j]==1) {
                        bfs(i, j);
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append('\n');
        }
        System.out.println(sb);
    }

    public static void bfs(int r, int c) {
        queue.add(new Integer[] {r,c});
        map[r][c] = 0;
        while(!queue.isEmpty()) {
            Integer[] tmp = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newR = tmp[0] + dr[i];
                int newC = tmp[1] + dc[i];

                if(newR >= 0 && newR < N && newC >= 0 && newC < M
                        && map[newR][newC] == 1) {
                    queue.add(new Integer[] {newR,newC});
                    map[newR][newC] = 0;
                }
            }
        }

    }

}
