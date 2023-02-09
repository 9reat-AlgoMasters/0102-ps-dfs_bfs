import java.io.*;
import java.util.*;

public class Q1260 {
    static final StringBuilder sb = new StringBuilder();
    static final boolean ASC = true;
    static final boolean DESC = false;
    
    static Graph g;
    static boolean[] visited;
    
    static int N;
    static int M;
    static int start;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        g = new Graph(N);
        visited = new boolean[N+1];
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            g.addEdge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        
        
        dfs(start);
        sb.append("\n");
        initVisited();
        bfs(start);
    
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    
    public static void dfs(int start) {
        g.sortEdges(DESC);
        Deque<Integer> stack = new ArrayDeque<>();
        stack.add(start);
        
        int now;
        
        while (!stack.isEmpty()) {
            now = stack.pollLast();
            if (visited[now]) {
                continue;
            }
            visited[now] = true;
            sb.append(now).append(" ");
    
            for (int next : g.adjList[now]) {
                if (!visited[next]) {
                    stack.add(next);
                }
            }
        }
    }
    
    public static void bfs(int start) {
        g.sortEdges(ASC);
        Deque<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;
        sb.append(start).append(" ");
        
        int now;
        
        while(!q.isEmpty()) {
            now = q.poll();
            
            for (int next : g.adjList[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    sb.append(next).append(" ");
                    q.add(next);
                }
            }
        }
    }
    
    public static void initVisited() {
        Arrays.fill(visited, false);
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
        
        public void sortEdges(boolean order) {
            if (order == ASC) {
                sortEdgesByAscending();
            } else {
                sortEdgesByDescending();
            }
        }
        
        private void sortEdgesByAscending() {
            for (int i=1; i<adjList.length; i++) {
                Collections.sort(adjList[i]);
            }
        }
        
        private void sortEdgesByDescending() {
            for (int i=1; i<adjList.length; i++) {
                adjList[i].sort(Collections.reverseOrder());
            }
        }
    }
}
