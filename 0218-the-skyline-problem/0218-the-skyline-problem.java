class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        /**
            create a list of all the buildings:
                add as [starting x coordinate, - height] and [ending x coordinate, + height]
            
            sort the array in an increasing order of x coordinates and height                
        */
        int ind = 0, n = buildings.length, last = -1;
        List<List<Integer>> ans = new ArrayList<>();
        List<int[]> list = new ArrayList<>();
        for (int[] ar : buildings) {
            list.add(new int[]{ar[0], -ar[2]});
            list.add(new int[]{ar[1], ar[2]});
        }

        Collections.sort(list, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });
        
        /**
            go from left to right on the list
            keep a treeset of heights
        */

        TreeMap<Integer, Integer> map = new TreeMap<>();
        int currHeight = 0;
        for (int[] bld : list) {
            int x = bld[0], h = bld[1];
            if (h < 0) {
                map.put(h, map.getOrDefault(h, 0) + 1);
            } else {
                int count = map.get(-h);
                if (count == 1) {
                    map.remove(-h);
                } else {
                    map.put(-h, count - 1);
                }
            }
            if (map.isEmpty()) {
                currHeight = 0;
                ans.add(List.of(x, 0));
            } else {
                int newHeight = -map.firstEntry().getKey();
                if (newHeight != currHeight) {
                    if (ans.size() == 0 || newHeight != ans.get(ans.size()-1).get(1)) ans.add(List.of(x, newHeight));
                    newHeight = currHeight;
                }
            }
        }

        return ans;
    }
}