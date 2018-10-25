class Graph {
    class Node {
        var connectedNodes: List[Graph#Node] = Nil
        def connectTo(node: Graph#Node) {
        if (connectedNodes.find(node.equals).isEmpty) {
            connectedNodes = node :: connectedNodes
        }
        }
  }
    var nodes: List[Graph#Node] = Nil
        def newNode: Node = {
            val res = new Node
            nodes = res :: nodes
            res
        }
}