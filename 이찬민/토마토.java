import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    static int M;
    static int[][] board;
    static Queue<int[]> q;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp =br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);

        board = new int[M][N];

        for (int i = 0; i < M; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < s.length; j++) {
                board[i][j] = Integer.parseInt(s[j]);
            }
        }

        // 모든 1을 전부 q에 넣어줌
        q = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(board[i][j] == 1) {
                    q.add(new int[]{i, j, 0});
                }
            }
        }

        int ans = bfs();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(board[i][j] == 0) {
                    ans= -1;
                }
            }
        }

        System.out.println(ans);
    }

    //탐색하는데 cnt값도 가지고 가야함(전부 물들이는데 걸린시간)
    static int bfs() {
        int ans = 0;
        while(!q.isEmpty()){
            int[] temp = q.poll();
            int a = temp[0];
            int b = temp[1];
            int cnt = temp[2];

            ans = cnt;
            
            for(int i = 0; i < 4;i++) {
                int nx = a + dx[i];
                int ny = b + dy[i];
                
                // -1 인경우와 1인 경우 스킵, 0인경우 큐에 넣은후 1로
                if (check(nx, ny)) {
                    // 명시적으로 표현해줌(이 if문은 삭제 가능)
                    if (board[nx][ny] == -1 || board[nx][ny]== 1) {
                        continue;
                    }
                    if(board[nx][ny] == 0){
                        board[nx][ny] = 1;
                        q.add(new int[]{nx, ny, cnt + 1});
                    }
                }
            }
        }
        return ans;
    }

    static boolean check(int x, int y) {
        if((x<0 || x >= M) || (y<0 || y >= N)){
            return false;
        }
        return true;
    }
}
