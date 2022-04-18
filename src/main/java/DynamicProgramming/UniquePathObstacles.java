package DynamicProgramming;

public class UniquePathObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return uniquePath(obstacleGrid.length-1,obstacleGrid[0].length-1,obstacleGrid);

    }

    public int uniquePath(int m,int n,int[][] grid)
    {

        if (m==0 || n ==0) return Math.abs(grid[m][n]-1);
        if (m ==1 && n ==1 ) return Math.abs(grid[m][n]-1);
        return uniquePath(m-1,n,grid) +uniquePath(m,n-1,grid);

    }

    public static void main(String[] args) {
        UniquePathObstacles obj = new UniquePathObstacles();
        int[][] input = {{0,0},{0,0}};

        System.out.println("Result: "+obj.uniquePathsWithObstacles(input));
    }
}

