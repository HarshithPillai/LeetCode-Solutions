class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] arr1 = sentence1.split(" "), arr2 = sentence2.split(" ");
        if(arr1.length < arr2.length) return areSentencesSimilar(sentence2, sentence1);
        int n = arr1.length, m = arr2.length, l1 = 0, l2 = 0, r1 = n-1, r2 = m-1;
        while(l2 <= r2) {
            if(arr1[l1].equals(arr2[l2])) {
                l1++; l2++;
            } else if(arr1[r1].equals(arr2[r2])) {
                r1--; r2--;
            } else return false;
        }
        return true;
    }
}