import java.lang.Math; 
class Point implements Comparable<Point> {
        int dim1;
        int dim2;
        public Point (int dim1, int dim2) {
            this.dim1 = dim1;
            this.dim2 = dim2;
        }
        public int compareTo(Point p) {  
            if (this.dist() < p.dist() )  {
                return 1;
            }
            else if (this.dist() > p.dist() ){
    
                return -1;
            }
            else return 0;
        }
        public double dist() {
            return (double)Math.sqrt(Math.pow(this.dim1,2) + Math.pow(this.dim2,2)) ;
        }
        public int[] getDim() {
            return  new int[]{dim1,dim2};
        }
    }
class Solution {
    
    public int[][] kClosest(int[][] points, int K) {
        
        Queue<Point> queue=new PriorityQueue<Point>();
        for (int i = 0;i<points.length;i++){
            if (queue.size() < K) {
                queue.add(new Point(points[i][0],points[i][1]));
            }
            else {
                Point p = new Point(points[i][0],points[i][1]);
                Point p1 = queue.peek();
                if (p.compareTo(p1) == 1) {
                    queue.poll();
                    queue.add(p);
                }
            }
        }
        int[][] result = new int[K][2];
        for (int i = 0;i<K;i++) {
            result[i] = queue.poll().getDim();
        }
        return result;
    }
    
}
