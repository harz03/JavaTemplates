import java.util.ArrayList;
import java.util.Scanner;
public class Graph extends FindCycleInGraph {
	public static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
	
	public static void addEdgeUndirected(Integer u,Integer v) {
		adj.get(u).add(v);
		adj.get(v).add(u);
	}
	public static void addEdgeDirected(Integer u,Integer v) {
		adj.get(u).add(v);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer numberOfNode = sc.nextInt();
		Integer numberOfVertices = sc.nextInt();
		for(int i=0;i<numberOfNode;i++) {
			adj.add(new ArrayList<>());
		}
		for(int i=0;i<numberOfVertices;i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			addEdgeUndirected(u-1,v-1);
		}
		for(int i=0;i<numberOfNode;i++) {
			System.out.print("node : "+i+" are ");
			for(int j=0;j<adj.get(i).size();j++) {
				System.out.print(adj.get(i).get(j)+" ");
			}
			System.out.println("");
		}
		ArrayList<Boolean> visited = new ArrayList<> ();
		for(int i=0;i<numberOfNode;i++) {
			visited.add(false);
		}
		
		for(int i=0;i<numberOfNode;i++) {
			if(visited.get(i) == false   ) {
				if(FindCycleInGraph.dfs(adj, i,-1, visited))
					System.out.println(i + "yes");
			}
		}
	}
	

}
