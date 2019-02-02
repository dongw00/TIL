#include <iostream>
using namespace std;

int main() {
	int n, k, han, t, a[3];
	cin >> n;
	for (int i=1; i <= n; i++) {
		if (i < 100) han = i;
		else if (i > 1000) break;
		else {
			k =0; t = i;
			while (t > 0) {
				a[k++] = t % 10;
				t /= 10;
			}
			if (a[0] - a[1] == a[1] - a[2]) han++;
		}
	}
	cout << han;
	return 0;
}
