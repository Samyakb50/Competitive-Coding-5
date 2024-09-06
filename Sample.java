// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

Here we will be iterating over the tree and will maintain the level we are at right now. If the value at that level is not 
there in the list then we will put the first found value at that level in the list else we will compare the new value of that
 level with the previously stored value...if the new value is greater we will update it else we will keep it the same.This is
  the recursive solution

CODE:

class Solution {

   public List<Integer> largestValues(TreeNode root) {

       List<Integer> result = new ArrayList<>();

       findMax(root,result,0);

       return result;

   }

   public void findMax(TreeNode root,List<Integer> result,int level){

       if(root==null) 
        return;

       if(result.size()==level){

           result.add(root.val);

       }
       else {
        result.set(level,result.get(level)<root.val?root.val:result.get(level));

       }
        
       findMax(root.left,result,level+1);

       findMax(root.right,result,level+1);

   }

}

There is iterative solution as well i.e. we will be storing all the values of every level in the queue then we will be
 finding the largest of all the values for every level and then we will proceed the same .This is iterative approach

CODE:

Iterative Solution:

class Solution {

   public List<Integer> largestValues(TreeNode root) {

       List<Integer> result = new ArrayList<>();
       Queue<TreeNode> q = new LinkedList<>();
       if(root==null) return result;
       q.add(root);
       while(!q.isEmpty()){
           Integer max = null;
           int size = q.size();
           for(int i=0;i<size;i++){
               TreeNode node = q.poll();
               if(max==null)
                   max=node.val;
               if(max<node.val)
                   max=node.val;
               if(node.left!=null)
                   q.add(node.left);
               if(node.right!=null)
                   q.add(node.right);
           }
           result.add(max);
       }
       return result;

   }

}