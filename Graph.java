import java.util.LinkedList;
import java.util.Queue;

public class Graph {

	int size;
	String[] vertices;
	boolean[][] a;
	boolean[] Dvisted;
	boolean[] Bvisited;
	
	public Graph(String[] args) {
		size = args.length;
		vertices = new String[size];
		System.arraycopy(args, 0, vertices, 0, size);
		a = new boolean[size][size];
		Dvisted = new boolean[size];
		Bvisited = new boolean[size];
	}
	
	public void add(String v, String w) {
		int i = index(v), j = index(w);
		a[i][j] = a[j][i] = true;
	}
	private int index(String v) {
		for(int i=0; i<size; i++) {
			if(vertices[i].equals(v))
				return i;
		}
		return a.length;
	}
	
	public String toString() {
		if(size==0)
			return "{ }";
		StringBuffer buf = new StringBuffer("{"+vertex(0));
		for(int i=1; i<size; i++) {
			buf.append(","+vertex(i));
		}
		return buf + "}";	
	}
	
	private String vertex(int i) {
		StringBuffer buf = new StringBuffer(vertices[i] + ":");
		for(int j=0; j<size; j++)
			if(a[i][j])
				buf.append(vertices[j]);
		return buf + "";
	}
	
	public void dfsTree(String v) {
		Dvisted[index(v)] = true;
		
		for(int i=0; i<size; i++) {
			if(a[index(v)][i] == true && !Dvisted[i]) {
				System.out.println("ROOT("+vertices[index(v)]+")-->"+vertices[i]);
				dfsTree(vertices[i]);
			}
		}
	}
	
	public void bfsTree(String v) {
		Queue<String> q = new LinkedList<>();
		
		q.add(v);
		Bvisited[index(v)] = true;
		System.out.println("ROOT : "+ v);
		while(!q.isEmpty()) {
			v = q.poll();
			System.out.print(v+" 탐색 : ");
			
			for(int i=0; i<size; i++) {
				if(a[index(v)][i] == true && Bvisited[i] == false) {
					q.add(vertices[i]);
					Bvisited[i] = true;
					System.out.print(vertices[i]+" ");
				}
			}
			System.out.println();
		}
		
	}
}
