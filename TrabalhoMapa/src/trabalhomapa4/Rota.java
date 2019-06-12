package trabalhomapa4;


import java.awt.Color;
import java.awt.Graphics;


public class Rota implements Desenhavel{
    Cidade a, b;
    Integer distancia;
    
    private int fromNodeIndex;
    private int toNodeIndex;
    private int lenght;
    
    public Rota(Cidade a, Cidade b) {
        this.a = a;
        this.b = b;
    }

    public Rota(Cidade a, Cidade b, Integer distancia) {
        this.a = a;
        this.b = b;
        this.distancia = distancia;
    }

    public Rota(int fromNodeIndex, int toNodeIndex, int lenght) {
        this.fromNodeIndex = fromNodeIndex;
        this.toNodeIndex = toNodeIndex;
        this.lenght = lenght;
    }

  
    
    

    public Rota() {
    }

    public Cidade getA() {
        return a;
    }

    public void setA(Cidade a) {
        this.a = a;
    }

    public Cidade getB() {
        return b;
    }

    public void setB(Cidade b) {
        this.b = b;
    }

    public Integer getDistancia() {
        return distancia;
    }

    public void setDistancia(Integer distancia) {
        this.distancia = distancia;
    }

    public int getFromNodeIndex() {
        return fromNodeIndex;
    }

    public void setFromNodeIndex(int fromNodeIndex) {
        this.fromNodeIndex = fromNodeIndex;
    }

    public int getToNodeIndex() {
        return toNodeIndex;
    }

    public void setToNodeIndex(int toNodeIndex) {
        this.toNodeIndex = toNodeIndex;
    }

    

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }
    
    
    
    
//    determines the neighbourinr node of a suplied node, based on the two nodes connected by this Rota
    public Cidade getNeighbourIndex(Cidade nodeIndex){
        if(this.a == nodeIndex){
            return this.b;
        }else{
            return this.a;
        }
    }
    
    
    @Override
    public void desenhar(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawLine(a.x + 5, a.y + 5, b.x + 5, b.y + 5);
    }
    
    @Override
    public void desenharOrigem(Graphics g){
        g.setColor(Color.GREEN);
        g.drawLine(a.x + 15, a.y + 15, b.x + 15, b.y + 15);
    }
    
    @Override
    public void desenharDestino(Graphics g){
        g.setColor(Color.RED);
        g.drawLine(a.x + 15, a.y + 15, b.x + 15, b.y + 15);
    }

    
}
