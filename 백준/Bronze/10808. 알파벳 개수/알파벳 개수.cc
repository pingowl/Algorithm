#include <bits/stdc++.h>
using namespace std;  

string word;
int a[26];
int n = 26;

void solve(){ 
    for (int i=0; i< word.size(); i++){
        a[word[i]-'a']++;
    }
}

void print(){
  for(int i = 0; i < n; i++) cout << a[i] << " "; 
  cout << '\n';
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> word;
    
    solve();
    print();
    return 0;
}