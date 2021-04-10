class Node {
    constructor(data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BinarySearchTree {
     
    constructor() {
        this.root = null;
    }

    insertData(data) {
        let nNode = new Node(data);
        if(this.root) {
            this.insertNode(this.root, nNode);
        } else {
            this.root = nNode;
        }
    }

    insertNode(node, nNode) {
        if(nNode.data < node.data) {
            if(node.left == null) {
                node.left = nNode;
            } else {
                this.insertNode(node.left, nNode);
            }
        } else {
            if(node.right == null) {
                node.right = nNode;
            } else {
                this.insertNode(node.right, nNode);
            }
        }
    }

    inOrder(root) {
        if(root!=null) {
            this.inOrder(root.left);
            console.log(root.data);
            this.inOrder(root.right);
        }
    }

    getRootNode() {
        return this.root;
    }

    printTree(root) {
        if(root!=null) {
            console.log(root.data);
        }
        if(root.left!=null) {
            console.log('|')
        }
    }
}

let bt = new BinarySearchTree();
bt.insertData(4);
bt.insertData(4);
bt.insertData(3);
bt.inOrder(bt.getRootNode())

