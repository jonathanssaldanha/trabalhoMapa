
package trabalhomapa4;

import java.util.ArrayList;


public class Graph {
    
    private Node[] nodes;
    private int noOfNodes;
    private Edge[] edges;
    private int noOfEdges;
    


    Graph(Rota ro[]) {
        this.edges = edges;
        
//        create all nodes ready to be updated with  the edges
        this.noOfNodes = calculateNoOfNodes(edges);
        this.nodes = new Node[this.noOfNodes];
        
        for(int n = 0; n < this.noOfNodes; n++){
            this.nodes[n] = new Node();
        }
        
        this.noOfEdges = edges.length;
        
        for(int edgeToAdd = 0; edgeToAdd < this.noOfEdges; edgeToAdd++){
            this.nodes[edges[edgeToAdd].getFromNodeIndex()].getEdges().add(edges[edgeToAdd]);
            this.nodes[edges[edgeToAdd].getToNodeIndex()].getEdges().add(edges[edgeToAdd]);
        }
    }
    
    private int calculateNoOfNodes(Edge[] edge){
        
        int noOfNodes = 0;
        for (Edge e : edges){
            if(e.getToNodeIndex() > noOfNodes)
                noOfNodes = e.getToNodeIndex();
            if(e.getFromNodeIndex() > noOfNodes)
                noOfNodes = e.getFromNodeIndex();
        }
        noOfNodes++;
        
        return noOfNodes;
    }

    public void calculateshortesDistances(){
        this.nodes[0].setDitanceFromSource(0);
        int nextNode = 0;
        
//        visitar todos
        for (int i = 0; i< this.nodes.length; i++){
            ArrayList<Edge> currentNodeEdges = this.nodes[nextNode].getEdges();
            
            for(int joinedEdge = 0; joinedEdge < currentNodeEdges.size(); joinedEdge++){
                int neighbourIndex = currentNodeEdges.get(joinedEdge).getNeighbourIndex(nextNode);
                
                if(!this.nodes[neighbourIndex].isVisited()){
                    int tentative = this.nodes[nextNode].getDitanceFromSource() + currentNodeEdges.get(joinedEdge).getLenght();
                
                    if(tentative < nodes[neighbourIndex].getDitanceFromSource()){
                        nodes[neighbourIndex].setDitanceFromSource(tentative);
                    }
                }
                        
            }    
//            todos os vizinhos checados
            
            nodes[nextNode].setVisited(true);
            
            nextNode = getNodeShortesDistanced();
        }
    }
    
    private int getNodeShortesDistanced(){
        int storedNodeIndex = 0;
        int storedDist = Integer.MAX_VALUE;
        
        for(int i = 0; i < this.nodes.length; i++){
            int currentDist = this.nodes[i].getDitanceFromSource();
            
            if(!this.nodes[i].isVisited() && currentDist < storedDist){
                storedDist = currentDist;
                storedNodeIndex = i;
            }
        }
        return storedNodeIndex;
    }
    
//    resultado
    public void printResult(){
        String output = "number of nodes = " + this.noOfNodes;
        output += "\nNumber of edges = " + this.noOfEdges;
        
        for(int i = 0; i < this.nodes.length; i++){
            output += ("\nThe shortest distance from node 0 to node " + i + " is " + nodes[i].getDitanceFromSource());
        }
        System.out.println(output);
    }
    
    public Node[] getNodes() {
        return nodes;
    }

    public void setNodes(Node[] nodes) {
        this.nodes = nodes;
    }

    public int getNoOfNodes() {
        return noOfNodes;
    }

    public void setNoOfNodes(int noOfNodes) {
        this.noOfNodes = noOfNodes;
    }

    public Edge[] getEdges() {
        return edges;
    }

    public void setEdges(Edge[] edges) {
        this.edges = edges;
    }

    public int getNoOfEdges() {
        return noOfEdges;
    }

    public void setNoOfEdges(int noOfEdges) {
        this.noOfEdges = noOfEdges;
    }
}
