package _116_填充每个节点的下一个右侧节点指针;

import model.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/
 * 
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * 
 * 
 * @author lujinpeng
 * @date 2024-08-12 11:02
 */
class Solution {
    /**
     * 法一：特点分析，当前节点可以确认下层节点的链接关系
     *
     * @param root 二叉树的根节点
     * @return 连接后的树结构
     */
    public Node connect(Node<Integer> root) {
        if (root == null) {
            return null;
        }

        Node<Integer> head = root;
        while (head != null) {
            Node<Integer> currNode = head;
            while (currNode != null) {
                if (currNode.left != null) {
                    currNode.left.next = currNode.right;
                }
                if (currNode.right != null && currNode.next != null) {
                    currNode.right.next = currNode.next.left;
                }
                currNode = currNode.next;
            }
            
            head = head.left;
        }
        
        return root;
    }


    /**
     * 法二：层序遍历
     *
     * @param root 二叉树的根节点
     * @return 连接后的树结构
     */
    public Node connect2(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(queue.size() > 0) {
            int levelSize = queue.size();

            Node curr = queue.poll();
            this.addChild(curr, queue);
            for (int i = 1; i < levelSize; i++) {
                Node nextNode = queue.poll();
                this.addChild(nextNode, queue);
                curr.next = nextNode;
                curr = nextNode;
            }

        }

        return root;
    }

    private void addChild(Node node, Queue<Node> queue) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            queue.add(node.left);
        }
        if (node.right != null) {
            queue.add(node.right);
        }
    }


    /**
     * 法三：递归。循环不变量 --- 当前节点树最内侧的节点用 next 连接
     *
     * @param root 二叉树的根节点
     * @return 连接后的树结构
     */
    public Node connect3(Node root) {
        dfs(root);
        return root;
    }
    
    /**
     * 假设左右子树已经连接成功，当前节点只要将左右子树内侧相连即可
     *
     * @param root 二叉树的根节点
     */
    private void dfs(Node root) {
        if (root == null) {
            return;
        }

        Node prev = root.left;
        Node next = root.right;
        while (prev != null) {
            prev.next = next;
            prev = prev.right;
            next = next.left;
        }

        dfs(root.left);
        dfs(root.right);
    }
}