#include <bits/stdc++.h>
using namespace std;

int cnt = 0;
vector <int> s;

void TOH(int n, int a, int b, int c)
{  
    if(n>0)
    {
        TOH(n-1, a, c, b);
        s.push_back(a);
        s.push_back(c);
        TOH(n-1, b, a, c);
        cnt+=1;
    }
}

 int main()
{   int n;
    cin >> n;
    TOH(n,1,2,3);
    cout << cnt << endl;
    for(int i=0; i<s.size(); i+=2) {
        cout <<"Ring moved from " << s[i] << " to " << s[i+1] << endl;
    }
    return 0;
}