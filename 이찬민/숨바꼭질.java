import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    static int K;

    static int[] road;
    static boolean[] visited;
    static Queue<int[]> q;
    static final int M_NUM = 100000;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp =br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        K = Integer.parseInt(temp[1]);


        road = new int[M_NUM + 1];
        visited = new boolean[M_NUM + 1];
        
        //bfs
        System.out.println(bfs(N));
    }

    static int bfs(int x) {
        q = new LinkedList<>();
        int cnt = 0;
        // cnt값도 가지고 들어간다.
        q.offer(new int []{x, cnt});
        visited[x] = true;

        while (!q.isEmpty()) {
            int[] arr = q.poll();
            int node = arr[0];
            int count = arr[1];


            if (node == K) {
                return count;
            }
            // 3가지의 경우의 수 확인
            visitNode(node - 1, count + 1);
            visitNode(node + 1, count + 1);
            visitNode(node * 2, count + 1);
        }
        return 0;
    }

    // 큐에 방문한 노드 add
    static void visitNode(int k, int count) {
        if(check(k) && !visited[k]) {
            q.add(new int[]{k, count});
            visited[k] = true;
        }
    }

    // 배열의 크기를 넘어가는지 확인해주는 메소드
    static boolean check(int x) {
        if(x<0 || x > M_NUM){
            return false;
        }
        return true;
    }
}
