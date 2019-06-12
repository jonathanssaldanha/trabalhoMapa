
package trabalhomapa4;

import java.util.ArrayList;


public class Node {
//    Distancia da fonte
    private int ditanceFromSource = Integer.MAX_VALUE;
    
    private boolean visited;
    
    private ArrayList<Edge> edges = new ArrayList<Edge>();

  
    
    

    public int getDitanceFromSource() {
        return ditanceFromSource;
    }

    public void setDitanceFromSource(int ditanceFromSource) {
        this.ditanceFromSource = ditanceFromSource;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public void setEdges(ArrayList<Edge> edges) {
        this.edges = edges;
    }
    
    
    
    
    
}
