#include <bits/stdc++.h>
using namespace std;
int dir[8][2] = {
   {1, 0}, {-1, 0}, {1, -1}, {1, 1},
   {-1, 1}, {-1, -1}, {0, 1}, {0, -1}
};
int dir2[4][2] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
class Solution {
   public:int calcDist(int x1, int y1, int x2, int y2){
      return abs(x1 - x2) + abs(y1 - y2);
   }
   int maxDistance(vector<vector<int>>& grid) {
      map < pair <int, int>, pair <int, int> > m;
      queue < pair <int, int> > q;
      int n = grid.size();
      int c = n? grid[0].size() : 0;
      for(int i = 0; i < n; i++){
         for(int j = 0; j < c; j++){
            if(grid[i][j] == 1){
               q.push({i, j});
               m[{i, j}] = {i, j};
            }
         }
      }
      int ret = -1;
      while(!q.empty()){
         int sz = q.size();
         while(sz--){
            pair <int, int> temp = q.front();
            q.pop();
            for(int k = 0; k < 4; k++){
               int nx = temp.first + dir2[k][0];
               int ny = temp.second + dir2[k][1];
               if(nx < 0 || ny < 0 || nx >= n || ny >= c || grid[nx][ny]) continue;
               m[{nx, ny}] = m[temp];
               ret = max(calcDist(nx, ny, m[temp].first,
               m[temp].second), ret);
               q.push({nx, ny});
               grid[nx][ny] = 1;
            }
         }
      }
      return ret;
   }
};
main(){
   vector<vector<int>> v1 = {{1,0,1},{0,0,0},{1,0,1}};
   Solution ob;
   cout << (ob.maxDistance(v1));
}
