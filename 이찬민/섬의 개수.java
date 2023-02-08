import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int w;
    static int h;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1, -1, -1, 1, 1};
    static int[] dy = {1, 0, -1, 0, -1, 1, 1, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String[] temp =br.readLine().split(" ");
            w = Integer.parseInt(temp[0]);
            h = Integer.parseInt(temp[1]);
            
            // 탈출
            if (w == 0 && h == 0) {
                return;
            }
            
            map = new int[h][w];

            for (int i = 0; i < h; i++) {
                temp =br.readLine().split(" ");
                for (int j = 0; j < temp.length; j++) {
                    map[i][j] = Integer.parseInt(temp[j]);
                }
            }
            
            // 섬 탐색 (탐색된 1은 dfs로 인해 전부 0으로 바뀌어 재탐색x)
            int cnt = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < temp.length; j++) {
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
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(check(nx, ny) && map[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
    }

    // 배열의 크기를 넘어가는지 확인해주는 메소드
    static boolean check(int x, int y) {
        if(x<0 || x >= h || y<0 || y >= w){
            return false;
        }
        return true;
    }
}
