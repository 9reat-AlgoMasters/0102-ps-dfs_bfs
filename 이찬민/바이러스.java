import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    static int M;
    static int[][] connections;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        connections = new int[N+1][N+1];
        visited = new boolean[N+1];
        for (int i = 1; i <= M; i++) {
            String[] temp = br.readLine().split(" ");
            int x = Integer.parseInt(temp[0]);
            int y = Integer.parseInt(temp[1]);
           connections[x][y] = connections[y][x] = 1;
        }
        System.out.println(bfs(1));
    }

    static int bfs(int x) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        visited[x] = true;

        int cnt = 0;
        while (!q.isEmpty()) {
            int node = q.poll();

            for (int i = 1; i <= N ; i++) {
                if(!visited[i] && connections[node][i] == 1) {
                    q.add(i);
                    visited[i] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
