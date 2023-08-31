class Solution {
    // Set<Pairx> set;
    // class Pairx{
    //     int row;
    //     int col;
    //     Pairx(int r, int c){
    //         row=r; col=c;
    //     }
    // }
    public void recutil(int[][] image, int sr, int sc, int color, int initial) {
        int r=image.length;
        if(sr<0 || sc<0 || sr==r || image[0].length==sc) return;
        
        if(image[sr][sc]==initial) {
            image[sr][sc]=color;
            recutil(image, sr-1,   sc, color, initial);
            recutil(image,   sr, sc-1, color, initial);
            recutil(image, sr+1,   sc, color, initial);
            recutil(image,   sr, sc+1, color, initial);
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        //set = new HashSet<>();
        if(image[sr][sc]==color) return image;
        recutil(image, sr, sc, color, image[sr][sc]);
        return image;
    }
}
