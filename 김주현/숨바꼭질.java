import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q1697 {
    static final int INF = Integer.MAX_VALUE;
    
    static int[] distances = new int[100_001];
    static int N;
    static int M;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Arrays.fill(distances, INF);
        if (N >= M) {
            sb.append(N-M);
        } else {
            bfs(N);
            sb.append(distances[M]);
        }
    
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static void bfs(int start) {
        Deque<Integer> q = new ArrayDeque<>();
        q.add(start);
        distances[start] = 0;
        
        int now;
        int next=0;
        boolean inRange;
        int size;
        int dist = 0;
        
        loop : while(!q.isEmpty()) {
            dist++;
            size = q.size();
            for (int i=0; i<size; i++) {
                now = q.poll();
    
                for (int j=0; j<3; j++) {
                    switch (j) {
                        case 0:
                            next = now -1;
                            break;
                        case 1:
                            next = now + 1;
                            break;
                        case 2:
                            next = 2 * now;
                    }
                    inRange = next >= 0 && next <= 100_000;
                    if (inRange && distances[next] == INF) {
                        distances[next] = dist;
                        if (next == M) {
                            break loop;
                        }
                        q.add(next);
                    }
                }
            }
        }
    }
}
