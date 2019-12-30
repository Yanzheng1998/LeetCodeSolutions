/**
*  Union-Find; 2D to 1D transformation; path compression
**/
class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new LinkedList<>();
        int[] islands = new int[m * n];
        int[][] directions = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
        Arrays.fill(islands, -1);
        int num = 0;
        for (int[] position : positions) {
            
            int y = position[0];
            int x = position[1];
            int index = transform(y,x,n);
            if (islands[index] != -1) {
                res.add(num);
                continue;
            }
            num++;
            islands[index] = index;
            
            for (int[] direction : directions) {
                int newX = x + direction[1];
                int newY = y + direction[0];
                if (newX >= n || newX < 0 || newY >= m || newY < 0) continue;
                int newIndex = transform(newY, newX, n);
                if (islands[newIndex] != -1) {
                    while (newIndex != islands[newIndex]) {
                        //path compression
                        islands[newIndex] = islands[islands[newIndex]];
                        newIndex = islands[newIndex];
                    }
                    if (newIndex != index) {
                        num--;
                        islands[newIndex] = index;
                    }
                }
            }
            res.add(num);
        }
        return res;
    }
    
    private int transform(int y, int x, int width) {
        return y*width + x;
    }
}
