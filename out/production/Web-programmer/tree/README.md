# Tree

## BinaryTree

최대 두개의 노드들로 구성된 트리

### 트리 순회 (Tree Traversal)

1. 전위 순회(Pre-order Traversal)

노드 -> 왼쪽 서브트리 -> 오른쪽 서브트리 순으로 탐색한다.

- [Binary Tree Preorder Traversal](https://leetcode.com/problems/binary-tree-preorder-traversal/)

2. 중위 순회 (In-order Traversal)

왼쪽 서브트리 -> 노드 -> 오른쪽 서브트리

- [Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal/)

3. 후위 순회 (Post-order Traversal)

왼쪽 서브트리 -> 오른쪽 서브트리 -> 노드

- [Binary Tree Postorder Traversal](https://leetcode.com/problems/binary-tree-postorder-traversal/)

## BST (Binary Search Tree)

값을 삽입, 삭제, 검색하는데 효율적인 구조입니다.

### 특징

- 왼쪽 자식노드의 < 부모노드 < 오른쪽 자식노드
- 중복 X

### BST 삭제

- 그냥 삭제 (자식 노드 X)
- 왼쪽 노드에서 가장 큰 값 or 오른쪽 노드에서 가장 작은 값을 삭제한 자리에 대치 (자식 노드가 존재할 때)

> [BST의 삭제](https://m.blog.naver.com/PostView.nhn?blogId=minichuuuuu&logNo=220718464044&proxyReferer=https:%2F%2Fwww.google.com%2F) 참고

#### 문제
- [Delete Node in a BST](https://leetcode.com/problems/delete-node-in-a-bst/)