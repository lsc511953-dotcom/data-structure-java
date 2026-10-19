import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class MyBinaryTree {
    public static class TreeNode{
        char val;
        TreeNode left;
        TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }
    TreeNode root;

    public void createTree() {
        TreeNode treeNodeA = new TreeNode('A');
        TreeNode treeNodeB = new TreeNode('B');
        TreeNode treeNodeC = new TreeNode('C');
        TreeNode treeNodeD = new TreeNode('D');
        TreeNode treeNodeE = new TreeNode('E');
        TreeNode treeNodeF = new TreeNode('F');
        TreeNode treeNodeG = new TreeNode('G');
        TreeNode treeNodeH = new TreeNode('H');

        //添加引用关系
        treeNodeA.left = treeNodeB;
        treeNodeA.right = treeNodeC;
        treeNodeB.left = treeNodeD;
        treeNodeB.right = treeNodeE;
        treeNodeC.left = treeNodeF;
        treeNodeC.right = treeNodeG;
        treeNodeE.right = treeNodeH;

        root = treeNodeA;
    }

    //先序遍历
    public void preOrder(TreeNode root) {
        //确定边界
        if(root == null) {
            return;
        }
        //采用根左右
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    //中序遍历
    public void inOrder(TreeNode root) {
        //确定边界
        if(root == null) {
            return;
        }
        //采用左根右
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    //后序遍历
    public void postOrder(TreeNode root) {
        //确定边界
        if(root == null) {
            return;
        }
        //采用左右根
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    //层序遍历
    public void levelOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        //根节点入队
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.print(cur.val + " ");
            if(cur.left != null) {
                queue.offer(cur.left);
            }
            if(cur.right != null ) {
                queue.offer(cur.right);
            }
        }

    }

    public TreeNode getRoot() {
        return root;
    }

    //获取节点个数
    //节点个数 = 左子树节点个数 + 右子树节点个数 + 1
    public int getNodeCount(TreeNode root) {
        //确定边界
        if(root == null) {
            return 0;
        }
        return getNodeCount(root.left) + getNodeCount(root.right) + 1;
    }

    //获取叶子节点个数
    public int getLeafNodeCount(TreeNode root) {
        //确定边界
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        return getLeafNodeCount(root.left) + getLeafNodeCount(root.right);
    }

    //获取二叉树的高度
    //整颗二叉树的高度等于左右子树中的最大值 + 1
    public int getHeight(TreeNode root) {
        //确定边界
        if(root == null) {
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return (Math.max(left,right)) + 1;
    }

    //获取第k层节点的个数
    public int getLevelNodeCount(TreeNode root,int k) {
        if(root == null) {
            return 0;
        }
        if(k == 1) {
            return 1;
        }
        return getLevelNodeCount(root.left,k - 1) + getLevelNodeCount(root.right,k - 1);
    }

    //查找值为val的节点
    public TreeNode find(TreeNode root,char val) {
        if(root == null) {
            return null;
        }
        //采用前序遍历
        if(root.val == val) {
            return root;
        }

        TreeNode res = find(root.left,val);
        if(res != null) {
            return res;
        }
        return find(root.right,val);
    }

    //判断是否是完全二叉树
    public boolean isCompleteTree(TreeNode root) {
        if(root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur != null) {
                queue.offer(cur.left);
                queue.offer(cur.right);
            }else{
                break;
            }
        }

        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(cur != null) {
                return false;
            }
        }
        return true;
    }
}
