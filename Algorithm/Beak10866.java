import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Beak10866 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		LinkedList<Integer> list = new LinkedList<Integer>();

		int num = Integer.parseInt(st.nextToken());

		while (num-- > 0) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();

			switch (str) {
			case "push_front":
				list.addFirst(Integer.parseInt(st.nextToken()));
				break;
			case "push_back":
				list.addLast(Integer.parseInt(st.nextToken()));
				break;
			case "pop_front":
				if (list.isEmpty())
					System.out.println(-1);
				else
					System.out.println(list.removeFirst());
				break;
			case "pop_back":
				if (list.isEmpty())
					System.out.println(-1);
				else
					System.out.println(list.removeLast());
				break;
			case "size":
				System.out.println(list.size());
				break;
			case "empty":
				if (list.isEmpty())
					System.out.println(1);
				else
					System.out.println(0);
				break;
			case "front":
				if (list.isEmpty())
					System.out.println(-1);
				else
					System.out.println(list.getFirst());
				break;
			case "back":
				if (list.isEmpty())
					System.out.println(-1);
				else
					System.out.println(list.getLast());
				break;
			}
		}
	}
}
