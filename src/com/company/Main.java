package com.company;
class Main
{
    static int sum = 0;
    static int temp_level = -2147483;
    private static Node node;

    static class Node
    {
        int value;
        Node left;
        Node right;
        int level = 0;
        public Node(int value){
            this.value = value;
            this.left = null;
            this.right = null;
        }
    };

    static Node add(int value)
    {
        node = new Node(value);
        return node;
    }
    static void sum(Node node,int level)
    {
        if (node == null) {
            return;
        }
        else {
            if (level == temp_level) {
                sum = sum + node.value;
            } else if (level > temp_level) {
                sum = node.value;
                temp_level = level;
            }
            sum(node.right, level + 1);
            sum(node.left, level + 1);
            return;
        }

    }

    public static void main(String[] args)
    {   Node root = add(1);
        root.left = add(2);
        root.right = add(3);
        root.left.left = add(4);
        sum(root, root.level);
        System.out.println(sum);
    }
}
