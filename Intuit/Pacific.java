import java.util.List;
import java.util.ArrayList;
class Pacific{      
    static int[] dx = {-1,1,0,0};
static int[] dy = {0,0,1,-1};
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
    List<List<Integer>> res = new ArrayList<>();
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
    boolean[][] pacific = new boolean[matrix.length][matrix[0].length];
    boolean[][] atlantic = new boolean[matrix.length][matrix[0].length];
    for (int i = 0; i < matrix.length; i++){
        pacific[i][0] = true;
        atlantic[i][matrix[0].length-1] = true;
    }
    for (int j = 0; j < matrix[0].length; j++){
        pacific[0][j] = true;
        atlantic[matrix.length-1][j] = true;
    }
    for (int i = 0; i < matrix.length; i++){
        explore(pacific, matrix, i, 0);
        explore(atlantic, matrix, i, matrix[0].length-1);
    }
    for (int j = 0; j < matrix[0].length; j++){
        explore(pacific, matrix, 0, j);
        explore(atlantic, matrix, matrix.length-1, j);
    }
    for (int i = 0; i < matrix.length; i++){
        for (int j = 0; j < matrix[0].length; j++){
            if (pacific[i][j] && atlantic[i][j] == true)
            {
                List<Integer> temp = new ArrayList<>();
            temp.add(i);
            temp.add(j);
                res.add(temp);
            }
        }
    }
    return res;
    
}
private void explore(boolean[][] grid, int[][] matrix, int i, int j){
    grid[i][j] = true;
    for (int d = 0; d < dx.length; d++){
        if (i+dy[d] < grid.length && i+dy[d] >= 0 && 
            j + dx[d] < grid[0].length && j + dx[d] >= 0 && 
            grid[i+dy[d]][j+dx[d]] == false && matrix[i+dy[d]][j+dx[d]] >= matrix[i][j])
                explore(grid, matrix, i+dy[d], j+dx[d]);
    }
}
    }