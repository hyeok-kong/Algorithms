import java.util.*;

public class Main {
	int n, m;
	List<Integer> rs = new ArrayList<>();
	boolean[] visited;
	
	private void back(int k) {
		if (k == m) {
			String print = "";
			for(int i=0;i<rs.size();i++) {
				print += rs.get(i) + " ";
			}
			System.out.println(print.trim());
			return;
		}
		for(int i=1;i<n+1;i++ ) {
			if (!visited[i]) {
				visited[i] = true;
				rs.add(i);
				back(k+1);
				visited[i] = false;
				rs.remove(rs.size()-1);
			}
		}
	}
	
	public void run() {
		Scanner in = new Scanner(System.in);
		String[] input = in.nextLine().trim().split(" ");
		in.close();
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		visited = new boolean[n+1];
		visited[0] = true;
		back(0);
	}
	
	public static void main(String[] args) {
		Main obj = new Main();
		obj.run();
	}
}