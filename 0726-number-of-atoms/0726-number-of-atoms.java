class Solution {
    public String countOfAtoms(String formula) {
        char arr[] = formula.toCharArray();
        /**
            stack of freq maps
            loop over the string
            pick up element:
                single character, double character
            take the count:
                if nothing is there [string end / no digit] then count is 1
                if digit is present then start taking note of the count of current element
            keep track in a global map [first map in stack] Only treemap, all others will be plain Hashmap
            when parentheses opens:
                create a new map and push into stack
            when one closes:
                take the count of the parentheses and multiply each entry with that value
                then pop it and loop over each entry and update the map at the stack top
        */
        Stack<Map<String, Integer>> st = new Stack<>();
        int n = arr.length;
        st.push(new TreeMap<>());
        for(int i=0; i<n;) {
            if(arr[i] == '(') {
                st.push(new HashMap());
                i++;
            }
            else if(arr[i] == ')') {
                Map<String, Integer> temp = st.pop();
                i++;
                int count = 0;
                while(i<n && arr[i] <= '9' && arr[i] >= '0') {
                    count*=10;
                    count += (arr[i] - '0');
                    i++;
                }
                if(count == 0) count = 1;
                for(Map.Entry<String, Integer> entry:temp.entrySet()) {
                    st.peek().put(entry.getKey(), st.peek().getOrDefault(entry.getKey(), 0) + entry.getValue()*count);
                }
            }
            else {
                String element = ""+arr[i];
                int count = 0;
                i++;
                if(i<n) {
                    if(arr[i] <= 'z' && arr[i] >= 'a') {
                        element+=arr[i];
                        i++;
                    }
                    while(i<n && arr[i] <= '9' && arr[i] >= '0') {
                        count*=10;
                        count += (arr[i] - '0');
                        i++;
                    }
                }
                if(count == 0) count = 1;
                st.peek().put(element, st.peek().getOrDefault(element, 0) + count);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, Integer> entry:st.peek().entrySet()) {
            sb.append(entry.getKey());
            if(entry.getValue()>1) sb.append(entry.getValue());
        }
        return new String(sb);
    }
}