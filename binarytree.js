function Node(data, left=null, right=null) {
    this.data = data;
    this.left = left;
    this.right = right;
}

function BinaryTree() {
    this.root = null;
}

BinaryTree.prototype.addData = function (data) {
    let newNode = new Node(data);
    if(!this.root) {
        this.root = newNode;
    } else {
        insertNode(this.root, newNode);
    }
}

function insertNode(node, newNode) {
    if(!node.left) {
        node.left = newNode;
    } else if(!node.right) {
        node.right = newNode;
    } else {
        
    }
}