import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q7576 {
    static final int[][] DIR = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    static final int TOMATO = 1;
    static final int EMPTY = 0;
    static final int IMPOSSIBLE = -1;
    
    static int N;
    static int M;
    static int[][] map;
    static Deque<Pair> q = new ArrayDeque<>();
    static int max = 1;
    static int numOfEmpty = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == TOMATO) {
                    q.add(new Pair(i, j));
                } else if (map[i][j] == EMPTY) {
                    numOfEmpty++;
                }
            }
        }
        
        bfs();
        sb.append(numOfEmpty == 0 ? max-1 : IMPOSSIBLE);
    
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static void bfs() {
        if (numOfEmpty == 0) return;
        Pair now;
        int nextX;
        int nextY;
        boolean inRange;
        
        while (!q.isEmpty()) {
            now = q.poll();
            
            for (int[] d : DIR) {
                nextX = now.x + d[0];
                nextY = now.y + d[1];
                inRange = nextX >= 0 && nextY >= 0 && nextX < N && nextY < M;
                if (inRange && map[nextX][nextY] == EMPTY) {
                    numOfEmpty--;
                    map[nextX][nextY] = map[now.x][now.y] + 1;
                    max = Math.max(max, map[nextX][nextY]);
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
