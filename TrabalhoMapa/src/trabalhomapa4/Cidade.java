package trabalhomapa4;


import java.awt.Color;
import java.awt.Graphics;


public class Cidade implements Desenhavel{
    Integer x,y;
    String nome;

    public Cidade(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Cidade() {
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
    
    @Override
    public void desenhar(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillOval(x, y, 10, 10);
        g.drawString(nome, x+15, y+15);
    }
     @Override
    public void desenharOrigem(Graphics g){
        g.setColor(Color.GREEN);
        g.fillOval(x, y, 10, 10);
    }
     @Override
    public void desenharDestino(Graphics g){
        g.setColor(Color.RED);
        g.fillOval(x, y, 10, 10);
    }
    
}
