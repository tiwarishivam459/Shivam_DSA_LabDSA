package binarysearchtree;

import java.util.*;

class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

public class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        root = null;
    }

    // This method finds a pair of nodes in the BST that sum up to the given value
    public boolean findPair(Node root, int sum, HashSet<Integer> set) {
        if (root == null) {
            return false;
        }

        if (findPair(root.left, sum, set)) {
            return true;
        }

        if (set.contains(sum - root.key)) {
            System.out.println("Pair is (" + root.key + ", " + (sum - root.key) + ")");
            return true;
        } else {
            set.add(root.key);
        }

        return findPair(root.right, sum, set);
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.root = new Node(50);
        tree.root.left = new Node(30);
        tree.root.right = new Node(70);
        tree.root.left.left = new Node(20);
        tree.root.left.right = new Node(40);
        tree.root.right.left = new Node(60);
        tree.root.right.right = new Node(80);

        int sum = 130;
        HashSet<Integer> set = new HashSet<Integer>();

        if (!tree.findPair(tree.root, sum, set)) {
            System.out.println("Nodes are not found");
        }
    }
}
