#include <string>
#include <vector>

using namespace std;

int solution(string name) {
    int answer = 0, n, afterA, alpha=0, flag =0;
    n = name.length();
    vector<int> v;
    answer = n-1;
    for(int i=0; i<n; i++){
        if(name[i] < 'N')
            alpha += name[i]-'A';
        else
            alpha += 1 + ('Z' -name[i]);
        
        if(i<n-1 && name[i+1]=='A'){
            afterA = i+1;
            while(afterA <n && name[afterA]=='A'){
                afterA++;
            }
            // 오른쪽으로 갔다가 왼쪽으로 꺾는 경우
            answer = min(answer, i * 2 + (n-afterA));
            // 왼쪽으로 갔다가 오른쪽으로 꺾는 경우
            answer = min(answer, 2*(n-afterA) + i);
        }
        
    }
   
    return answer+alpha;
}