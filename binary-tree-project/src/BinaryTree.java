public class BinaryTree<T extends Comparable<T>> {
    private BinaryTreeNode<T> root;
    private int size;

    public BinaryTree() {
        this.root = null;
        this.size = 0;
    }

    // Método de inserção
    public void insert(T data) {
        root = insertRec(root, data);
        size++;
    }

    private BinaryTreeNode<T> insertRec(BinaryTreeNode<T> node, T data) {
        if (node == null) {
            return new BinaryTreeNode<>(data);
        }

        if (data.compareTo(node.data) < 0) {
            node.left = insertRec(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = insertRec(node.right, data);
        }

        return node;
    }

    // Método de remoção
    public boolean remove(T data) {
        int initialSize = size;
        root = removeRec(root, data);
        return size != initialSize;
    }

    private BinaryTreeNode<T> removeRec(BinaryTreeNode<T> node, T data) {
        if (node == null) {
            return null;
        }

        if (data.compareTo(node.data) < 0) {
            node.left = removeRec(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = removeRec(node.right, data);
        } else {
            if (node.left == null) {
                size--;
                return node.right;
            } else if (node.right == null) {
                size--;
                return node.left;
            }

            node.data = minValue(node.right);
            node.right = removeRec(node.right, node.data);
        }

        return node;
    }

    private T minValue(BinaryTreeNode<T> node) {
        T minValue = node.data;
        while (node.left != null) {
            minValue = node.left.data;
            node = node.left;
        }
        return minValue;
    }

    // Método de busca
    public boolean contains(T data) {
        return containsRec(root, data);
    }

    private boolean containsRec(BinaryTreeNode<T> node, T data) {
        if (node == null) {
            return false;
        }
        if (data.compareTo(node.data) == 0) {
            return true;
        }
        return data.compareTo(node.data) < 0 
            ? containsRec(node.left, data) 
            : containsRec(node.right, data);
    }

    // Métodos de travessia
    public void printInOrder() {
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(BinaryTreeNode<T> node) {
        if (node != null) {
            inOrderRec(node.left);
            System.out.print(node.data + " ");
            inOrderRec(node.right);
        }
    }

    public void printPreOrder() {
        preOrderRec(root);
        System.out.println();
    }

    private void preOrderRec(BinaryTreeNode<T> node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrderRec(node.left);
            preOrderRec(node.right);
        }
    }

    public void printPostOrder() {
        postOrderRec(root);
        System.out.println();
    }

    private void postOrderRec(BinaryTreeNode<T> node) {
        if (node != null) {
            postOrderRec(node.left);
            postOrderRec(node.right);
            System.out.print(node.data + " ");
        }
    }

    // Métodos de informação
    public int getHeight() {
        return calculateHeight(root);
    }

    private int calculateHeight(BinaryTreeNode<T> node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(calculateHeight(node.left), calculateHeight(node.right));
    }

    public int getNodeDegree(T data) {
        BinaryTreeNode<T> node = findNode(root, data);
        return node != null ? node.getDegree() : -1;
    }

    private BinaryTreeNode<T> findNode(BinaryTreeNode<T> node, T data) {
        if (node == null || data.compareTo(node.data) == 0) {
            return node;
        }
        return data.compareTo(node.data) < 0 
            ? findNode(node.left, data) 
            : findNode(node.right, data);
    }

    // Métodos de verificação
    public boolean isStrictlyBinary() {
        return isStrictlyBinaryRec(root);
    }

    private boolean isStrictlyBinaryRec(BinaryTreeNode<T> node) {
        if (node == null) {
            return true;
        }
        if ((node.left == null && node.right != null) || 
            (node.left != null && node.right == null)) {
            return false;
        }
        return isStrictlyBinaryRec(node.left) && isStrictlyBinaryRec(node.right);
    }

    public boolean isComplete() {
        int height = getHeight();
        return isCompleteRec(root, 0, height);
    }

    private boolean isCompleteRec(BinaryTreeNode<T> node, int level, int height) {
        if (node == null) {
            return level >= height - 1;
        }
        if (level == height - 1) {
            return node.left == null && node.right == null;
        }
        return isCompleteRec(node.left, level + 1, height) && 
               isCompleteRec(node.right, level + 1, height);
    }

    public boolean isFull() {
        int height = getHeight();
        return isFullRec(root, 0, height);
    }

    private boolean isFullRec(BinaryTreeNode<T> node, int level, int height) {
        if (node == null) {
            return level >= height;
        }
        if (level == height - 1) {
            return true;
        }
        if (node.left == null || node.right == null) {
            return false;
        }
        return isFullRec(node.left, level + 1, height) && 
               isFullRec(node.right, level + 1, height);
    }

    public boolean isPerfect() {
        int height = getHeight();
        return size == (Math.pow(2, height) - 1);
    }

    public int size() {
        return size;
    }
}