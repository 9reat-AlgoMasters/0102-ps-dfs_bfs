import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class 바이러스 {
    static int N, M;
    static ArrayList<Integer>[] arr;
    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new ArrayList[N+1];
        for (int i = 1; i < N+1; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
        	//인접리스트로 그래프 구현
            String [] temp = br.readLine().split(" ");
            arr[Integer.parseInt(temp[0])].add(Integer.parseInt(temp[1]));
            arr[Integer.parseInt(temp[1])].add(Integer.parseInt(temp[0]));
        }

        search(1);
        System.out.println(set.size());
    }
    static void search(int index){
        int size = arr[index].size();
        for(int i = 0; i < size; i++){
        	//index에 연결된 컴퓨터들 감염
            int attacked = arr[index].get(i);
            if (attacked != 1 && !set.contains(attacked)) {
            	//1번 외의 컴퓨터 + 아직 감염 안된 컴퓨터를 set에 저장하고 재귀
                set.add(attacked);
                search(attacked);
            }
        }
    }
}
