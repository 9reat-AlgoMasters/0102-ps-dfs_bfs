import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 섬의 개수 {
    static int[][] map;
    static int w, h, cnt;
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1 ,-1 ,-1};
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            cnt = 0;
            String[] input = br.readLine().split(" ");
            w = Integer.parseInt(input[0]);
            h = Integer.parseInt(input[1]);
            if(w==0&&h==0) {
                System.out.println(sb);
                System.exit(0);
            }
            map = new int[h][w];
            for (int i = 0; i < h; i++) {
                String[] temp = br.readLine().split(" ");
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(temp[j]);
                }
            }
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    //섬의 시작점(배열값 1)을 찾는다
                    if(map[i][j] != 0) {
                        dfs(i,j);
                        //섬 개수 ++
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append('\n');
        }
    }
    static void dfs(int r, int c) {
        //방문한 위치의 배열 값을 0으로 하면 이후에 방문X
        map[r][c] = 0;
        for (int i = 0; i < 8; i++) {
            //8방 탐색, 범위와 배열 값 확인후 재귀
            int newR = r + dr[i];
            int newC = c + dc[i];
            if(newR >= 0 && newR < h && newC >= 0 && newC < w && map[newR][newC] == 1) {
                dfs(newR, newC);
            }
        }
    }
}

