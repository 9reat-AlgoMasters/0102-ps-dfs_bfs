import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 단지번호붙이기
public class Main {
    static int N;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp =br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);

        map = new int[N+1][N+1];


        for (int i = 1; i < N + 1;  i++) {
            String[] line = br.readLine().split("");
            for (int j = 1; j < N + 1; j++) {
                map[i][j] = Integer.parseInt(line[j - 1]);
            }
        }


        int count = 0;
        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1 ; j++) {
                if (map[i][j] == 1) {
                    answer.add(bfs(i, j));
                    count++;
                }
            }
        }

        answer.sort(Comparator.naturalOrder());
        StringBuilder sb = new StringBuilder();
        for (int num : answer) {
            sb.append(num).append("\n");
        }

        System.out.println(count);
        System.out.println(sb.toString());
    }

    static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        map[x][y] = 0;
        int cnt = 0;
        while (!q.isEmpty()) {
            int[] params = q.poll();
            int a = params[0];
            int b = params[1];
            cnt++;

            // 4방향 탐색
            for(int i = 0;i < 4; i++){
                int nx = a + dx[i];
                int ny = b + dy[i];
                if(check(nx, ny) && map[nx][ny] == 1) {
                    map[nx][ny] = 0; // 큐에 넣을때 초기화!! => 안그러면 값이 중복해서 들어갈수 있음
                    q.add(new int[]{nx, ny});
                }
            }
        }

        return cnt;
    }

    // 배열의 크기를 넘어가는지 확인해주는 메소드
    static boolean check(int x, int y) {
        if((x<1 || x > N) || (y<1 || y > N)){
            return false;
        }
        return true;
    }
}
