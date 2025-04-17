public class BinaryTreeNode<T extends Comparable<T>> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    /**
     * Retorna o grau do nó (número de filhos)
     * @return 0 (folha), 1 (um filho) ou 2 (dois filhos)
     */
    public int getDegree() {
        int degree = 0;
        if (left != null) degree++;
        if (right != null) degree++;
        return degree;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}