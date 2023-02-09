import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class 단지번호붙이기 {
    static int N, cnt, cnt2;
    static int[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 1) {
                    cnt = 0;
                    dfs(i,j);
                    list.add(cnt);
                    cnt2++;
                }
            }
        }
        System.out.println(cnt2);
        Collections.sort(list);
        for (int i : list) {
            System.out.println(i);
        }
    }
    public static void dfs(int r, int c) {
        cnt++;
        map[r][c] = 0;
        for (int i = 0; i < 4; i++) {
            int newR = r+ dr[i];
            int newC = c+ dc[i];
            if(newR >= 0 && newR < N && newC >= 0 && newC < N
                    && map[newR][newC] == 1) {
                dfs(newR,newC);
            }
        }
    }
}
