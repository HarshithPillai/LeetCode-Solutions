class Solution {
    Set<String> set;
    // class Pair{
    //     int sr, sc;
    //     Pair(int r, int c){
    //         sr=r; sc=c;
    //     }
    // }
    public int[][] recutil(int[][] image, int sr, int sc, int color, int initial) {
        if(set.contains(sr+" "+sc)) return image;
        int r=image.length;
        if(sr<0 || sc<0 || sr==r) return image;
        int c=image[0].length;
        if(sc==c) return image;
        set.add(sr+" "+sc);
        if(image[sr][sc]==initial) {
            image[sr][sc]=color;
            image=recutil(image, sr-1,   sc, color, initial);
            image=recutil(image,   sr, sc-1, color, initial);
            image=recutil(image, sr+1,   sc, color, initial);
            image=recutil(image,   sr, sc+1, color, initial);
        }
        return image;
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        set = new HashSet<>();
        return recutil(image, sr, sc, color, image[sr][sc]);
    }
}