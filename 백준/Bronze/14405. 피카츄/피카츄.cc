#include <bits/stdc++.h>
using namespace std;

string a;
int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    cin >> a;
    for(int i=0; i<a.size();){
        if(a[i]=='p' && i+1<a.size() && a[i+1]=='i'){
            i +=2;
        }
        else if(a[i]=='k' && i+1<a.size() && a[i+1]=='a'){
            i +=2;
        }
        else if(a[i]=='c' && i+2<a.size() && a[i+1]=='h' && a[i+2]=='u'){
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