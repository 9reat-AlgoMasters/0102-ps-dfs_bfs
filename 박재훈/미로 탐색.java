import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 미로 탐색 {
    static int N, M;
    static int[][] maze, visited;
    static int[] dr = {-1, 0, 1 ,0};
    static int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        maze = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                maze[i][j] = Integer.parseInt(temp[j]);
            }
        }
        //최단거리를 구하는 경우 dfs보다 bfs가 효율적
        Queue<Integer[]> q = new LinkedList<>();
        //시작점 저장
        q.add(new Integer[]{0, 0});
        visited[0][0] = 1;
        while (!q.isEmpty()){
            Integer[] temp = q.poll();
            for (int i = 0; i < 4; i++) {
                int newN = temp[0] + dr[i];
                int newM = temp[1] + dc[i];
                if(newN >= 0 && newN < N && newM >= 0 && newM < M &&
                        maze[newN][newM] != 0 && visited[newN][newM] != 1){
                    //미로 범위 내에 있고 방문 안한 점이면 시작점에서의 거리 표시, 큐에 저장
                    maze[newN][newM] = maze[temp[0]][temp[1]] + 1;
                    q.add(new Integer[]{newN, newM});
                    visited[newN][newM] = 1;
                }
            }
        }

        System.out.println(maze[N-1][M-1]);
    }

}
