// A Space optimized Dynamic Programming based C++
// program for LPS problem
#include <bits/stdc++.h>
using namespace std;

int lps(string &s)
{
	int n = s.length();

	int a[n];

	// Pick starting point
	for (int i = n - 1; i >= 0; i--) {

		int back_up = 0;

		for (int j = i; j < n; j++) {

			if (j == i)
				a[j] = 1;

			else if (s[i] == s[j])
			{
				
				int temp = a[j];
				a[j] = back_up + 2;
				back_up = temp;
			}

			else
			{
				back_up = a[j];
				a[j] = max(a[j - 1], a[j]);
			}
		}
	}
	
	return a[n - 1];
}

int main()
{
	string str = "GEEKSFORGEEKS";
	cout << lps(str);
	return 0;
}
