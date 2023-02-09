import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Q2667 {
    static final int[][] DIR = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    static final int HOUSE = 1;
    static final int NOTHING = 0;

    static int N;
    static int[][] map;
    static int count= 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i=0; i<N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j=0; j<N; j++) {
                map[i][j] = input[j] - '0';
            }
        }

        List<Integer> houses = new ArrayList<>();
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (map[i][j] == HOUSE) {
                    houses.add(bfs(i,j));
                    count++;
                }
            }
        }

        Collections.sort(houses);

        sb.append(count).append("\n");
        for (int house : houses) {
            sb.append(house).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static int bfs(int x, int y) {
        Deque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(x, y));
        int count = 1;
        map[x][y] = NOTHING;

        Pair now;
        int nextX;
        int nextY;

        while(!q.isEmpty()) {
            now = q.poll();

            for (int[] d : DIR) {
                nextX = now.x + d[0];
                nextY = now.y + d[1];
                if (isInRange(nextX, nextY) && isHouse(nextX, nextY)) {
                    map[nextX][nextY] = NOTHING;
                    q.add(new Pair(nextX, nextY));
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean isHouse(int x, int y) {
        return map[x][y] == HOUSE;
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
    }
}
