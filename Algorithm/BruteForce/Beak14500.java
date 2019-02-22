package BruteForce;

import java.util.Scanner;

public class Beak14500 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		int[][] a = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				a[i][j] = sc.nextInt();
			}
		}

		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (j+3 < m) {
                    int temp = a[i][j] + a[i][j+1] + a[i][j+2] + a[i][j+3];
                    if (ans < temp) ans = temp;
                }
                if (i+3 < n) {
                    int temp = a[i][j] + a[i+1][j] + a[i+2][j] + a[i+3][j];
                    if (ans < temp) ans = temp;
                }
                if (i+1 < n && j+2 < m) {
                    int temp = a[i][j] + a[i+1][j] + a[i+1][j+1] + a[i+1][j+2];
                    if (ans < temp) ans = temp;
                }
                if (i+2 < n && j+1 < m) {
                    int temp = a[i][j] + a[i][j+1] + a[i+1][j] + a[i+2][j];
                    if (ans < temp) ans = temp;
                }
                if (i+1 < n && j+2 < m) {
                    int temp = a[i][j] + a[i][j+1] + a[i][j+2] + a[i+1][j+2];
                    if (ans < temp) ans = temp;
                }
                if (i+2 < n && j-1 >= 0) {
                    int temp = a[i][j] + a[i+1][j] + a[i+2][j] + a[i+2][j-1];
                    if (ans < temp) ans = temp;
                }
                if (i-1 >= 0 && j+2 < m) {
                    int temp = a[i][j] + a[i][j+1] + a[i][j+2] + a[i-1][j+2];
                    if (ans < temp) ans = temp;
                }
                if (i+2 < n && j+1 < m) {
                    int temp = a[i][j] + a[i+1][j] + a[i+2][j] + a[i+2][j+1];
                    if (ans < temp) ans = temp;
                }
                if (i+1 < n && j+2 < m) {
                    int temp = a[i][j] + a[i][j+1] + a[i][j+2] + a[i+1][j];
                    if (ans < temp) ans = temp;
                }
                if (i+2 < n && j+1 < m) {
                    int temp = a[i][j] + a[i][j+1] + a[i+1][j+1] + a[i+2][j+1];
                    if (ans < temp) ans = temp;
                }
                if (i+1 < n && j+1 < m) {
                    int temp = a[i][j] + a[i][j+1] + a[i+1][j] + a[i+1][j+1];
                    if (ans < temp) ans = temp;
                }
                if (i-1 >= 0 && j+2 < m) {
                    int temp = a[i][j] + a[i][j+1] + a[i-1][j+1] + a[i-1][j+2];
                    if (ans < temp) ans = temp;
                }
                if (i+2 < n && j+1 < m) {
                    int temp = a[i][j] + a[i+1][j] + a[i+1][j+1] + a[i+2][j+1];
                    if (ans < temp) ans = temp;
                }
                if (i+1 < n && j+2 < m) {
                    int temp = a[i][j] + a[i][j+1] + a[i+1][j+1] + a[i+1][j+2];
                    if (ans < temp) ans = temp;
                }
                if (i+2 < n && j-1 >= 0) {
                    int temp = a[i][j] + a[i+1][j] + a[i+1][j-1] + a[i+2][j-1];
                    if (ans < temp) ans = temp;
                }
                if (j+2 < m) {
                    int temp = a[i][j] + a[i][j+1] + a[i][j+2];
                    if (i-1 >= 0) {
                        int temp2 = temp + a[i-1][j+1];
                        if (ans < temp2) ans = temp2;
                    }
                    if (i+1 < n) {
                        int temp2 = temp + a[i+1][j+1];
                        if (ans < temp2) ans = temp2;
                    }
                }
                if (i+2 < n) {
                    int temp = a[i][j] + a[i+1][j] + a[i+2][j];
                    if (j+1 < m) {
                        int temp2 = temp + a[i+1][j+1];
                        if (ans < temp2) ans = temp2;
                    }
                    if (j-1 >= 0) {
                        int temp2 = temp + a[i+1][j-1];
                        if (ans < temp2) ans = temp2;
                    }
                }
			}
		}
		
		System.out.println(ans);

		sc.close();
	}
}
