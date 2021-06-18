import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
// ch4 p552. done
public class SymbolGraph {
	private BST<String, Integer> st;
	private String[] keys;
	private Graph graph;

	public SymbolGraph(File filename, String delimiter) throws FileNotFoundException {
		st = new BST<String, Integer>();

		Scanner input = new Scanner(filename); 

		while (input.hasNext()) {
			String[] a = input.nextLine().split(delimiter);
			for (int i = 0; i < a.length; i++) {
				if (!st.contains(a[i]))
					st.put(a[i], st.size());
			}
		}

		keys = new String[st.size()];
		for (String name : st.keys()) {
			keys[st.get(name)] = name;
		}

		graph = new Graph(st.size());
		input = new Scanner(filename);
		while (input.hasNext()) {
			String[] a = input.nextLine().split(delimiter);
			int v = st.get(a[0]);
			for (int i = 1; i < a.length; i++) {
				int w = st.get(a[i]);
				graph.addEdge(v, w);
			}
		}
	}

	public boolean contains(String s) {
		return st.contains(s);
	}

	public int index(String s) {
		return st.get(s);
	}
	
	public String name(int v) {
		return keys[v];
	}

	public Graph G() {
		return graph;
	}

}
