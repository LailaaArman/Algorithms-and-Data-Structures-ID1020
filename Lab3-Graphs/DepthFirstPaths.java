import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * README: Assignment 1. This is a program based on depth first search
 * The user types in X and Y and if there is a path from X to Y, the output is
 * a list of vertices from X to Y. Undirected graph
 * Methods from ch4 p536
 * 
 * Course: ID1020 algotmer dtastrukturer
 * Course literature:  "Algoritms Fourth Edition" by Robert Sedgewick, Kevin Wayne
 * Written by: Laila Arman 
 */

public class DepthFirstPaths { 
	private boolean[] marked;     //create empty array, holds vertices marked as true/false
	private int[] edgeTo;		//empty array, last edge on s-v path
	private final int s;		//source vertex 

	public DepthFirstPaths(Graph G, int s) {       //create constructors 
		marked = new boolean[G.V()];        
		edgeTo = new int[G.V()];
		this.s = s;
		dfs(G, s);			        	//call dfs with graph and 
	}

	private void dfs(Graph G, int v) {
		marked[v] = true;       	 //mark first vertex as true 
		for (int w : G.adj(v)) {	 //visit vertices close to v 
			if (!marked[w]) {		//if w is not marked yet 
				edgeTo[w] = v;		//add edge bewteen them 
				dfs(G, w);	         
			}
		}
	}

	public boolean hasPathTo(int v) {   //if it has a path, return true  
		return marked[v];			
	}

	public Iterable<Integer> pathTo(int v) {    //gets endVertex 
		if (!hasPathTo(v))  					 //if there is no path 
			return null;
		Stack<Integer> path = new Stack<Integer>();   //create stack 

		for (int x = v; x != s; x = edgeTo[x])     
			path.push(x);   
		path.push(s);
		return path;
	}


	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(System.in);  						// new scanner

		File fileName = new File("Input.txt"); 

		SymbolGraph sg = new SymbolGraph(fileName, " "); 			// creates symbol graph, indexera
		Graph graph = sg.G();										// graph from symbol graph
		System.out.println("Type start:");
		String startVertex = scan.nextLine();
		System.out.println("Type end:");
		String endVertex = scan.nextLine();

		int eV = sg.index(endVertex);  		 //get index of endV	
		int sV = sg.index(startVertex);		//get index of StartVertex 

		DepthFirstPaths dfs = new DepthFirstPaths(graph, sV); 

		if (dfs.hasPathTo(eV))    //does path exist? 
			// if yes,prints the path
			for (int i : dfs.pathTo(eV))  //pathTo, uses stack, 
				System.out.print(sg.name(i) + " ");
		else
			System.out.println("No path!");
		System.out.println();
	}


}
