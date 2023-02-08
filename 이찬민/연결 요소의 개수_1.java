import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    static int N;
    static int M;
    static List<Integer>[] graph;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp =br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);

        graph = new LinkedList[N + 1];
        visited = new boolean[N + 1];
        for(int i = 0; i < N + 1; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int i = 0; i < M; i++) {

            temp = br.readLine().split(" ");
            int x = Integer.parseInt(temp[0]);
            int y = Integer.parseInt(temp[1]);
            graph[x].add(y);
            graph[y].add(x);
        }

        int cnt = 0;
        for (int i = 1; i < N+1; i++) {
            if(!visited[i]) {
                dfs(i);
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static int dfs(int a) {
        List<Integer> conn = graph[a];
        for (int i = 0; i< conn.size(); i++) {
            if (!visited[conn.get(i)]) {
                visited[conn.get(i)] = true;
                dfs(conn.get(i));
            }
        }

        return 0;
    }
}
