import java.util.LinkedList;
import java.util.Queue;

public class binarytree {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data)
        {
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    static class BinaryTree
    {
        static int idx=-1; //indes=idx
        public static Node buildTree(int nodes[])
        {
            idx++;
            if(nodes[idx]==-1)
            {
                return null;
            }
            Node newNode=new Node(nodes[idx]);
            newNode.left=buildTree(nodes);
            newNode.right=buildTree(nodes);

            return newNode;
        }
    }
    
    //System.out.print("PreOrder Traversal");

    public static void preOrder(Node root)
    {
        if(root ==null)
        {
            return ;
        }
        
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void InOrder(Node root)
    {
        if(root ==null)
        {
            return ;
        }
       // System.out.print("InOrder Traversal");
        InOrder(root.left);
        System.out.print(root.data+" ");
        InOrder(root.right);
    }

    public static void Postorder(Node root)
    {
        if(root ==null)
        {
            return ;
        }
       // System.out.print("PostOrder Traversal");
        Postorder(root.left);
        
        Postorder(root.right);
        System.out.print(root.data+" ");
        
    }

    //levelorderTraversal
    /**
     * @param root
     */
    public static void LevelOrder(Node root)
    {
       
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node currNode=q.remove();
            if(currNode==null)
            {
                System.out.println(" ");
                if(q.isEmpty())
                {
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{
                System.out.print(currNode.data+" ");
                if(currNode.left!=null)
                {
                    q.add(currNode.left);
                }
                if(currNode.right!=null)
                {
                    q.add(currNode.right);
                }
            }
           
        
            
        }
    }

    public static int CountNodes(Node root)
    {
        if(root ==null)
        {
            return 0;
        }
        int leftNode=CountNodes(root.left);
        int rightNode=CountNodes(root.right);
        return leftNode+rightNode+1;
    }
    public static int SumOfNodes(Node root)
    {
        if(root ==null)
        {
            return 0;
        }
        int leftNode=SumOfNodes(root.left);
        int rightNode=SumOfNodes(root.right);
        return leftNode+rightNode+root.data;
    }

    public static int height(Node root)
    {
        if(root ==null)
        {
            return 0;
        }
        int leftheight=height(root.left);
        int rightheight=height(root.right);
        int maxheight=Math.max(leftheight, rightheight)+1;
        return maxheight;
    }

    public static int diameter(Node root)
    {
        if(root ==null)
        {
            return 0;
        }
        int dim1=diameter(root.left);
        int dim2=diameter(root.right);
        int dim3=height(root.left)+height(root.right)+1;
        return Math.max(dim3,Math.max(dim1, dim2));
    }


    public static void main(String[] args)
    {
        int[] nodes={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree=new BinaryTree();
        Node root=tree.buildTree(nodes);
        System.out.print("PreOrder Traversal : ");
        preOrder(root);
        System.out.println(" ");
        System.out.print("InOrder Traversal : ");
        InOrder(root);
        System.out.println(" ");
        System.out.print("PostOrder Traversal : ");
        Postorder(root);
        System.out.println(" ");
        System.out.println("LevelOrder Traversal : ");
        LevelOrder(root);
        System.out.println(" ");
        
        System.out.print("Total noof Nodes : ");
        System.out.println(CountNodes(root));

        System.out.print("Total sum of Nodes : ");
        System.out.println(SumOfNodes(root));

        System.out.print("Height of the tree : ");
        System.out.println(height(root));


        System.out.print("Diameter of the tree  : ");// no.of nodes in the longest path b\w any 2 nodes
        System.out.println(diameter(root));

    }

    
}
