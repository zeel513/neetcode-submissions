class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int nr = heights.length;
        int nc = heights[0].length;
        boolean[][] pacific = new boolean[nr][nc];
        boolean[][] atlantic = new boolean[nr][nc];

        for(int i = 0; i < nc; i++) {
            dfs(heights,0, i, pacific);
            dfs(heights,nr -1, i ,atlantic);
        }
        
        for(int i = 0; i < nr; i++) {
            dfs(heights,i,0,pacific);
            dfs(heights,i,nc -1,atlantic);
        }

        for(int i = 0; i < nr; i++) {
            for(int j = 0; j < nc; j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    result.add(List.of(i,j));
                }
            }
        }
        return result;
    }

    private void dfs(int[][] heights, int r, int c, boolean[][] visited) {
        if(visited[r][c]) {
            return;
        }

        visited[r][c] = true;

        int[][] dis = new int[][]{{0,1}, {0,-1}, {1, 0}, {-1, 0}};
        for(int[] d: dis) {
            int nextRow = r + d[0];
            int nextCol = c + d[1];
            if(nextRow < 0 || nextRow == heights.length || nextCol < 0 || nextCol == heights[0].length) {
                continue;
            }
            if(heights[nextRow][nextCol] >= heights[r][c]) {
                dfs(heights, nextRow, nextCol, visited);
            }
        }
    }
}
