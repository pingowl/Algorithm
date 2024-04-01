#include <bits/stdc++.h>
using namespace std;

string a;
int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    cin >> a;
    for(int i=0; i<a.size();){
        if(i+1<a.size() && a.substr(i,2)=="pi" || a.substr(i,2)=="ka"){
            i +=2;
        }
        else if(i+2 < a.size() && a.substr(i,3)=="chu"){
            i +=3;
        }
        else{
            cout << "NO\n";
            return 0;
        }
    }
    cout << "YES\n";
    return 0;
}
