import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * README: Assignment 5. This is a program based on depth first search.
 * The user types in X and Y and if there is a path from X to Y, the output is
 * whether it is a path between X and Y. Directed graph
 * Methods from ch4 p536
 * 
 * Course: ID1020 algoritmer och datastrukturer
 * Course literature:  "Algoritms Fourth Edition" by Robert Sedgewick, Kevin Wayne
 * Written by: Laila Arman 
 */

public class DepthFirstDirectedPaths {
	private boolean[] marked;    
	private int[] edgeTo;
	private final int s;

	public DepthFirstDirectedPaths(Digraph G, int s) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		validateVertex(s);
		dfs(G, s);
	}

	private void dfs(Digraph G, int v) {
		marked[v] = true;
		for (int w : G.adj(v)) {
			if (!marked[w]) {
				edgeTo[w] = v;
				dfs(G, w);
			}
		}
	}

	public boolean hasPathTo(int v) {
		validateVertex(v);
		return marked[v];
	}

	public Iterable<Integer> pathTo(int v) {
		validateVertex(v);
		if (!hasPathTo(v))
			return null;
		Stack<Integer> path = new Stack<Integer>();
		for (int x = v; x != s; x = edgeTo[x])
			path.push(x);
		path.push(s);
		return path;
	}

	private void validateVertex(int v) {
		int V = marked.length;
		if (v < 0 || v >= V)
			throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(System.in);  						// new scanner

        File fileName = new File("Input.txt");
        
		SymbolDigraph sg = new SymbolDigraph(fileName, " ");	// creates symbol graph	
		Digraph G = sg.G();									// graph from symbol graph

		System.out.println("type start: ");
		String startVertex = scan.nextLine();
		System.out.println("type end: ");
		String endVertex = scan.nextLine();
		int eV = sg.index(endVertex);
		int sV = sg.index(startVertex);

		DepthFirstDirectedPaths dfs = new DepthFirstDirectedPaths(G, sV);

		// output if there is a path between them or not
		if (dfs.hasPathTo(eV))
			System.out.printf("Yes, %s are %s are connected", sg.name(sV), sg.name(eV));

		else {
			System.out.printf("%s to %s:  not connected\n", sg.name(sV), sg.name(eV));
		}

	}

}
