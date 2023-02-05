import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q4963 {
    static final int[][] DIR = {{1,0}, {1, 1}, {0,1}, {-1, 1}, {-1,0}, {-1, -1}, {0,-1}, {1, -1}};
    static final int ISLAND = 1;
    
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        String input;
        while (!(input = br.readLine()).equals("0 0")) {
            st = new StringTokenizer(input);
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            
            map = new int[N][M];
            visited = new boolean[N][M];
            
            for (int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            int count = 0;
            
            for (int i=0; i<N; i++) {
                for (int j=0; j<M; j++) {
                    if (!visited[i][j] && map[i][j] == ISLAND) {
                        count++;
                        bfs(i, j);
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
    
    public static void bfs(int x, int y) {
        Deque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(x, y));
        visited[x][y] = true;
        
        Pair now;
        int nextX;
        int nextY;
        boolean inRange;
        
        while(!q.isEmpty()) {
            now = q.poll();
            
            for (int[] d : DIR) {
                nextX = now.x + d[0];
                nextY = now.y + d[1];
                inRange = nextX >= 0 && nextY >= 0 && nextX < N && nextY < M;
                if (inRange && !visited[nextX][nextY] && map[nextX][nextY] == ISLAND) {
                    visited[nextX][nextY] = true;
                    q.add(new Pair(nextX, nextY));
                }
            }
        }
    }
    
    static class Pair {
        int x;
        int y;
        
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
