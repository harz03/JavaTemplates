import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphTraversal {
	public static void bfs(ArrayList<ArrayList<Integer>> adj,Integer source,ArrayList<Boolean> visited) {
		visited.set(source, true);
		Queue<Integer> q = new LinkedList<>();
		q.add(source);
		while(q.size()>0) {
			Integer t = q.remove();;
			
			System.out.println("source "+t+" ");
			for(Integer element:adj.get(t)) {
				if(!visited.get(element)) {
					visited.set(element, true);
					q.add(element);
				}
			}
		}
	}

	public static void dfs(ArrayList<ArrayList<Integer>> adj,Integer source,ArrayList<Boolean> visited) {
		visited.set(source,true);
		System.out.print("Source "+source);
		for(Integer x:adj.get(source)) {
//			System.out.println(x);
			if(visited.get(x) == false) {
				dfs(adj,x,visited);
			}
		}
	}
}
