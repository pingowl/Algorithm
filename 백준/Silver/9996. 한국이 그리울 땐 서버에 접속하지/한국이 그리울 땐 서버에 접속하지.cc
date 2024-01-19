#include <bits/stdc++.h>
using namespace std;  

int n, star;
string p, a, f, b;

int main() {
    ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);

    cin >> n >> p ;
    for (int i=0; i<n; i++){
        cin >> a;
        star = p.find('*');
        f = p.substr(0,star);
        b = p.substr(star+1);
        if(f.size() + b.size() > a.size()){
            cout << "NE\n";
        }
        else if(f == a.substr(0, star) && b == a.substr(a.size()-b.size())){
            cout << "DA\n";
        }
        else cout << "NE\n";
    }
    
    return 0;
}