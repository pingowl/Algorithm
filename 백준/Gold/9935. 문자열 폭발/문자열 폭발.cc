#include <bits/stdc++.h>
using namespace std;

string a, b, ret;
int main() {
    cin >> a >> b;
    for(char c : a){
        ret += c;
        if( ret.size() >= b.size() && ret.substr(ret.size()-b.size(), b.size()) == b){
            ret.erase(ret.size()-b.size(), b.size());
        }
    }
    if(ret.size()==0) cout << "FRULA\n";
    else cout << ret << "\n";
    return 0;
}