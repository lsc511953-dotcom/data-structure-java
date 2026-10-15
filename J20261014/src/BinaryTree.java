import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree{
    private static class TreeNode{
        char val;
        TreeNode left;
        TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }
    private TreeNode root;

    //先手动创一个二叉树
    public void createTree() {
        TreeNode treeNodeA = new TreeNode('A');
        TreeNode treeNodeB = new TreeNode('B');
        TreeNode treeNodeC = new TreeNode('C');
        TreeNode treeNodeD = new TreeNode('D');
        TreeNode treeNodeE = new TreeNode('E');
        TreeNode treeNodeF = new TreeNode('F');
        TreeNode treeNodeG = new TreeNode('G');
        TreeNode treeNodeH = new TreeNode('H');

        //添加引用信息
        treeNodeA.left = treeNodeB;
        treeNodeA.right = treeNodeC;
        treeNodeB.left = treeNodeD;
        treeNodeB.right = treeNodeE;
        treeNodeC.left = treeNodeF;
        treeNodeC.right = treeNodeG;
        treeNodeE.right = treeNodeH;

        this.root = treeNodeA;
    }

    //前序遍历(根左右)
    public void preOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.print(root.val + " ");//根
        preOrder(root.left);
        preOrder(root.right);
    }

    //中序遍历(左根右)
    public void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    //后序遍历(左右根)
    public void postorder(TreeNode root) {
        if(root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
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
            if(cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }

    //获取节点个数
    private int nodeSize = 0;
    public void size(TreeNode root) {
        if(root == null) {
            return;
        }
        nodeSize++;
        size(root.left);
        size(root.right);
    }

    //获取节点个数方法二(子问题思路)
    public int size2(TreeNode root) {
        if(root == null) {
            return 0;
    }
        return size2(root.left) + size2(root.right) + 1;
    }

    //获取叶子节点个数
    private int leafNodeSize = 0;
    public void getLeafNodeCount(TreeNode root) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            leafNodeSize++;
        }
        getLeafNodeCount(root.left);
        getLeafNodeCount(root.right);
    }

    //获取叶子节点个数方法二
    public int getLeafNodeCount2(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        return getLeafNodeCount2(root.left) + getLeafNodeCount2(root.right);
    }

    //获取第k层的节点个数
    public int getLeafCount(TreeNode root,int k) {
        if(root == null || k <= 0) {
            return 0;
        }
        if(k == 1) {
            return 1;
        }
        return getLeafCount(root.left,k - 1) + getLeafCount(root.right,k - 1);
    }

    //获取二叉树的高度
    public int getHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.max(getHeight(root.left),getHeight(root.right)) + 1;
    }


    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.createTree();
        System.out.println("二叉树遍历演示");
        System.out.println("前序遍历");
        binaryTree.preOrder(binaryTree.root);
        System.out.println("\n中序遍历");
        binaryTree.inOrder(binaryTree.root);
        System.out.println("\n后序遍历");
        binaryTree.postorder(binaryTree.root);
        System.out.println("\n层序遍历");
        binaryTree.levelOrder(binaryTree.root);
        System.out.println();

        //获取节点个数
        binaryTree.size(binaryTree.root);
        System.out.println(binaryTree.nodeSize);

        System.out.println(binaryTree.size2(binaryTree.root));

        //获取叶子结点个数
        binaryTree.getLeafNodeCount(binaryTree.root);
        System.out.println(binaryTree.leafNodeSize);

        System.out.println(binaryTree.getLeafNodeCount2(binaryTree.root));

        //获取第k层节点个数
        System.out.println(binaryTree.getLeafCount(binaryTree.root, 4));

        //获取二叉树的高度
        System.out.println(binaryTree.getHeight(binaryTree.root));//4
    }
}
