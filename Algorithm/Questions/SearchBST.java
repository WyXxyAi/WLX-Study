package Algorithm.Questions;

public class SearchBST {
    public static class TreeNode {
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

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        if (root.val==val||root==null){
            return root;
        }else{
            root = root.val>val?root.left:root.right;
            return searchBST(root,val);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4,new TreeNode(2,new TreeNode(1),new TreeNode(3)),new TreeNode(7));
        System.out.println(searchBST(root,1).toString());
    }
}
