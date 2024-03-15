#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;


int main() {
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
    int n; cin >> n;
    vector<vector <int>> v(n, vector<int>(2));
    
    for (int i = 0; i < n; i++)
    {
        cin >> v[i][1] >> v[i][0]; //sort 기준이 첫번째 인자가 되니까        
    }
    sort(v.begin(), v.end());
    int now; 
    now = v[0][0];
    int cnt=1;
    for (int j = 1; j < n; j++) {
        if (now <= v[j][1]) {
            cnt += 1;
            now = v[j][0];
        }
    }
    cout << cnt;
}