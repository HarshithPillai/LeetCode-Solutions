class NumberContainers {

    Map<Integer, PriorityQueue<Integer>> valIndices;
    Map<Integer, Integer> indexVal;

    public NumberContainers() {
        valIndices = new HashMap<>();
        indexVal = new HashMap<>();
    }
    
    public void change(int index, int number) {
        if(indexVal.containsKey(index)) {
            int currVal = indexVal.get(index);
            if(currVal == number) return;
            List<Integer> lt = new ArrayList<>();
            while(valIndices.get(currVal).peek() != index) {
                lt.add(valIndices.get(currVal).poll());
            }
            valIndices.get(currVal).poll();
            for(int i:lt) valIndices.get(currVal).add(i);
            indexVal.remove(index);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        if(valIndices.containsKey(number)) pq = valIndices.get(number);
        pq.add(index);
        valIndices.put(number, pq);
        indexVal.put(index, number);
    }
    
    public int find(int number) {
        if(valIndices.containsKey(number) && !valIndices.get(number).isEmpty()) {
            // System.out.println(number+" -> "+valIndices.get(number).toString());
            return valIndices.get(number).peek();
        }
        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */