#include <iostream>
#include <string>
using namespace std;

int main() {
	int a, b, c, sum = 0;
	int arr[10] = {0};
	cin >> a >> b >> c;
	
	sum = a * b * c;
	
	while(sum != 0) {
		arr[sum % 10]++;
		sum /= 10;
	}
	
	for (int i=0; i<10; i++) 
		cout << arr[i] << endl;
	
	return 0;
}
