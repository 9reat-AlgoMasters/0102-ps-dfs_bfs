import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q2178 {
    static final int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    static final int WALL = 0;
    
    static int[][] map;
    static boolean[][] visited;
    static int N;
    static int M;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        
        for (int i=0; i<N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j=0; j<M; j++) {
                map[i][j] = input[j] - '0';
            }
        }
        bfs(0,0);
//        printMap();
        sb.append(map[N-1][M-1]);
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static void bfs(int startX, int startY) {
        Deque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(startX, startY));
        visited[startX][startY] = true;
        
        Pair now;
        int nextX;
        int nextY;
        boolean inRange;
        
        while (!q.isEmpty()) {
            now = q.poll();
            
            for (int[] d : dir) {
                nextX = now.x + d[0];
                nextY = now.y + d[1];
                inRange = nextX >= 0 && nextY >= 0 && nextX < N && nextY < M;
                if (inRange && !visited[nextX][nextY] && map[nextX][nextY] != WALL) {
                    visited[nextX][nextY] = true;
                    map[nextX][nextY] = map[now.x][now.y] + 1;
                    if (nextX == N-1 && nextY == M-1) {
                        return;
                    }
                    q.add(new Pair(nextX, nextY));
                }
            }
        }
    }
    
    public static void printMap() {
        for (int i=0; i<N; i++) {
            for (int j=0; j<M ;j++) {
                System.out.printf("%d ", map[i][j]);
            }
            System.out.println();
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
