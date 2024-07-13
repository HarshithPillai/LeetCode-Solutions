class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        int[][] robots = new int[n][4];
        for(int i=0; i<n; i++) {
            robots[i][0] = positions[i];
            robots[i][1] = healths[i];
            robots[i][2] = (directions.charAt(i) == 'L')? -1 : 1;
            robots[i][3] = i;
        }
        Arrays.sort(robots, (a, b) -> Integer.compare(a[0], b[0]));
        // for(int i=0; i<4; i++) {
        //     for(int j = 0; j<n; j++) {
        //         System.out.print(robots[j][i] + " ");
        //     }
        //     System.out.println("");
        // }
        Stack<int[]> st = new Stack<>();
        /**
            stack empty:
                left:
                    push into stack as is
                right:
                    same push into stack as is
            stack not empty:
                left:
                    top of stack is left:
                        push into stack as is
                    top of stack is right:
                        if health of both is same:
                            pop from stack and continue, we will ignore the incoming robot as well as the both collided
                        if health of stack top is more:
                            we ignore the incoming robot as it is destroyed and reduce the health of stack top by 1
                        if health of stack top is less:
                            we pop the stack top and push in the new incoming one with health decreased by 1
                right:
                    top of stack is left:
                        push as is
                    top of stack is right:
                        push as is
        */
        for(int i=0; i<n; i++) {
            if(st.isEmpty()) {
                // System.out.print("- - ");
                st.push(robots[i]);
            } else {
                // System.out.print(st.peek()[3] + " - ");
                if(robots[i][2] == -1) {
                    if(st.peek()[2] == -1) {
                        st.push(robots[i]);
                    } else {
                        int flag = 0;
                        while(!st.isEmpty() && st.peek()[2] == 1) {
                                // if(robots[i][3] == 17) System.out.print(" lol "+ robots[i][1]);
                            if(st.peek()[1] == robots[i][1]) {
                                st.pop();
                                flag = 1;
                                break;
                            } else if(st.peek()[1] > robots[i][1]) {
                                st.peek()[1]--;
                                flag = 1;
                                break;
                            } else {
                                st.pop();
                                robots[i][1]--;
                            }
                        }
                        if(flag == 0) {
                            // it survived?
                            st.push(robots[i]);
                        }
                    }
                } else {
                    st.push(robots[i]);
                }
                
            }
            // if(st.isEmpty()) System.out.println(" - ");
            // else System.out.println(st.peek()[3] + " "+ st.peek()[1]);
        }

        List<int[]> temp = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        while(!st.isEmpty()) temp.add(st.pop());
        temp.sort((a,b) -> Integer.compare(a[3],b[3]));
        for(int[] arr:temp) ans.add(arr[1]);
        return ans;
    }
}