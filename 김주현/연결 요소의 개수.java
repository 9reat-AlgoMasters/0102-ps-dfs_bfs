import java.io.*;
import java.util.*;

public class Q11724 {
    static Graph g;
    static boolean[] visited;
    static int N;
    static int M;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        g = new Graph(N);
        visited = new boolean[N+1];
        
        while(M-- >0) {
            st = new StringTokenizer(br.readLine());
            g.addEdge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        
        int count = 0;
        for (int i=1; i<=N; i++) {
            if (!visited[i]) {
                bfs(i);
                count++;
            }
        }
        
        sb.append(count);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static void bfs(int start) {
        Deque<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;
        
        int now;
        while(!q.isEmpty()) {
            now = q.poll();
            
            for (int next : g.adjList[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
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
