import java.io.*;
import java.util.StringTokenizer;

public class Q1012 {
    static final int[][] DIR = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    static final int CABBAGE = 1;
    
    static int N;
    static int M;
    static int K;
    static int[][] map;
    static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            visited = new boolean[N][M];
            
            while (K-- > 0) {
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                map[r][c] = CABBAGE;
            }
            
            int count = 0;
            for (int i=0; i<N; i++) {
                for (int j=0; j<M; j++) {
                    if (!visited[i][j] && map[i][j] == CABBAGE) {
                        count++;
                        dfs(i, j);
                    }
                    
                }
            }
            sb.append(count).append("\n");
        }
    
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static void dfs(int x, int y) {
        if (visited[x][y]) return;
        
        visited[x][y] = true;
        for (int[] d : DIR) {
            int nextX = x + d[0];
            int nextY = y + d[1];
            boolean inRange = nextX >= 0 && nextY >= 0 && nextX < N && nextY < M;
            if (inRange && map[nextX][nextY] == CABBAGE) {
                dfs(nextX, nextY);
            }
        }
    }
}
