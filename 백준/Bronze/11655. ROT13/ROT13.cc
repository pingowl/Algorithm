#include <bits/stdc++.h>
using namespace std;  

string a;
void solve(){ 
    for (int i=0; i<a.size(); i++) {
        if('a'<=a[i] && a[i]<='z'){
            a[i] = char((int(a[i]-'a')+13)%26)+'a';
        } 
        else if ('A'<=a[i] && a[i]<='Z'){
            a[i] = char((int(a[i]-'A')+13)%26)+'A';
        }
        else continue;
    }
    cout << a;
    return;
}


int main() {
    ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);

    getline(cin, a);
    solve();
    return 0;
}