import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Beak4344 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine().trim());
		double a[] = new double[n];
		for (int i = 0; i < n; i++) {
			String score_ent = br.readLine();
			String score_s[] = score_ent.split(" ");
			int cnt = Integer.parseInt(score_s[0]);
			int sum = 0;
			int avg_num = 0;
			int score[] = new int[cnt];
			for (int j = 1; j < cnt + 1; j++) {
				score[j - 1] = Integer.parseInt(score_s[j]);
				sum += score[j - 1];
			}
			float avg = sum / (float) cnt;

			for (int k = 0; k < cnt; k++) {
				if (score[k] > avg) {
					avg_num += 1;
				}
			}
			a[i] = (avg_num / (float) cnt) * 100;
			bw.write(String.format("%.3f", a[i]) + "%" + "\n");
		}
		bw.flush();
		bw.close();
	}
}
