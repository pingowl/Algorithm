#include <bits/stdc++.h>
using namespace std;  
int t, n, c2, c5, v2, v5;
int main() {
    ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);
    cin >> t;
    while(t--){
        cin >> n;
        c2=0; c5=0;
        v2=2, v5=5;
        while(1){
            if(n >= v2){ c2 += n/v2; v2 *= 2;}
            else if(n >= v5){ c5 += n/v5; v5 *=5;}
            else break;
        }
        cout << min(c2,c5) << "\n";
    }
	
    return 0;
}