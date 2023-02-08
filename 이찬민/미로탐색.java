import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 미로탐색
public class Main {
    static int N;
    static int M;
    static int[][] maze;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp =br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);

        maze = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for (int i = 1; i < N + 1; i++) {
            String[] line = br.readLine().split("");
            for (int j = 1; j < M + 1; j++) {
                maze[i][j] = Integer.parseInt(line[j - 1]);
            }
        }

        System.out.println(bfs(1, 1, 1));
    }

    //최단거리 BFS(가장 먼저 도착하는것이 가장 빠른 것)
    static int bfs(int x, int y, int cnt) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y, cnt});
        visited[x][y] = true;
        while (!q.isEmpty()) {
            int[] params = q.poll();
            int a = params[0];
            int b = params[1];
            int count = params[2];
            
            if (a == N && b == M) {
                return count;
            }
            
            // 4방향 탐색
            for(int i = 0;i < 4; i++){
                int nx = a + dx[i];
                int ny = b + dy[i];
                if(check(nx, ny) && !visited[nx][ny]) {
                    if (maze[nx][ny] == 1){
                        q.add(new int[]{nx, ny, count+1});
                        visited[nx][ny] = true;
                    }

                }
            }
        }

        return 0;
    }

    // 배열의 크기를 넘어가는지 확인해주는 메소드
    static boolean check(int x, int y) {
        if((x<1 || x > N) || (y<1 || y > M)){
            return false;
        }
        return true;
    }
}
