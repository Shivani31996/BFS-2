import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Approach 1 = BFS Level Order Traversal
//Time Complexity: O(n)
//Space Complexity: O(n)
public class RightSideView {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        
        if(root == null)
            return result;
        
        q.add(root);
        
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i = 0; i < size;i++)
            {
                TreeNode curr = q.poll();
                if(i == size - 1)
                {
                    result.add(curr.val);
                }
                if(curr.left != null)
                    q.add(curr.left);
                if(curr.right != null)
                {
                    q.add(curr.right);
                }
            }
        }
        return result;
    }
}

//DFS
//Time Complexity: O(n)
//Space Complexity: O(h) - recursive Stack space
/*
 * Traversing on the right node first so that you do not have to replace anything
 */
class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        
        if(root == null)
        {
            return result;
        }
        
        dfs(root,0);
        return result;
    }
    
    private void dfs(TreeNode root, int level)
    {
        if(root == null)
        {
            return;
        }
        if(level == result.size())
        {
            result.add(root.val);
        }
        dfs(root.right,level + 1);
        dfs(root.left, level + 1);
    }
}

/*
 * Approach 3 - Performing DFS on left child first and then setting the value of that level with the right
 * node value
 */

class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        
        if(root == null)
        {
            return result;
        }
        
        dfs(root,0);
        return result;
    }
    
    private void dfs(TreeNode root, int level)
    {
        if(root == null)
        {
            return;
        }
        if(level == result.size())
        {
            result.add(root.val);
        }
        else
        {
            result.set(level,root.val);
        }
        dfs(root.left, level + 1);
        dfs(root.right,level + 1);

    }
}