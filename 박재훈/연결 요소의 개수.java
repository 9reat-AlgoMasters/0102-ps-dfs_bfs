import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 연결 요소의 개수 {
    static int N, M, cnt;
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        visited = new boolean[N+1];
        arr = new ArrayList[N+1];
        for (int i = 1; i < N+1; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            String[] temp = br.readLine().split(" ");
            arr[Integer.parseInt(temp[0])].add(Integer.parseInt(temp[1]));
            arr[Integer.parseInt(temp[1])].add(Integer.parseInt(temp[0]));
        }

        for (int i = 1; i < N+1; i++) {
            if(!visited[i]){
                bfs(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static void bfs(int index) {
        queue.add(index);
        visited[index] = true;
        while (!queue.isEmpty()){
            int val = queue.poll();
            int size = arr[val].size();
            for (int i = 0; i < size; i++) {
                int val2 = arr[val].get(i);
                if(!visited[val2]){
                    queue.add(val2);
                    visited[val2] = true;
                }
            }
        }
    }

}
