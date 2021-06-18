import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * README: Assignment 2. This is a program based on breadth first search
 * The user types in X and Y and if there is a path from X to Y, the output is
 * a list of vertices from X to Y. Undirected graph
 * Methods from ch4 p540
 * 
 * Course: ID1020 algoritmer och datastrukturer
 * Course literature:  "Algoritms Fourth Edition" by Robert Sedgewick, Kevin Wayne
 * Written by: Laila Arman 
 */

public class BreadthFirstPaths {
	private boolean[] marked;
	private int[] edgeTo;
	private final int s;

	public BreadthFirstPaths(Graph G, int s) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		bfs(G, s);
	}

	private void bfs(Graph G, int s) {
		Queue<Integer> q = new Queue<Integer>();
		marked[s] = true;     //startnode marked 
		q.enqueue(s);          //enqueue s 
		while (!q.isEmpty()) {      //sålänge kön inte är tom 
			int v = q.dequeue();        //deqeuue, ligger alltid först i kön, ta bort den 
			for (int w : G.adj(v)) {    //gå igenom alla ndoer som s är granne med
				if (!marked[w]) {      //enqueue, lägg till i kön om den inte är markerad 
					edgeTo[w] = v;
					marked[w] = true;
					q.enqueue(w);      
				}
			}
		}
	} 

	public boolean hasPathTo(int v) {
		return marked[v];
	}

	public Iterable<Integer> pathTo(int v) {
		if (!hasPathTo(v))
			return null;
		Stack<Integer> path = new Stack<Integer>();
		for (int x = v; x != s; x = edgeTo[x])
			path.push(x);
		path.push(s);
		return path;
	}

	public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);  						// new scanner

        File fileName = new File("Input.txt");
        
		SymbolGraph sg = new SymbolGraph(fileName, " "); 			// creates symbol graph, indexerar
		Graph graph = sg.G();										// graph from symbol graph
		System.out.println("Type start:");
		String startVertex = scan.nextLine();
		System.out.println("Type end:");
		String endVertex = scan.nextLine();

		int eV = sg.index(endVertex);           //get index of EV
		int sV = sg.index(startVertex);            //get index of Ev

		BreadthFirstPaths dfp = new BreadthFirstPaths(graph, sV);

		if (dfp.hasPathTo(eV))
			// prints the path
			for (int i : dfp.pathTo(eV))
				System.out.print(sg.name(i) + " ");
		else
			System.out.println("No path!");
		System.out.println();
	}

}