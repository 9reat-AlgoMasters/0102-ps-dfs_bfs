import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFS와BFS {
    static int N, M, V;
    static TreeSet<Integer>[] arr;
    static boolean[] visited;
    static Queue<Integer> queue = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        V = Integer.parseInt(input[2]);
        visited = new boolean[N+1];
        //dfs시 연결된 정점 번호가 작은 순으로 저장되도록 TreeSet자료구조 사용 
        arr = new TreeSet[N+1];
        for (int i = 1; i < N+1; i++) {
            arr[i] = new TreeSet<>();
        }
        for (int i = 0; i < M; i++) {
            String[] temp = br.readLine().split(" ");
            arr[Integer.parseInt(temp[0])].add(Integer.parseInt(temp[1]));
            arr[Integer.parseInt(temp[1])].add(Integer.parseInt(temp[0]));
        }
        dfs(V);
        System.out.println(sb);

        bfs();
        System.out.println(sb);
    }

    static void dfs(int index){
    	//방문한 그래프는 반복 탐색 하지 않도록 방문 표시
        visited[index] = true;
        sb.append(index).append(" ");
        for(int val : arr[index]){
        	//index번 정점에 연결된 정점들 탐색
            if(!visited[val]){
                dfs(val);
            }
        }
    }

    static void bfs(){
    	//dfs 했던 결과 초기화
        sb.setLength(0);
        Arrays.fill(visited,false);
        //bfs 구현 위해 큐 사용, 시작 정점 정보 입력
        queue.add(V);
        visited[V] = true;
        sb.append(V).append(" ");
        while(!queue.isEmpty()){
            int index = queue.poll();
            for(int val : arr[index]) {
                if (!visited[val]) {
                    queue.add(val);
                    visited[val] = true;
                    sb.append(val).append(" ");
                }
            }
        }

    }
}
