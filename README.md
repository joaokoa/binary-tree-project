# 🌳 Implementação de Árvore Binária em Java

[![Java](https://img.shields.io/badge/Java-17+-blue.svg)](https://www.oracle.com/java/)

Projeto acadêmico desenvolvido para a disciplina UDWMG 2025 - Centro Universitário UNA

## 🧩 Classes Implementadas

### `BinaryTreeNode.java`
```java
/**
 * Representa um nó da árvore binária
 */
public class BinaryTreeNode<T extends Comparable<T>> {
    public T data;
    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public int getDegree() {
        return (left != null ? 1 : 0) + (right != null ? 1 : 0);
    }
}
```

### `BinaryTree.java`
```java
/**
 * Implementação completa da Árvore Binária de Busca
 */
public class BinaryTree<T extends Comparable<T>> {
    private BinaryTreeNode<T> root;
    private int size;
    
    // Métodos implementados:
    // - insert(), remove(), contains()
    // - printInOrder(), printPreOrder(), printPostOrder()
    // - getHeight(), getNodeDegree()
    // - isStrictlyBinary(), isComplete(), isFull()
}
```
### `Main.java`
```java
/**
 * Classe de testes da implementação
 */
public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        
        // Inserção de valores
        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int val : values) {
            tree.insert(val);
        }
        
        // Travessias
        System.out.println("Em-ordem:");
        tree.printInOrder();
        
        // Operações
        System.out.println("\nAltura: " + tree.getHeight());
        System.out.println("É estritamente binária? " + tree.isStrictlyBinary());
    }
}
```
## 🚀 Como Usar

Clone o repositório:
```bash
git clone https://github.com/seu-usuario/binary-tree-project.git
cd binary-tree-project
```

Compile o projeto:
```bash
javac src/*.java -d bin/
```

Execute os testes:
```bash
java -cp bin/ Main
```


Saída esperada:
```bash
Em-ordem:
20 30 40 50 60 70 80 
Altura: 3
É estritamente binária? true
```

## 📊 Funcionalidades Implementadas

Operação	Método	Complexidade	Descrição

Inserção	insert()	O(log n)	Insere elementos mantendo a ABB

Remoção	remove()	O(log n)	Remove nós (3 casos diferentes)

Busca	contains()	O(log n)	Verifica existência de elemento

Em-ordem	printInOrder()	O(n)	Travessia esquerda-raiz-direita

Pré-ordem	printPreOrder()	O(n)	Travessia raiz-esquerda-direita

Pós-ordem	printPostOrder()	O(n)	Travessia esquerda-direita-raiz

Altura	getHeight()	O(n)	Calcula altura da árvore

Grau do nó	getNodeDegree()	O(log n)	Retorna número de filhos do nó


## 🔍 Verificação de Propriedades

Método	 Descrição

isStrictlyBinary()	Todos os nós têm 0 ou 2 filhos

isComplete()	Todos os níveis (exceto último) cheios

isFull()	Todos os nós folha no mesmo nível

isPerfect()	Árvore completa e cheia simultaneamente

## 📝 Testes Realizados
```java
// Teste de remoção
tree.remove(30);
System.out.println("\nApós remover 30:");
tree.printInOrder();

// Teste de propriedades
System.out.println("\nÉ completa? " + tree.isComplete());
System.out.println("É perfeita? " + tree.isPerfect());
```
Resultados:
```java
Após remover 30:
20 40 50 60 70 80 
É completa? false
É perfeita? false
```

## 📚 Documentação Completa

A documentação detalhada está disponível em docs/Binary Tree.pdf contendo:

Análise de complexidade

Diagramas da estrutura

Casos de teste completos

Referências bibliográficas

## 👨‍💻 Equipe
João Victor de Souza Gonçalves (92320247)

Lucas Gabriel Rodrigues Valadares (92310851)

Marcus Vinícius Fernandes Lima (92311773)

Natan Rodrigo Faria Vaz (92310556)
