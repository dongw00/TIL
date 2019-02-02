#include <iostream>
using namespace std;

bool b[10001];

int check(int n) {
	int res = n;
	while(n>0) {
		res += n%10;
		n /= 10;
	}
	return res;
}

int main() {
	for (int i=1; i<=10000; i++) {
		if (check(i)<=10000) b[check(i)] = true;
	}
	for (int i=1; i<=10000; i++) {
		if (b[i] != true) printf("%d\n", i);
	}
}
