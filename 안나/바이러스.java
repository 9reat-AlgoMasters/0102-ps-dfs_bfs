import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    static HashSet<Integer> visited = new HashSet<>();
    static ArrayList<Integer> []connect;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int com = sc.nextInt(); //컴퓨터의 수
        int connectNum = sc.nextInt(); //연결의수

        connect = new ArrayList [com+1];
        for (int i = 0; i <=com; i++) {
            connect[i] = new ArrayList<>();
        }

        //무방향으로
        for (int i = 0; i < connectNum; i++) {
            int c1 = sc.nextInt();
            int c2 = sc.nextInt();
            connect[c1].add(c2);
            connect[c2].add(c1);
        }



        visited.add(1);
        search(1,0);
        //처음에 1을 추가했기 때문에 size -1
        System.out.println(visited.size()-1);


    }

    private static void search(int start, int pre) {
        boolean flag=false;
        for (int i = 0; i < connect[start].size(); i++) {
            Iterator<Integer> iterSet = visited.iterator();
            while (iterSet.hasNext()){
                int n = iterSet.next();
                //set에 같은게 있다면
                if(connect[start].get(i)==n){
                    flag=false;
                    break;
                }else{
                    flag=true;
                }
            }
            if(flag) {
                visited.add(connect[start].get(i));
                search(connect[start].get(i), start);
            }
        }
    }
}
