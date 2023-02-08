import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    static int M;
    static int V;

    static int[][] connections;
    static boolean[] visited;
    static StringBuilder stringBuilder;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp =br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);
        V = Integer.parseInt(temp[2]);
        stringBuilder = new StringBuilder();

        connections = new int[N+1][N+1];
        visited = new boolean[N+1];
        for (int i = 0; i < M; i++) {
            String[] line =br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            connections[a][b] = connections[b][a] = 1;
        }


        //dfs
        visited[V] = true;
        dfs(V);
        System.out.println(stringBuilder);

        //방문배열 초기화
        for (int i = 1; i < N + 1; i++) {
            visited[i] = false;
        }

        //bfs
        System.out.println(bfs(V));
    }

    static void dfs(int x) {
        stringBuilder.append(x + " ");
        for (int i = 1; i < N + 1; i++) {
            if(!visited[i] && connections[x][i] == 1) {
                visited[i] = true;
                dfs(i);
            }
        }

    }

    static StringBuilder bfs(int x) {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        visited[x] = true;
        sb.append(x + " ");

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int i = 1; i < N + 1; i++) {
                if(!visited[i] && connections[node][i] == 1) {
                    q.add(i);
                    sb.append(i + " ");
                    visited[i] = true;

                }
            }
        }
        return sb;
    }
}
