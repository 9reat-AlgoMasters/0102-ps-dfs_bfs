import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Q2606 {
    static Graph g;
    static boolean[] visited;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        g = new Graph(N);
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            g.addEdge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        visited = new boolean[N+1];
        sb.append(bfs(1));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static int bfs(int start) {
        Deque<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;

        int now;
        int count = 0;

        while(!q.isEmpty()) {
            now = q.poll();

            for (int next : g.adjList[now]) {
                if (!visited[next]) {
                    count++;
                    q.add(next);
                    visited[next] = true;
                }
            }
        }

        return count;
    }

    static class Graph {
        List<Integer>[] adjList;

        public Graph(int size) {
            adjList = new ArrayList[size+1];
            for (int i=1; i<=size; i++) {
                adjList[i] = new ArrayList<>();
            }
        }

        public void addEdge(int v1, int v2) {
            adjList[v1].add(v2);
            adjList[v2].add(v1);
        }
    }
}
