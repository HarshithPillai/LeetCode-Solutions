class ProductOfNumbers {

    int last = 0;
    int lastZero = -1;
    List<Integer> arr;

    public ProductOfNumbers() {
        arr = new ArrayList<>();
        arr.add(1);
    }
    
    public void add(int num) {
        if(arr.get(arr.size()-1) != 0) num = arr.get(arr.size()-1)*num;
        arr.add(num);
        last++;
        if(num == 0) lastZero = last;
    }
    
    public int getProduct(int k) {
        int prev = last - k;
        if(prev < lastZero) return 0;
        if(prev == lastZero) return arr.get(last);
        return arr.get(last) / arr.get(prev);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */