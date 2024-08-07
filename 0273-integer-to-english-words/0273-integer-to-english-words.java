class Solution {
    Map<Integer, String> map = new HashMap<>();
    public String helper(int num) {
        if(num == 0) return "";
        if(num<=20) return map.get(num);
        if(num<100) {
            if(num%10 > 0) return map.get((num/10)*10) + " " + map.get(num%10);
            else return map.get(num);
        }
        if(num>=100 && num<1000) {
            String res = helper(num/100);
            num%=100;
            res = res+" "+map.get(100);
            if(num>0) res = res+" " + helper(num);
            return res;
        }
        return "test";
    }
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(9, "Nine");
        map.put(10, "Ten");
        map.put(11, "Eleven");
        map.put(12, "Twelve");
        map.put(13, "Thirteen");
        map.put(14, "Fourteen");
        map.put(15, "Fifteen");
        map.put(16, "Sixteen");
        map.put(17, "Seventeen");
        map.put(18, "Eighteen");
        map.put(19, "Nineteen");
        map.put(20, "Twenty");
        map.put(30, "Thirty");
        map.put(40, "Forty");
        map.put(50, "Fifty");
        map.put(60, "Sixty");
        map.put(70, "Seventy");
        map.put(80, "Eighty");
        map.put(90, "Ninety");
        map.put(100, "Hundred");
        map.put(1000, "Thousand");
        map.put(1000000, "Million");
        map.put(1000000000, "Billion");
        String ans = "";
        if(num >= (int)1e9) {
            int val = num/(int)1e9;
            ans = ans+(map.get(val))+" "+map.get((int)1e9);
            num%=(int)1e9;
        }
        if(num>=(int)1e6) {
            int val = num/(int)1e6;
            if(!ans.equals("")) ans+=" ";
            ans = ans+(helper(val))+" "+map.get((int)1e6);
            
            num%=(int)1e6;
        }
        if(num>=1000) {
            int val = num/1000;
            if(!ans.equals("")) ans+=" ";
            ans = ans+(helper(val)) + " " +map.get(1000);
            num%=1000;
        }
        if(num>=100) {
            int val = num/100;
            if(!ans.equals("")) ans+=" ";
            ans = ans+(helper(val)) + " " + map.get(100);
            num%=100;
        }
        if(num>0) {
            if(!ans.equals("")) ans+=" ";
            ans = ans+helper(num);
        }
        return ans;
    }
}