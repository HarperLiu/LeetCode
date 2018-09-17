package util;


/**
 * 设节点数为1，那么有1种形态的树
 * 设节点数为2，那么固定一个节点，就有放在左子树还是右子树，即h(2) = h(1)*h(0) + h(1)*h(0)
 * 设节点数为n,那么固定一个节点，剩下的n-1个节点可以0个在左，n-1个在右，或是1个在左，n-2个在右，以此类推。
 * 所以当n>=2时，可组成的二叉树数量为h(n)=h(0)*h(n-1)+h(1)*h(n-2)+...+h(n-1)*h(0)种
 * 上式为catalan数的递归式，通项公式为，C(n)=(1/(n+1))*((2*n)!/(n!*n!))
 */
public class Solution {
    public int numTrees(int n) {
        double c = (factorial(2*n)/((factorial(n)*factorial(n))));
        return (int)Math.round(c/(n+1));
    }
    public double factorial(int n){
        double res = 1;
        for(int i=1;i<=n;i++){
            res = res*i;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numTrees(19));
    }
}
