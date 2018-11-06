package JewelsAndStones;

public class Solution {
    public int numJewelsInStones(String J, String S) {
        int sum = 0;
        for(int i=0;i<S.length();i++){
            for(int j=0;j<J.length();j++){
                if(S.charAt(i)==J.charAt(j)){
                    sum++;
                }
            }
        }
        return sum;
    }
}
