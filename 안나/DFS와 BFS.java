
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int V;
	static boolean visited[];
	static ArrayList<Integer>[] data ;
	static ArrayList<Integer> dfs_result;
	static ArrayList<Integer> bfs_result;
    public static void main(String[] args) {
    	Scanner sc = new Scanner (System.in);
    	
    	N = sc.nextInt();
    	M = sc.nextInt();
    	V = sc.nextInt();
    	data = new ArrayList [N+1];
    	visited = new boolean[N];
    	dfs_result= new ArrayList<>();
    	bfs_result= new ArrayList<>();

    	for (int i = 0; i < N+1; i++) {
    		data[i] = new ArrayList<>();
    	}
    	
    	for (int i = 0; i < M; i++) {
    		int v1 = sc.nextInt();
    		int v2 = sc.nextInt();
    		data[v1].add(v2);
    		data[v2].add(v1);
		}
    	for (int i = 0; i < data.length; i++) {
			Collections.sort(data[i]);
		}
    	
    	//출력
//    	for (int i = 0; i <data.length; i++) {
//    		System.out.print(i+" => ");
//    		for (int j = 0; j < data[i].size(); j++) {
//				System.out.print(data[i].get(j)+" -> ");
//			}
//    		System.out.println();
//		}
    	
    	dfs_result.add(V);
    	visited[V-1]=true;
    	dfs(V);
    	for (int i = 0; i < dfs_result.size(); i++) {
			System.out.print(dfs_result.get(i)+" ");
		}
    	System.out.println();
    	
    	visited = new boolean[N];
    	bfs(V);
    	for (int i = 0; i < bfs_result.size(); i++) {
			System.out.print(bfs_result.get(i)+" ");
		}
    	
    }
	 static void bfs(int start) {
		 Queue<Integer> q = new LinkedList<>();
		 q.add(start);
		 while(!q.isEmpty()) {
			 int n = q.poll();
			 bfs_result.add(n);
			 visited[n-1]=true;
			 for (int i = 0; i < data[n].size(); i++) {
				 int v = data[n].get(i);
				 if(visited[v-1]) continue;
				 visited[v-1]= true;
				 q.add(v);	
			}
			 
		 }
		 
		
	}
	static void dfs(int start) {
		boolean flag = true;
		for (int i = 0; i < visited.length; i++) {
			if(!visited[i]) {
				flag=false;
				break;
			}
		}
		
		if(flag) {
			return;
		}
		for (int i = 0; i < data[start].size(); i++) {
			int v = data[start].get(i);
			if(visited[v-1]) continue;
			visited[v-1]=true;
			dfs_result.add(v);
			dfs(v);
		}
		
	}
}
