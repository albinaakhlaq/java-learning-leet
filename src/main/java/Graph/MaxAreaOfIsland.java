package Graph;
import java.util.HashSet;
import java.util.Set;

public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        int count_island =0;
        int rows = grid.length;
        int columns = grid[0].length;
        Set<String> visited = new HashSet<String>();
        for (int row =0 ; row < rows;row++)
        {
            for(int column =0 ; column <columns;column++)
            {
                int temp_count =dfs(row,column,grid,visited);
                count_island = Math.max(temp_count,count_island) ;
            }
        }
        return count_island;
    }

    public int dfs(int row,int column,int[][] grid,Set<String> visited)
    {
        boolean rowInbound = row >=0 && row < grid.length;
        boolean columnInbound = column >=0 && column < grid[0].length;
        if(!rowInbound || !columnInbound) return 0;
        if(grid[row][column]==0) return 0;
        String key = row + "-" +column;
        if(visited.contains(key)) return 0;
        visited.add(key);
        int count =1;
        count = count+dfs(row-1,column,grid,visited);
        count = count+dfs(row+1,column,grid,visited);
        count = count+dfs(row,column-1,grid,visited);
        count = count+dfs(row,column+1,grid,visited);
        return count;
    }
}
