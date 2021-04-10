function Node(data, left=null, right=null) {
    this.data = data;
    this.left = left;
    this.right = right;
}

function BinarySearchTree() {
    this.root = null;
}

BinarySearchTree.prototype.addData = function (data) {
    let newNode = new Node(data);
    if(!this.root) {
        this.root = newNode;
    } else {
        insertNode(this.root, newNode);
    }
}

BinarySearchTree.prototype.removeData = function (data) {
    this.root = removeNode(this.root, data);
}

BinarySearchTree.prototype.getRootNode = function () {
    return this.root;
}

BinarySearchTree.prototype.findMinNode = function(node) {
    if(!node.left) {
        return node;
    } else {
        return this.findMinNode(node.left);
    }
}

function searchData(node, data) {
    if(!node) {
        return null;
    }
    if(data < node.data) {
        return this.searchData(node.left, data);
    } else if(data > node.data){
        return this.searchData(node.right, data);
    } else {
        return node;
    }
 }

function insertNode(node, newNode) {
    if(newNode.data < node.data) {
        if(!node.left) {
            node.left = newNode;
        } else {
            insertNode(node.left, newNode);
        }
    } else {
        if(!node.right) {
            node.right = newNode;
        } else {
            insertNode(node.right, newNode);
        }
    }
}

function removeNode(node, data) {
    if(!node) {
        return null;
    }
    if(data < node.data) {
        node.left = removeNode(node.left, data);
        return node;
    } else if(data > node.data){
        node.right = removeNode(node.right, data);
        return node;
    } else {
        if(!node.left && !node.right) {
            node = null;
            return node;
        }
        if(!node.left) {
            node = node.right;
            return node;
        } else if (!node.right) {
            node = node.left;
            return node;
        }

        let aux = this.findMinNode(node.right);
        node.data = aux.data;
        node.right = removeNode(node.right, aux.data);
        return node;
    }
}

let BST = new BinarySearchTree();

console.log(BST.getRootNode());

BST.addData(43);
BST.addData(34);
BST.addData(12);
BST.addData(46);

console.log(BST.getRootNode());

BST.removeData(46);

console.log(BST.getRootNode());