import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[][] board;
    static int[] start;
    static int[] end;
    static int l;
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int k = 0; k < T; k++) {
            l = Integer.parseInt(br.readLine());
            board = new int[l][l];

            String[] temp = br.readLine().split(" ");
            start = new int[] {Integer.parseInt(temp[0]), Integer.parseInt(temp[1])};
            temp = br.readLine().split(" ");
            end = new int[] {Integer.parseInt(temp[0]), Integer.parseInt(temp[1])};

            System.out.println(bfs(start[0], start[1], 0));
        }


    }

    static int bfs(int a, int b, int cnt){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{a, b, cnt});
        board[a][b] = 1;
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int x = pos[0];
            int y = pos[1];
            int count = pos[2];
            if (x == end[0] && y == end[1]) {
                return count;
            }
            for(int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(check(nx, ny) && board[nx][ny] == 0) {
                    q.add(new int[]{nx, ny, count + 1});
                    board[nx][ny] = 1;
                }
            }

        }
        return 0;
    }

    // 배열의 크기를 넘어가는지 확인해주는 메소드
    static boolean check(int x, int y) {
        if((x<0 || x >= l) || (y<0 || y >= l)){
            return false;
        }
        return true;
    }
}
