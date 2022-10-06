//Time Complexity: O(n)
//Space Complexity: O(h)
//Did this code run on LeetCode: Yes

/*
 * The idea is using DFS technique. Perform DFS on left's left and right's right and then on left's right and right's left.
 * If both the DFS are returning true - then it is a symmetric tree.
 */

public class Symmetric {
    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left,root.right);
    }
    
    private boolean dfs(TreeNode left, TreeNode right)
    {
        if(left == null && right == null)
            return true;
        if(left == null || right == null || left.val != right.val)
        {
            return false;
        }
        
        return dfs(left.left,right.right) && dfs(left.right,right.left);
    }
}

//Aproach 2- using BFS with queue
/*
 * The idea is to add the root's left and right to the queue. Then, check if they are null, we should continue.
 * Instead of adding the elements and then doing the palindrome check, we do the check before adding the elements
 * This reduces the time complexity from O(n^2) to O(n)
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        
        while(!q.isEmpty())
        {
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            
            if(left == null && right == null)
                continue;
            if(left == null || right == null || left.val != right.val)
                return false;
            
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);
        }
        return true;
    }
}
