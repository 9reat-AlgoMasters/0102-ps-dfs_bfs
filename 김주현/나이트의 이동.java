import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q7562 {
    static final int UNVISITED = 0;
    static final int START = -1;
    static final int[][] DIR = {{2,1}, {2,-1}, {-2,1}, {-2, -1}, {1,2}, {1,-2}, {-1,2}, {-1,-2}};

    static int N;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            st = new StringTokenizer(br.readLine());
            Pair start = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            map[start.x][start.y] = START;
            st = new StringTokenizer(br.readLine());
            Pair end = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            if (start.equals(end)) {
                sb.append(0).append("\n");
            } else {
                bfs(start, end);
                sb.append(map[end.x][end.y]-1).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void bfs(Pair start, Pair end) {

        Deque<Pair> q = new ArrayDeque<>();
        q.add(start);
        map[start.x][start.y] = 1;

        Pair now;
        int nextX;
        int nextY;

        while(!q.isEmpty()) {
            now = q.poll();

            for (int[] d : DIR) {
                nextX = now.x + d[0];
                nextY = now.y + d[1];

                if (isInRange(nextX, nextY) && isUnVisited(nextX, nextY)) {
                    map[nextX][nextY] = map[now.x][now.y] + 1;
                    if (nextX == end.x && nextY == end.y) {
                        return;
                    }
                    q.add(new Pair(nextX, nextY));
                }
            }
        }
    }

    public static boolean isUnVisited(int x, int y) {
        return map[x][y] == UNVISITED;
    }

    public static boolean isInRange(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            Pair o = (Pair) obj;
            return this.x == o.x && this.y == o.y;
        }
    }
}
