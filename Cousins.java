//Time Complexity: O(n)
//Space Complexity: O(h)
//Approach: The idea is to traverse over the entire tree over each node storing the parent and the level details
//Cousin nodes are those who have different parents but are on the same level.

//DFS
public class Cousins {

     public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode() {}
             TreeNode(int val) { this.val = val; }
             TreeNode(int val, TreeNode left, TreeNode right) {
                 this.val = val;
                 this.left = left;
                 this.right = right;
        }

    TreeNode x_parent;
    TreeNode y_parent;
    int x_ht;
    int y_ht;

public boolean isCousins(TreeNode root, int x, int y) {
    if(root == null)
    {
        return false;
    }
    
    dfs(root, null, 0,x,y);
    
    return x_parent != y_parent && x_ht == y_ht;
}

private void dfs(TreeNode root, TreeNode parent, int level, int x, int y)
{
    if(root == null)
    {
        return;
    }
    
    if(root.val == x)
    {
        x_parent = parent;
        x_ht = level;
    }
    
    if(root.val == y)
    {
        y_parent = parent;
        y_ht = level;
    }
    
    dfs(root.left,root,level + 1,x,y);
    dfs(root.right,root,level + 1, x,y);
}
}

//BFS
/*
 * Algorithm:
 * Add the root into the queue, check if the value of root is equal to x or y. If yes, set the respective flag.
 * now, check if the babies of the parent are not null, if not null, check if the babies of the same parent are equal to x & y.
 * If yes, return false. Now add the babies of the parent to the queue. In the end, check if either of flag is true - return false else
 * return true;
 */

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
            
        while(!q.isEmpty())
        {
            int size = q.size();
            boolean x_flag = false;
            boolean y_flag = false;
            
            for(int i = 0; i < size;i++)
            {
                TreeNode curr = q.poll();
                if(curr.val == x)
                    x_flag = true;
                if(curr.val == y)
                    y_flag = true;
                
                if(curr.left != null && curr.right != null)
                {
                    if(curr.left.val == x && curr.right.val == y)
                        return false;
                    if(curr.left.val == y && curr.right.val == x)
                        return false;
                }
                
                if(curr.left != null)
                    q.add(curr.left);
                
                if(curr.right != null)
                    q.add(curr.right);
            }
                if(x_flag && y_flag)
                    return true;
                if(x_flag || y_flag)
                    return false;
            }
                    return false;
    }
}
