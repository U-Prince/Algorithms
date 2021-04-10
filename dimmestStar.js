class Graph {
    constructor(noOfVertices) {
        this.noOfVertices = noOfVertices;
        this.AdjList = new Map();
    }

    addVertex(v) {
        this.AdjList.set(v, []);
    }
     
    addEdge(v, w) {
        this.AdjList.get(v).push(w);
        this.AdjList.get(w).push(v);
    }
    
    printGraph() {
        var get_keys = this.AdjList.keys();
        for (var i of get_keys) {
            var get_values = this.AdjList.get(i);
            var conc = "";

            for (var j of get_values)
                conc += j + " ";

            console.log(i + " -> " + conc);
        }
    }

    bfs(startingNode) {

        
        var visited = [],value = {};
        for (var i = 0; i < this.noOfVertices; i++)
            visited[i] = false;

        var q = new Queue();

        visited[startingNode] = true;
        q.enqueue(startingNode);
        value[startingNode] =0;
        let min=startingNode;

       
        while (!q.isEmpty()) {
            
            
            var getQueueElement = q.dequeue();
            var count = value[getQueueElement] +1;
            

            var get_List = this.AdjList.get(getQueueElement);

            for (var i in get_List) {
                var neigh = get_List[i];

                if (!visited[neigh]) {
                    visited[neigh] = true;
                    value[neigh] = count;
                    if(value[neigh] > value[min]) {
                        min = neigh;
                    }
                    if(value[neigh] == value[min]) {
                        if(min > neigh) 
                            min = neigh;
                    }
                    console.log(neigh+'-----'+ count+'****'+min)
                    q.enqueue(neigh);
                }
            }
        }
        return min;
    }

}

class Queue {
    constructor() {
        this.items = [];
    }

    
    enqueue(element) {
        this.items.push(element);
    }

    dequeue() {
        if (this.isEmpty())
            return "Underflow";
        return this.items.shift();
    }

    front() {
        if (this.isEmpty())
            return "No elements in Queue";
        return this.items[0];
    }

    isEmpty() {
        return this.items.length == 0;
    }

    printQueue() {
        var str = "";
        for (var i = 0; i < this.items.length; i++)
            str += this.items[i] + " ";
        return str;
    }
}

var g = new Graph(6);
var vertices = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];

for (var i = 0; i < vertices.length; i++) {
    g.addVertex(vertices[i]);
}

g.addEdge(7, 2);
g.addEdge(7, 3);
g.addEdge(7, 6);
g.addEdge(7, 4);
g.addEdge(7, 10);
g.addEdge(3, 5);
g.addEdge(6, 8);
g.addEdge(6, 1);
g.addEdge(8, 9);

// g.addEdge(5, 6);
// g.addEdge(7, 1);
// g.addEdge(6, 4);
// g.addEdge(6, 3);
// g.addEdge(4, 7);
// g.addEdge(7, 2);


g.printGraph();
let res = g.bfs(7);

console.log('result=='+res);

