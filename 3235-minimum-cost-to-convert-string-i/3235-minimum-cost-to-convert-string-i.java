class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int m = original.length;
        int[][] fw = new int[26][26];
        for(int[] i:fw) Arrays.fill(i, (int)1e9);

        for(int i=0; i<26; i++) {
            fw[i][i] = 0;
        }
        /**
            diagonal values all 0
            everything else 1e9
            loop over the edges and populate the table
            then do fw
        */
        for(int i=0; i<m; i++) {
            int u = original[i]-'a', v = changed[i]-'a', w = cost[i];
            fw[u][v] = Math.min(fw[u][v], w);
        }
        // fw algo
        for(int via = 0; via<26; via++) {
            for(int i=0; i<26; i++) {
                if(fw[i][via] >= (int)1e9) continue;
                for(int j = 0; j<26; j++) {
                    if(i==j || fw[via][j] >= (int)1e9) continue;
                    fw[i][j] = Math.min(fw[i][j], fw[i][via] + fw[via][j]);
                }
            }
        }

        long ans = 0;
        for(int i=0; i<source.length(); i++) {
            int val = fw[source.charAt(i)-'a'][target.charAt(i)-'a'];
            if(val >= (int)1e9) return -1;
            ans+=val;
        }
        return ans;
    }
}