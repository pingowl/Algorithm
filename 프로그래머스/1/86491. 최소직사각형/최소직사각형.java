class Solution {
    public int solution(int[][] sizes) {
        int size=0, max1=0, max2=0, newMax=0;
        for(int i=0; i<sizes.length; i++){
            if(sizes[i][0] > max1) max1 = sizes[i][0];
            if(sizes[i][1] > max2) max2 = sizes[i][1];
        }
        if(max1 >= max2){
            for(int i=0; i<sizes.length; i++){
                if(sizes[i][0] < sizes[i][1]){
                    int tmp = sizes[i][0];
                    sizes[i][0] = sizes[i][1];
                    sizes[i][1] = tmp;
                }
                if(newMax < sizes[i][1]) newMax = sizes[i][1];
            }
            size = max1 * newMax;
        } else {
            for(int i=0; i<sizes.length; i++){
                if(sizes[i][1] < sizes[i][0]){
                    int tmp = sizes[i][0];
                    sizes[i][0] = sizes[i][1];
                    sizes[i][1] = tmp;
                }     
                if(newMax < sizes[i][0]) newMax = sizes[i][0];
            }
            size = max2 * newMax;
        }
    
        return size;
    }
}