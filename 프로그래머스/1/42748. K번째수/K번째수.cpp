#include <bits/stdc++.h>
using namespace std;

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    vector<int> answer;
    int i, j, k;
    for(int a=0; a<commands.size(); a++){
        i = commands[a][0]-1;
        j = commands[a][1]-1;
        k = commands[a][2]-1;
        vector<int> v;
        v.assign(array.begin()+i, array.begin()+j+1);
        sort(v.begin(), v.end());
        answer.push_back(v[k]);
    }

    
    return answer;
}