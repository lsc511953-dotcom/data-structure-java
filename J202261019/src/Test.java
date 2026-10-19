

public class Test {
    public static void main(String[] args) {
        MyBinaryTree myBinaryTree = new MyBinaryTree();
        myBinaryTree.createTree();
        System.out.println("------二叉树遍历开始------");
        System.out.println("前序遍历");
        myBinaryTree.preOrder(myBinaryTree.getRoot());
        System.out.println("\n中序遍历");
        myBinaryTree.inOrder(myBinaryTree.getRoot());
        System.out.println("\n后序遍历");
        myBinaryTree.postOrder(myBinaryTree.getRoot());
        System.out.println("\n层序遍历");
        myBinaryTree.levelOrder(myBinaryTree.getRoot());
        System.out.println("\n------二叉树遍历结束------");


        System.out.println("获取树中节点个数");
        System.out.println(myBinaryTree.getNodeCount(myBinaryTree.getRoot()));
        System.out.println("获取叶子节点个数");
        System.out.println(myBinaryTree.getLeafNodeCount(myBinaryTree.getRoot()));
        System.out.println("获取树的高度");
        System.out.println(myBinaryTree.getHeight(myBinaryTree.getRoot()));
        System.out.println("获取第k层节点个数");
        System.out.println(myBinaryTree.getLevelNodeCount(myBinaryTree.getRoot(), 3));
        System.out.println("查找值为val的节点");
        System.out.println(myBinaryTree.find(myBinaryTree.getRoot(),'A'));
        System.out.println("判断是否是完全为二叉树");
        System.out.println(myBinaryTree.isCompleteTree(myBinaryTree.getRoot()));
    }
}
