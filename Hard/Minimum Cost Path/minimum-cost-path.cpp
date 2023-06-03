//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends


class Solution
{
    public:
    //Function to return the minimum cost to react at bottom
	//right cell from top left cell.
    int minimumCostPath(vector<vector<int>>& grid) {
        int n = grid.size();
        vector<int> dx = {0,0,1,-1};
        vector<int> dy = {1,-1,0,0};
        vector<vector<bool>> visited(n,vector<bool>(n,false));
        vector<vector<int>> dist(n,vector<int>(n,1e8));
        
        priority_queue<pair<int,pair<int,int>>> pq;
        pq.push({-grid[0][0] , {0,0}});
        dist[0][0] = grid[0][0];
        
        while(pq.size() > 0){
            int x = pq.top().second.first;
            int y = pq.top().second.second;
            pq.pop();
            if (visited[x][y] == true)
                continue;
            visited[x][y] = true;
            
            for (int k{};k<4;k++){
                int nx = x+dx[k];
                int ny = y+dy[k];
                if (nx<0 || ny<0 || nx>=n || ny>=n)
                    continue;
                if (dist[x][y] + grid[nx][ny] <= dist[nx][ny]){
                    dist[nx][ny] = dist[x][y] + grid[nx][ny];
                    pq.push({-dist[nx][ny] , {nx,ny}});
                }
            }
        }

        return dist[n-1][n-1];
    }
};

//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int n;
		cin >> n;
		vector<vector<int>>grid(n, vector<int>(n, -1));
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				cin >> grid[i][j];
			}
		}
		Solution obj;
		int ans = obj.minimumCostPath(grid);
		cout << ans << "\n";
	}
	return 0;
}
// } Driver Code Ends