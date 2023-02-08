import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 유기농 배추
public class Main {
    static int M;
    static int N;
    static int K;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            String[] temp =br.readLine().split(" ");
            M = Integer.parseInt(temp[0]);
            N = Integer.parseInt(temp[1]);
            K = Integer.parseInt(temp[2]);
            
            map = new int[M][N];

            for (int j = 0; j < K; j++) {
                temp =br.readLine().split(" ");
                int a = Integer.parseInt(temp[0]);
                int b = Integer.parseInt(temp[1]);
                map[a][b] = 1;

            }

            // 탐색 (탐색된 1은 dfs로 인해 전부 0으로 바뀌어 재탐색x)
            int cnt = 0;
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if(map[i][j] == 1) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
        }
    }
    
    // 8방향 탐색
    static void dfs(int x, int y) {
        // 방문한 경우 0으로 바꿔줌
        map[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(check(nx, ny) && map[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
    }

    // 배열의 크기를 넘어가는지 확인해주는 메소드
    static boolean check(int x, int y) {
        if(x<0 || x >= M || y<0 || y >= N){
            return false;
        }
        return true;
    }
}
