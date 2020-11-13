# data-structures-java

Data Structures in Java.

A data structure is a particular way of organizing data in a computer so that it can be used effectively.

## Topics

### Linear Data Structures

A Linear data structure have data elements arranged in sequential manner and each member element is connected to its previous and next element.

This connection helps to traverse a linear data structure in a single level and in single run.

Such data structures are easy to implement as computer memory is also sequential.

- Array
  1. The capacity cannot be modified after creation, so we may need a dynamic array.
  - DynamicArray
    1. Expansion may waste memory, linked list can solve it.
- Linked List
  1. The elements are not store at contiguous memory locations.
  2. A linked list consists of nodes where each node contains a data field and a reference to the next node in the list.
  - Doubly Linked List
    1. A linked list where each node contains a reference to the prev node.
    2. Had a better performance than singly linked list when find node by an index.
  - (Singly / Doubly) Circular Linked List
- Stack
  1. First In Last Out
  2. interface: push pop peek
  3. use case: redo undo
- Queue
  1. First In First Out
  2. interface: enQueue deQueue front
  3. use case: 
      - It's better to implement it with a doubly linked list.
      - Queue is an interface in java util, implements by LinkedList.
  4. Circle Queue: front + array
- Hashing

### Non-linear Data Structures

A non-linear data structure has no set sequence of connecting all its elements and each element can have multiple paths to connect to other elements.

Such data structures supports multi-level storage and often cannot be traversed in single run.

Such data structures are not easy to implement bu are more efficient in utilizing computer memory.

#### Tree Data Structures

- degree: number of subtrees
- depth: max number from root to last subtree
- height: same with depth

- Binary Tree
  - max degree is 2
  - orderly
  - non-blank binary tree
  - Proper Binary Tree: degree is 0 or 2
  - Perfect Binary Tree
  - Full Binary Tree
  - Complete Binary Tree
  - BST: Binary Search Tree
    - search number in dynamic array
      - non-orderly - traverse O(n)
      - orderly - 二分 O(logn), write O(n)
    - left subtree < every node (can be compared to, not null) < right subtree
    - Preorder traversal
      - root -> left/right -> right/left
    - In-order traversal
      - left/right -> root -> right/left
      - orderly
    - Post-order traversal
      - left/right -> right/left -> root
    - Level-Order traversal
      - root -> left -> right -> next level left ...
      - based on Queue: while (!q.empty()) { r = q.deQ() -> print(r) -> q.enQ(r.left) -> q.enQ(r.right) }
- AVL Tree
- Red-Black Tree
- B Tree
- Heap
- Trie
- Huffman Tree

#### Graph Data Structures

## Reference

- [Data structures](https://www.geeksforgeeks.org/data-structures/)
- [Difference between Linear and Non-linear Data Structures](https://www.tutorialspoint.com/difference-between-linear-and-non-linear-data-structures)
