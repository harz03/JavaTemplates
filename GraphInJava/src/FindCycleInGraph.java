import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class FindCycleInGraph{
	public static Boolean bfs(ArrayList<ArrayList<Integer>> adj,Integer source,ArrayList<Boolean> visited) {
		visited.set(source , true);
		Queue<Integer> q = new LinkedList<>();
		q.add(source);
		int[] parent = new int[adj.size()];
		parent[source] = -1;
		while(!q.isEmpty()) {
			int current = q.peek();
			q.remove();
//			System.out.println(current);
			for(int x:adj.get(current)) {
				if(visited.get(x) ==  false) {
					parent[x] = current;
					visited.set(x, true);
					q.add(x);
				}
				else if(parent[current] != x) {
					return true;
				}
			}
		}
		return false;
 	}

	public static Boolean dfs(ArrayList<ArrayList<Integer>> adj,Integer source,int parent,ArrayList<Boolean> visited) {
		visited.set(source, true);
		for(int x:adj.get(source)) {
			if(visited.get(x) == false) {
				if(dfs(adj,x,source,visited)==true)return true;
			}else if(parent !=  x) {
				return true;
			}
		}
		return false;
	}
}
