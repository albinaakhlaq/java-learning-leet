package Graph;

import java.util.HashSet;
import java.util.Set;

public class Islandcount {

    public int numIslands(char[][] grid) {
        int count_island =0;
        int rows = grid.length;
        int columns = grid[0].length;
        Set<String> visited = new HashSet<String>();
        for (int row =0 ; row < rows;row++)
        {
            for(int column =0 ; column <columns;column++)
            {
                if(dfs(row,column,grid,visited))
                    count_island+=1;
            }
        }
        return count_island;
    }

    public boolean dfs(int row,int column,char[][] grid,Set<String> visited)
    {
        boolean rowInbound = row >=0 && row < grid.length;
        boolean columnInbound = column >=0 && column < grid[0].length;
        if(!rowInbound || !columnInbound) return false;
        if(grid[row][column]=='0') return false;
        String key = row + "-" +column;
        if(visited.contains(key)) return false;
        visited.add(key);
        dfs(row-1,column,grid,visited);
        dfs(row+1,column,grid,visited);
        dfs(row,column-1,grid,visited);
        dfs(row,column+1,grid,visited);
        return true;
    }


}
